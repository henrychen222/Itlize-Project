package manage.backendjava.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JwtTokenFilterConfigurer
    extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

  private JwtTokenProvider jwtTokenProvider;

  @Override
  public void configure(HttpSecurity builder) throws Exception {
    JwtTokenFilter customFilter = new JwtTokenFilter(jwtTokenProvider);
    builder.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
  }

}
