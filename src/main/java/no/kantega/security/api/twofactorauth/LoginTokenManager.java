/*
 * Copyright 2014 Kantega AS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package no.kantega.security.api.twofactorauth;

import no.kantega.security.api.identity.Identity;

/**
 * Responsible for generating, deleting and verifying <code>LoginToken</code>s.
 */
public interface LoginTokenManager {
    /**
     * Generate a token which can be used to login.
     * @param identity - user which to generate token for
     * @return token
     */
    public LoginToken generateLoginToken(Identity identity);

    /**
     * Delete  tokens for given identity
     * @param identity - user which to generate token for
     */
    public void deleteLoginTokensForIdentity(Identity identity);

    /**
     * Verify <code>LoginToken</code> for identity.
     * @param identity - User which to verify token for.
     * @param token - token needed to Log in.
     * @return <code>LoginTokenVerification.VALID</code> if token was ok,
     *         <code>LoginTokenVerification.INVALID</code> is token was wrong or
     *         <code>LoginTokenVerification.EXPIRED</code> if token is expired.
     */
    public LoginTokenVerification verifyLoginToken(Identity identity, LoginToken token);

}
