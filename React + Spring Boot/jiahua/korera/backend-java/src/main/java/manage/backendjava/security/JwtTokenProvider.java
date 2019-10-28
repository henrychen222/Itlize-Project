package manage.backendjava.security;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import manage.backendjava.entities.UserEntity;
import manage.backendjava.repositories.UserRepository;

@Component
public class JwtTokenProvider {

  private final String secretKey = "zheshi ge mimi";
  private final long validityInMilliseconds = 3600000;

  @Autowired
  private UserRepository userRepository;

  public String createToken(String username, List<Role> roles) {
    Claims claims = Jwts.claims().setSubject(username);
    claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority()))
        .filter(Objects::nonNull).collect(Collectors.toList()));

    Date now = new Date();
    Date validity = new Date(now.getTime() + validityInMilliseconds);
    return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity)
        .signWith(SignatureAlgorithm.HS256, secretKey).compact();
  }

  public Authentication getAuthentication(String token) {
    UserEntity userEntity = userRepository.findByUsername(getUsername(token)).get(0);
    return new UsernamePasswordAuthenticationToken(userEntity, "", userEntity.getRoles());
  }

  public String getUsername(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
  }

  public String resolveToken(HttpServletRequest req) {
    String bearerToken = req.getHeader("Authorization");
    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7, bearerToken.length());
    }
    return null;
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
      return true;
    } catch (JwtException | IllegalArgumentException e) {
      throw new RuntimeException("Expired or invalid JWT token");
    }
  }

}
