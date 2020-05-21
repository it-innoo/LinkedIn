package projekti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DevelopmentSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    /*
    @Override
    public void configure(WebSecurity sec) throws Exception {
        // Pyyntöjä ei tarkasteta
        sec.ignoring().antMatchers("/**");
    }
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .ignoringAntMatchers("/h2-console/**");
        http.headers()
                .frameOptions()
                .sameOrigin();
        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/registration").permitAll()
                .anyRequest().authenticated();
        http.formLogin()
                .permitAll();
                //.loginPage("login");
        http.logout().permitAll();
    }

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("jukka").password(passwordEncoder().encode("salainen")).roles("USER")
                .and()
                .withUser("ukko").password(passwordEncoder().encode("salainen")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("sekret")).roles("ADMIN");
    }
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
