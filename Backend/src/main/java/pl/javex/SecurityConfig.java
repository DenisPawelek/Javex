package pl.javex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import pl.javex.MODELS.UserM;
import pl.javex.SPECIFIC_SERVICES.UserService;
import services.GenericService;

import pl.javex.UTYLITIES.CODER;
 
import org.springframework.security.config.Customizer;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private UserService user_s;
		private final RsaKeyProp rsaKeys;		public SecurityConfig(RsaKeyProp rsaK) {		this.rsaKeys = rsaK;	}	
//
//	@Bean
//	public UserDetails user() {
////		return new InMemoryUserDetailsManager(
////				User.withUsername("bob")
////						.password(passwordEncoder().encode("password"))
////						.authorities("read")
////						.build()
////				
////				);
//		return()
//		
//	}
//	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{	
		auth.userDetailsService(user_s);
	}	
	

	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.cors();
		
		httpSecurity
		.csrf(csrf->csrf.disable())
		.authorizeRequests(auth -> auth
				.antMatchers("/m/**","/jpq/**","/T/TU/register").permitAll()
				.antMatchers("/T/TT/","T/TU/**").hasAnyRole("ROLE_USER")
				.antMatchers("*/**").hasAnyRole("ROLE_ARMIN")
				.anyRequest().authenticated()

				
		)
		.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.httpBasic(Customizer.withDefaults())
		;
		
	}
	@Bean	public JwtDecoder jwtDecoder() {		return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();	}	@Bean	public JwtEncoder jwtEncoder() {		JWK jwk = new RSAKey.Builder(rsaKeys.publicKey()).privateKey(rsaKeys.privateKey()).build();		JWKSource<SecurityContext> jwkSecurityContext = new ImmutableJWKSet<>(new JWKSet(jwk));		return new NimbusJwtEncoder(jwkSecurityContext);	}	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return CODER._GET_INSTANCE().getCoder();
//		return new BCryptPasswordEncoder();	}
}
