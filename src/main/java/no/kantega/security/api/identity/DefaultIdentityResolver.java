package no.kantega.security.api.identity;

/*
 * Copyright 2009 Kantega AS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.io.IOException;

/**
 */
public class DefaultIdentityResolver implements IdentityResolver {
    private String authenticationContext = "";
    private String authenticationContextIconUrl = "";
    private String authenticationContextDescription = "HttpSession";
    private String loginPageUrl = "";
    private boolean useTransportSecurity = false;

    public static String SESSION_IDENTITY_NAME = "KANTEGA_HTTPSESSION_IDENTITY";
    public static String SESSION_IDENTITY_DOMAIN = "KANTEGA_HTTPSESSION_IDENTITY_DOMAIN";

    /**
     * Looks up identity in session, if not found in session,
     * checks request.getUserPrincipal then request.getRemoteUser
     * @param request
     * @return
     * @throws IdentificationFailedException
     */
    public AuthenticatedIdentity getIdentity(HttpServletRequest request) throws IdentificationFailedException {
        HttpSession session = request.getSession();
        if (session == null) {
            return null;
        }

        DefaultAuthenticatedIdentity authenticatedIdentity = null;
        String identity = (String)session.getAttribute(authenticationContext + SESSION_IDENTITY_NAME);
        if (identity == null) {
            if (request.getUserPrincipal() != null) {
                identity = request.getUserPrincipal().getName();
            }
            if (request.getRemoteUser() != null) {
                identity = request.getRemoteUser();
            }
            if (identity != null && identity.length() > 0) {
                int inx = identity.lastIndexOf("@");
                if (inx != -1) {
                    identity = identity.substring(0, inx);
                    identity = identity.toLowerCase();
                }
            }
        }

        if (identity != null && identity.length() > 0) {
            int inx = identity.indexOf("\\");
            if (inx != -1) {
                identity = identity.substring(inx + 1, identity.length());
                identity = identity.toLowerCase();
            }

            authenticatedIdentity = new DefaultAuthenticatedIdentity(this);

            String domain = (String)session.getAttribute(authenticationContext + SESSION_IDENTITY_DOMAIN);
            if (domain != null) {
                authenticatedIdentity.setDomain(domain);
            } else {
                authenticatedIdentity.setDomain(authenticationContext);
            }

            authenticatedIdentity.setUserId(identity);
        }

        return authenticatedIdentity;
    }


    public void initateLogin(LoginContext loginContext) {
        String targetUrl = "/";
        if (loginContext.getTargetUri() != null) {
            targetUrl = loginContext.getTargetUri().toASCIIString();
            targetUrl = targetUrl.replaceAll("<", "");
            targetUrl = targetUrl.replaceAll(">", "");
        }

        HttpServletRequest request = loginContext.getRequest();

        String redirectUrl = loginPageUrl;
        // Absolutify urls relative to context path
        if(!redirectUrl.startsWith("http") && !redirectUrl.startsWith("/")) {
            redirectUrl = request.getContextPath() + "/" + loginPageUrl;
        }

        // For relative links switch to HTTPS if specified
        if (!redirectUrl.startsWith("http") && ! request.isSecure() && useTransportSecurity) {
            redirectUrl = "https://" +  request.getServerName() + loginPageUrl;
        }

        if (redirectUrl.indexOf("?") > 0) {
            redirectUrl += "&redirect=";
        } else {
            redirectUrl += "?redirect=";
        }

        try {
            loginContext.getResponse().sendRedirect(redirectUrl + URLEncoder.encode(targetUrl, "UTF-8"));
        } catch (IOException e) {
            //
        }
    }


    public void initiateLogout(LogoutContext logoutContext) {
        HttpSession session = logoutContext.getRequest().getSession();
        if (session != null) {
            session.removeAttribute(authenticationContext + SESSION_IDENTITY_NAME);
        }
        String targetUrl = "/";
        if (logoutContext.getTargetUri() != null) {
            targetUrl = logoutContext.getTargetUri().toASCIIString();
            targetUrl = targetUrl.replaceAll("<", "");
            targetUrl = targetUrl.replaceAll(">", "");
        }

        try {
            logoutContext.getResponse().sendRedirect(targetUrl);
        } catch (IOException e) {
            //
        }
    }

    public String getAuthenticationContext() {
        return authenticationContext;
    }

    public String getAuthenticationContextDescription() {
        return authenticationContextIconUrl;
    }

    public String getAuthenticationContextIconUrl() {
        return authenticationContextDescription;
    }

    public void setAuthenticationContext(String authenticationContext) {
        this.authenticationContext = authenticationContext;
    }

    public void setAuthenticationContextIconUrl(String authenticationContextIconUrl) {
        this.authenticationContextIconUrl = authenticationContextIconUrl;
    }

    public void setAuthenticationContextDescription(String authenticationContextDescription) {
        this.authenticationContextDescription = authenticationContextDescription;
    }

    public void setLoginPageUrl(String loginPageUrl) {
        this.loginPageUrl = loginPageUrl;
    }

    public void setUseTransportSecurity(boolean useTransportSecurity) {
        this.useTransportSecurity = useTransportSecurity;
    }

    public void setUseTransportSecurity(String useTransportSecurity) {
        this.useTransportSecurity = Boolean.valueOf(useTransportSecurity).booleanValue();
    }

}
