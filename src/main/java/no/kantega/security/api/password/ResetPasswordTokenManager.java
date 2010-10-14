package no.kantega.security.api.password;

import no.kantega.security.api.common.SystemException;
import no.kantega.security.api.identity.Identity;

import java.util.Date;


public interface ResetPasswordTokenManager {
    /**
     * Generate a token which can be used to reset a password
     * @param identity - user which to generate key for
     * @param tokenExpireDate - Date when token should expire
     * @return token
     * @throws no.kantega.security.api.common.SystemException
     */
    public ResetPasswordToken generateResetPasswordToken(Identity identity, Date tokenExpireDate) throws SystemException;

    /**
     * Delete  tokens for given identity
     * @param identity - user which to generate key for
     * @return token
     * @throws no.kantega.security.api.common.SystemException
     */
    public void deleteTokensForIdentity(Identity identity) throws SystemException;

    /**
     * Reset a password for a user using a key which was sent using email, sms etc
     * @param identity - User which to reset password for
     * @param token - token needed to reset password
     * @return true if token was ok, false is token was wrong or expired
     * @throws SystemException
     */
    public boolean verifyPasswordToken(Identity identity, ResetPasswordToken token) throws SystemException;

}
