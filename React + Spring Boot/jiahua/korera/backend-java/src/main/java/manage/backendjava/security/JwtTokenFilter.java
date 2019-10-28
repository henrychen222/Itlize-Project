package manage.backendjava.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

  private JwtTokenProvider jwtTokenProvider;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    String token = jwtTokenProvider.resolveToken(request);
    try {
      if (token != null && jwtTokenProvider.validateToken(token)) {
        Authentication auth = jwtTokenProvider.getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
      }
    } catch (Exception e) {
      SecurityContextHolder.clearContext();
      response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    filterChain.doFilter(request, response);
  }

}
