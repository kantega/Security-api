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
     * @return true if token was ok, false is token was wrong or expired.
     */
    public boolean verifyLoginToken(Identity identity, LoginToken token);

}
