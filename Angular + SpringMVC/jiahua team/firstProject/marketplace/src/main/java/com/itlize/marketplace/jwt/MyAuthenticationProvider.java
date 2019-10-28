package com.itlize.marketplace.jwt;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.List;
import com.itlize.marketplace.entities.UserLogin;
import com.itlize.marketplace.repositories.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  private PasswordEncryption passwordEncryption;

  @Autowired
  private UserLoginRepository userLoginRepository;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String name = authentication.getName();
    String password = authentication.getCredentials().toString();

    UserLogin user = null;
    List<UserLogin> users = userLoginRepository.findByEmail(name);
    if (users.size() == 1) {
      user = users.get(0);
    } else {
      users = userLoginRepository.findByUsername(name);
      if (users.size() == 1) {
        user = users.get(0);
      }
    }

    String encryptedPw = null;
    if (user == null) {
      throw new BadCredentialsException("User not found");
    }
    try {
      encryptedPw = this.passwordEncryption.getEncryptedPassword(password, user.getSalt());
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      log.error("Password decrytion error: ", e);
    }
    if (encryptedPw == null || !encryptedPw.equals(user.getPassword())) {
      throw new AuthenticationCredentialsNotFoundException("User: " + name + " not found.");
    }
    log.info("User: " + name + " logged in.");

    GrantedAuthority auth = () -> "USER";
    return new UsernamePasswordAuthenticationToken(name, password, Arrays.asList(auth));
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }

}
