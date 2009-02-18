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

import java.util.Properties;

/**
 */
public class DefaultAuthenticatedIdentity implements AuthenticatedIdentity {
    private String userId;
    private String domain;
    private String language;
    private Properties rawAttributes = new Properties();
    private IdentityResolver resolver;

    public DefaultAuthenticatedIdentity(IdentityResolver resolver) {
        this.resolver = resolver;
    }

    public String getUserId() {
        return userId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLanguage() {
        return language;
    }

    public Properties getRawAttributes() {
        return rawAttributes;
    }

    public void setRawAttributes(Properties rawAttributes) {
        this.rawAttributes = rawAttributes;
    }

    public IdentityResolver getResolver() {
        return resolver;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String toString(){
        return userId + "@" + language + " # " + rawAttributes;
    }
}
