package com.lhj.config;


        import com.lhj.service.impl.LoginFailureHandler;
        import com.lhj.service.impl.LoginSuccessHandler;
        import com.lhj.service.impl.MyUserDetailSercice;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Lazy;
        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
        import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private  LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Autowired
    @Lazy
    private MyUserDetailSercice userDetailSercice;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    protected void configure( AuthenticationManagerBuilder auth )throws Exception{
        auth.userDetailsService(userDetailSercice)
                .passwordEncoder(passwordEncoder);
    }

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .httpBasic().disable();
        http.authorizeRequests().antMatchers("/login").permitAll()
                                .antMatchers("/index").permitAll()
                                .antMatchers("/pagee").permitAll()
                                .antMatchers("/brand").hasRole("admin");
//                                    .anyRequest().authenticated();

        http.formLogin().usernameParameter("username").passwordParameter("password")
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)
                .defaultSuccessUrl("/index")
                .permitAll();
        http.exceptionHandling()
                .accessDeniedPage("/pagee");
        http.logout()
                .invalidateHttpSession(true)
                .deleteCookies()
                .logoutSuccessUrl("/login");
        http.rememberMe().rememberMeParameter("remember")
                .and().sessionManagement().maximumSessions(1);
    }
//    @Override
//    protected UserDetailsService userDetailsService() {
//        return userDetailSercice;
//    }
}
