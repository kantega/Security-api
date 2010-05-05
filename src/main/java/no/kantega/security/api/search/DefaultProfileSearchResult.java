package no.kantega.security.api.search;

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

import no.kantega.security.api.profile.Profile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 */
public class DefaultProfileSearchResult implements SearchResult<Profile> {
    List<Profile> results = new ArrayList<Profile>();

    public int getSize() {
        return results.size();
    }

    public Iterator<Profile> getAllResults() {
        return results.iterator();
    }

    public Iterator<Profile> getResults(int offset, int max) {
        if (offset == 0 && max <= results.size()) {
            return getAllResults();
        } else {
            List<Profile> subList = results.subList(offset, offset + max);
            return subList.iterator();
        }
    }

    public void addResult(Profile o) {
        results.add(o);
    }

    public void setResults(List<Profile> results) {
        this.results = results;
    }
}