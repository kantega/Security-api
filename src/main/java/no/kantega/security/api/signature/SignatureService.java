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

public interface SignatureService {

    /**
     * Prepares a signature of a plain text.
     * @param text the String to sign
     * @param signatureContext an instance of SignatureContext
     * @return an assertion that can be used later when calling getSignedDocument() or getSignedDocument()
     * @throws SignatureException if the signing could not be initiated
     */
    String preparePlainTextSignature(String text, SignatureContext signatureContext) throws SignatureException;

    /**
     * Prepares a signature of a plain text.
     * @param pdf the binary representation of the PDF to sign
     * @param signatureContext an instance of SignatureContext
     * @return an assertion that can be used later when calling dispatchSigning() or getSignedDocument()
     * @throws SignatureException if the signing could not be initiated
     */
    String preparePdfSignature(byte [] pdf, SignatureContext signatureContext) throws SignatureException;

    /**
     * Dispatch a
     * @param artifact
     * @throws SignatureException
     */
    void dispatchSigning(String artifact, SignatureDispatchContext context) throws SignatureException;

    /**
     * Returns a SignedDcoument representing the result of the signing that was previously initiated
     * with initiatePlainTextSignature or initiatePdfSignature
     * @param artifact the artifact previously returned from the initiate.. method
     * @return
     * @throws SignatureException
     */
    SignedDocument getSignedDocument(String artifact) throws SignatureException;

    /**
     * Returns this service's id (e.g "bankid")
     * @return the id of the service
     */
    String getSignatureServiceId();


    /**
     * Returns this service's name in a human readable form  (e.g "BankID")
     * @return the id of the service
     */
    String getSignatureServiceName();

}
