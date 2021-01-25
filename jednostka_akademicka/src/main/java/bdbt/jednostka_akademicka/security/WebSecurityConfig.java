package bdbt.jednostka_akademicka.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
        http.authorizeRequests()
                .antMatchers("/sing-up").hasRole("ADMIN")
                .antMatchers("/uzytkownicy/").hasRole("ADMIN")
                .antMatchers("/uczelnie/edit/{nrUczelni}").hasRole("ADMIN")
                .antMatchers("/uczelnie/nowa-uczelnia").hasRole("ADMIN")
                .antMatchers("/uczelnie/delete/{id}").hasRole("ADMIN")
                .antMatchers("/rektorzy/edit/{nrRektora}").hasRole("ADMIN")
                .antMatchers("/rektorzy/nowy-rektor").hasRole("ADMIN")
                .antMatchers("/rektorzy/delete/{id}").hasRole("ADMIN")

                .antMatchers("/studenci/student/{id}").hasRole("STUDENT")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
    }
}
