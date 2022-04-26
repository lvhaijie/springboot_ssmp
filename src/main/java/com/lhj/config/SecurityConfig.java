package com.lhj.config;


        import com.lhj.service.impl.LoginFormHandler;
        import com.lhj.service.impl.MyUserDetailSercice;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Lazy;
        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    LoginFormHandler loginFormHandler;
    @Autowired
    @Lazy
    private MyUserDetailSercice userDetailSercice;

//    @Override
//    protected void configure( AuthenticationManagerBuilder auth )throws Exception{
//        auth.userDetailsService(userDetailSercice)
//                .passwordEncoder(passwordEncoder());
//    }

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
                                .antMatchers("/brand").hasAnyAuthority("2");

//                .antMatchers("/brand").hasRole("vip");
        http.formLogin().usernameParameter("username").passwordParameter("password")
                .loginProcessingUrl("/login")
                .loginPage("/login")
//                .defaultSuccessUrl("/login")
                .successForwardUrl("/index")
//                .failureHandler(loginFormHandler)
//                .successHandler(loginFormHandler)
                .permitAll();
        http.logout().logoutSuccessUrl("/login");
        http.rememberMe().rememberMeParameter("remember")
                .and().sessionManagement().maximumSessions(1);
    }
    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailSercice;
    }
}
