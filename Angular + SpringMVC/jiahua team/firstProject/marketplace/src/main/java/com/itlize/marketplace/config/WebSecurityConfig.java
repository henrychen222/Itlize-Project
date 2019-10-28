package com.itlize.marketplace.config;

import com.itlize.marketplace.jwt.JwtTokenFilterConfigurer;
import com.itlize.marketplace.jwt.JwtTokenProvider;
import com.itlize.marketplace.jwt.MyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@Order(SecurityProperties.DEFAULT_FILTER_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private MyAuthenticationProvider authProvider;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.httpBasic().and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
        .antMatchers("/auth/**", "/v2/api-docs", "/swagger-resources/configuration/ui",
            "/swagger-resources", "/swagger-resources/configuration/security", "/swagger-ui.html",
            "/webjars/**")
        .permitAll().anyRequest().authenticated().and()
        .apply(new JwtTokenFilterConfigurer(jwtTokenProvider)).and().csrf().disable();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authProvider);
  }

}
