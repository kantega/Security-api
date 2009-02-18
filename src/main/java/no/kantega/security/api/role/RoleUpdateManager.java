package no.kantega.security.api.role;

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
public interface RoleUpdateManager {
    void deleteRole(RoleId roleId) throws SystemException;
    void saveOrUpdateRole(Role role) throws SystemException;
    void addUserToRole(Identity identity, RoleId roleId) throws SystemException;
    void removeUserFromRole(Identity identity, RoleId roleId) throws SystemException;
    void removeUserFromAllRoles(Identity identity) throws SystemException;
}
