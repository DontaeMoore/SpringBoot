package com.TB_Challenge.security;

import com.TB_Challenge.authorization.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.TB_Challenge.security.ApplicationUserRole.ADMIN;
import static com.TB_Challenge.security.ApplicationUserRole.OFFICER;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    public final PasswordEncoder passwordEncoder;
    public final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService){
        this.passwordEncoder = NoOpPasswordEncoder.getInstance();
        this.applicationUserService = applicationUserService;
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
               .antMatchers("/", "index","/home", "/css*", "/js/*", "/resources/**", "/forgot", "/saveForget", "/passwordReset", "/saveUser").permitAll()
               .antMatchers("/admin").hasRole(ADMIN.name())
               .antMatchers("/editRace","/addRace", "/deleteRace", "/editChallenge","/addChallenge","/deleteChallenge",
                       "/editRaceHorse","/addRaceHorse","/deleteRaceHorse").hasAnyRole(OFFICER.name(), ADMIN.name())
               .anyRequest()
               .authenticated()
               .and()
               .formLogin();


    }

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails annaSmithUser = User.builder()
//                .username("annasmith")
//                .password(passwordEncoder.encode("password"))
//                .roles("STUDENT") //ROLE_STUDENT
//               .build();
//
//       return new InMemoryUserDetailsManager(
//               annaSmithUser
//       );
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }



}
