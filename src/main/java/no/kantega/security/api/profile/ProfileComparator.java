package no.kantega.security.api.profile;

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

import java.util.Comparator;

/**
 */
public class ProfileComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        int c = ((Profile) o1).getGivenName().compareTo(((Profile) o2).getGivenName());
        if (c != 0) {
            return c;
        }
        return ((Profile) o1).getSurname().compareTo(((Profile) o2).getSurname());
    }
}
