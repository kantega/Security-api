package no.kantega.security.api.twofactorauth;

import no.kantega.security.api.profile.Profile;

/**
 * Responsible for sending <code>LoginToken</code>s to the user.
 */
public interface LoginTokenSender {
    /**
     * Send token to the user.
     * @param profile representing the user that needs <code>LoginToken</code>.
     * @param loginToken to send to the user.
     */
    public void sendTokenToUser(Profile profile, LoginToken loginToken);
}
