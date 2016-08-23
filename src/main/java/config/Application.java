package config;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by hzhubin15 on 2016/8/19.
 */
@SpringBootApplication
//@EnableScheduling
//@ComponentScan
@EnableAutoConfiguration
//@EnableMmb
@RestController
@EnableOAuth2Sso
public class Application extends WebSecurityConfigurerAdapter {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@Profile("logger")
	public StartupRunner schedulerRunner() {
		return new StartupRunner();
	}

	@Bean
	public CommandLineRunner configValuePrinter(@Value("${my.config.value:}") String configValue) {
		return args -> LogFactory.getLog(getClass()).info("Value of my.config.value property is: " + configValue);
	}

	//认证相关
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**").permitAll().anyRequest()
				.authenticated().and().logout().logoutSuccessUrl("/").permitAll().and().csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		// @formatter:on
	}

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}
}
