package no.kantega.security.api.twofactorauth;

/**
 * Default implementation of <code>LoginToken</code>,
 * simply allows creation of a string token.
 */
public class DefaultLoginToken implements LoginToken {
    private final String token;

    public DefaultLoginToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
