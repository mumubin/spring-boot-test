package config.authority;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by hzhubin15 on 2016/8/23.
 */
//@EnableOAuth2Sso
//@Configuration
public class OAuthConfig extends WebSecurityConfigurerAdapter{
//
//	//认证相关
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// @formatter:off
//		http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**").permitAll().anyRequest()
//				.authenticated().and().logout().logoutSuccessUrl("/").permitAll().and().csrf()
//				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//		// @formatter:on
//	}
//
//	@RequestMapping("/user")
//	public Principal user(Principal principal) {
//		return principal;
//	}
}
