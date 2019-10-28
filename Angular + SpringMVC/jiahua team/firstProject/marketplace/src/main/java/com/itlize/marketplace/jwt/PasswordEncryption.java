package com.itlize.marketplace.jwt;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncryption {

  public boolean authenticate(String attemptedPassword, String encryptedPassword, String salt)
      throws NoSuchAlgorithmException, InvalidKeySpecException {

    String encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);
    return encryptedPassword.equals(encryptedAttemptedPassword);
  }

  public String getEncryptedPassword(String password, String salt)
      throws NoSuchAlgorithmException, InvalidKeySpecException {
    String algorithm = "PBKDF2WithHmacSHA1";
    int derivedKeyLength = 160;
    int iterations = 20000;
    char[] pwd = new String(password).toCharArray();
    KeySpec spec =
        new PBEKeySpec(pwd, Base64.getDecoder().decode(salt), iterations, derivedKeyLength);
    SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);
    byte[] bytes = f.generateSecret(spec).getEncoded();
    return Base64.getEncoder().encodeToString(bytes);
  }

  public String generateSalt() throws NoSuchAlgorithmException {
    SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
    byte[] salt = new byte[8];
    random.nextBytes(salt);
    return Base64.getEncoder().encodeToString(salt);
  }

}
