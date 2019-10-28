package manage.backendjava.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import manage.backendjava.security.JwtTokenFilterConfigurer;
import manage.backendjava.security.JwtTokenProvider;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.authorizeRequests().antMatchers("/auth/**").permitAll().anyRequest().authenticated();

    http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/v2/api-docs")//
        .antMatchers("/swagger-resources/**")//
        .antMatchers("/swagger-ui.html")//
        .antMatchers("/configuration/**")//
        .antMatchers("/webjars/**")//
        .antMatchers("/public").and().ignoring().antMatchers("/h2-console/**/**");;
  }

}
