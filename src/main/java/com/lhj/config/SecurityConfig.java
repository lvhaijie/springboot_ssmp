package com.lhj.config;


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
    @Lazy
    private MyUserDetailSercice userDetailSercice;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure( AuthenticationManagerBuilder auth )throws Exception{
        auth.userDetailsService(userDetailSercice)
                .passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
                                .antMatchers("/brand").hasAnyAuthority("2");

//                .antMatchers("/brand").hasRole("vip");
        http.formLogin().usernameParameter("username").passwordParameter("password")
                .loginPage("/login")
                .failureUrl("/login")
                .defaultSuccessUrl("/index")
                .loginProcessingUrl("/login");
        http.logout().logoutSuccessUrl("/login")
                .and().csrf().disable();
        http.rememberMe().rememberMeParameter("remember")
                .and().sessionManagement().maximumSessions(1);

    }

}
