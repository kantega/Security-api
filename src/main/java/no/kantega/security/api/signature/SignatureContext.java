package no.kantega.security.api.signature;

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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;


public interface SignatureContext {

    HttpServletRequest getRequest();

    HttpServletResponse getResponse();

    /**
     * Returns a description of the document to sign.
     * This will be application specific.
     * The signature service may precent this to the user as part of the signature process.
     * Example: "Application for new pet in Trondheim"
     * @return the description
     */
    String getDescription();

}
