package BackEnd.CountriesAirlines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;
	
	

    @Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        
		http
		
			.authorizeHttpRequests(authorize -> authorize
			.requestMatchers("/").permitAll()
			.requestMatchers("/countries").permitAll()
			.requestMatchers("/airlines").permitAll()
			.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
			.anyRequest()
			.authenticated())
			.formLogin(formlogin -> formlogin
			.loginPage("/login")
			.defaultSuccessUrl("/countries", true)
			.permitAll())
			.logout(logout -> logout
			.permitAll())

			.csrf(csrf -> csrf
            .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")));
			
		return http.build();

		}

	

    @Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
auth.userDetailsService(userDetailsService).passwordEncoder(new
BCryptPasswordEncoder());
}
}
