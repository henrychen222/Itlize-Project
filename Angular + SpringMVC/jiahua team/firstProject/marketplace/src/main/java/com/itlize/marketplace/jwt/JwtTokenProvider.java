package com.itlize.marketplace.jwt;

import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import com.itlize.marketplace.entities.UserLogin;
import com.itlize.marketplace.repositories.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

  private final String secretKey = "shhhh, it's a secret123";
  private final long validityInMilliseconds = 86400000l;

  @Autowired
  private UserLoginRepository repository;

  public String createToken(Long id) {
    Claims claims = Jwts.claims().setSubject(id.toString());
    Date now = new Date();
    Date validity = new Date(now.getTime() + validityInMilliseconds);
    String encodedSecretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());

    return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity)
        .signWith(SignatureAlgorithm.HS256, encodedSecretKey).compact();
  }

  public Map<String, String> createToken(Long id, boolean getDate) {
    Claims claims = Jwts.claims().setSubject(id.toString());
    Date now = new Date();
    Date validity = new Date(now.getTime() + validityInMilliseconds);
    String encodedSecretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());

    String token = Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity)
        .signWith(SignatureAlgorithm.HS256, encodedSecretKey).compact();
    return new HashMap<String, String>() {
      private static final long serialVersionUID = 4686939099057739364L;
      {
        put("token", token);
        put("expiration", validity.toString());
      }
    };
  }

  public Optional<Jws<Claims>> getClaims(Optional<String> token) {
    if (!token.isPresent()) {
      return Optional.empty();
    }
    String encodedSecretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    return Optional.of(Jwts.parser().setSigningKey(encodedSecretKey).parseClaimsJws(token.get()));
  }

  public Authentication getAuthentication(String token) {
    UserLogin userLogin = repository.findById(getId(token)).orElse(null);
    GrantedAuthority auth = () -> "USER";
    return new UsernamePasswordAuthenticationToken(userLogin, "", Arrays.asList(auth));
  }

  public Long getId(String token) {
    String encodedSecretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    String id =
        Jwts.parser().setSigningKey(encodedSecretKey).parseClaimsJws(token).getBody().getSubject();
    return Long.parseLong(id);
  }

  public String resolveToken(HttpServletRequest req) {
    String bearerToken = req.getHeader("Authorization");
    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7, bearerToken.length());
    }
    return null;
  }

  public boolean validateToken(String token) {
    String encodedSecretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    try {
      Jwts.parser().setSigningKey(encodedSecretKey).parseClaimsJws(token);
      return true;
    } catch (JwtException | IllegalArgumentException e) {
      throw new RuntimeException("Expired or invalid JWT token");
    }
  }

}
