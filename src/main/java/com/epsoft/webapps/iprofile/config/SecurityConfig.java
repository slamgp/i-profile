package com.epsoft.webapps.iprofile.config;

import com.epsoft.webapps.iprofile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import javax.validation.constraints.NotNull;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    public static final String X_AUTH_TOKEN = "X-Auth-Token";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter = fromContext(http,
                RequestHeaderAuthenticationFilter.class);
        http
                .addFilter(requestHeaderAuthenticationFilter)
                .authorizeRequests()
                //   .antMatchers("/welcome").hasRole("ANONYMOUS")
                // .antMatchers(HttpMethod.GET, "/authentication").hasRole("ANONYMOUS")
                //  .antMatchers(HttpMethod.POST, "/authentication").hasRole("ANONYMOUS")
                .anyRequest().permitAll()
                .and()
        //   .httpBasic();
        //  .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
          .csrf().disable()
     //   .httpBasic();

          .formLogin()
          .loginPage("/");
        //  .and();
        //  .httpBasic()
        //  .and()
        //   .anonymous().disable();

    }

    @Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private <T> T fromContext(@NotNull final HttpSecurity http, @NotNull final Class<T> requiredType) {
        @SuppressWarnings("SuspiciousMethodCalls")
        ApplicationContext ctx = (ApplicationContext) http.getSharedObjects().get(ApplicationContext.class);
        return ctx.getBean(requiredType);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(bcryptPasswordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new TokenBasedAuthenticationManager();
    }

    @Bean
    public RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter(final AuthenticationManager authenticationManager) {
        RequestHeaderAuthenticationFilter filter = new MyRequestHeaderAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager);
        filter.setExceptionIfHeaderMissing(false);
        filter.setPrincipalRequestHeader(X_AUTH_TOKEN);
        filter.setInvalidateSessionOnPrincipalChange(true);
        filter.setCheckForPrincipalChanges(true);
        filter.setContinueFilterChainOnUnsuccessfulAuthentication(false);
        return filter;
    }
}
