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

public interface SignedDocument {
    /**
     * Returns the binary signed object
     * @return the blob
     */
    byte[] getContent();

    /**
     * Returns the content type of the signature object. Could be something like
     * "application/x-pkcs7-signature"
     * @return the content type
     */
    String getType();

    /**
     * Returns the preferred file siffix, without the "." of this document.
     * Will typically be something like ".sdo" or ".pkcs7"
     * Applications that saves signed documents as files may use this to generate a file name
     * @return the suffix
     */
    String getFileSuffix();
}
