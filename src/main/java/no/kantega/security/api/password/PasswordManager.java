package no.kantega.security.api.password;

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

import no.kantega.security.api.identity.Identity;
import no.kantega.security.api.common.SystemException;

/**
 */
public interface PasswordManager {
    /**
     * Verify a users password
     * @param identity
     * @param password
     * @return
     * @throws SystemException
     */
    public boolean verifyPassword(Identity identity, String password) throws SystemException;


    /**
     * Set / change password for a user
     * @param identity
     * @param oldPass
     * @param newPass
     * @throws SystemException
     */
    public void setPassword(Identity identity, String oldPass, String newPass) throws SystemException;


    /**
     * Indicate if it is possible to change users passwords
     * @return true if user can change password, false if not
     */
    public boolean supportsPasswordChange();

    /**
     *
     * @return the domain which this manager can verify passwords for
     */
    public String getDomain();
}
