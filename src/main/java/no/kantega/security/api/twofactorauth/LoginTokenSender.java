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

import no.kantega.security.api.common.SystemException;
import no.kantega.security.api.profile.Profile;

/**
 * Responsible for sending <code>LoginToken</code>s to the user.
 */
public interface LoginTokenSender {
    /**
     * Send token to the user.
     * @param profile representing the user that needs <code>LoginToken</code>.
     * @param loginToken to send to the user.
     * @throws no.kantega.security.api.common.SystemException when sending of <code>LoginToken</code> failes.
     * @throws java.lang.IllegalArgumentException when the property specifying the recipient is missing.
     */
    public void sendTokenToUser(Profile profile, LoginToken loginToken) throws IllegalArgumentException, SystemException;
}
