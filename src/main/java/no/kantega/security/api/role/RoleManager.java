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

import no.kantega.security.api.search.SearchResult;
import no.kantega.security.api.identity.Identity;
import no.kantega.security.api.common.SystemException;

import java.util.Iterator;

/**
 */
public interface RoleManager {
    Iterator getAllRoles() throws SystemException;
    SearchResult searchRoles(String query) throws SystemException;
    Role getRoleById(RoleId roleId) throws SystemException;
    Iterator getRolesForUser(Identity identity) throws SystemException;
    Iterator getUsersWithRole(RoleId roleId) throws SystemException;
    boolean userHasRole(Identity identity, String roleId) throws SystemException;
}
