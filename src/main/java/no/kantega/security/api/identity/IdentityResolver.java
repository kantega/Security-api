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

public interface IdentityResolver {

    /**
     * Resolves an authenticated user from the session attributes
     *
     * @param request
     * @return information about the authenticated user or null if there is no authenticated session
     */
    AuthenticatedIdentity getIdentity(HttpServletRequest request) throws IdentificationFailedException;

    /**
     * Initiate the login proxess. This call will create a http response to the user.
     * The user will be redirected to the  when he is logged in, or after the login process failed.
     *
     * @param loginContext Context with http request and response
     */
    void initateLogin(LoginContext loginContext);

    /**
     * Single logout
     *
     * @param logoutContext
     */
    void initiateLogout(LogoutContext logoutContext);

    /**
     * Returns the authentication method used.
     *
     * @return the method
     */
    String getAuthenticationContext();

    /**
     * Human readable version of the authentication context.
     * May be used like: user is logged in with "MinID" where MinID would equal getAuthenticationContextDescription()
     * @return the human readable context name
     */
    String getAuthenticationContextDescription();

    String getAuthenticationContextIconUrl();


}
