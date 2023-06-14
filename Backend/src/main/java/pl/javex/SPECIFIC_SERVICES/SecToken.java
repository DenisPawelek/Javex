package pl.javex.SPECIFIC_SERVICES;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("TOKEN")
@RequestMapping("T/T")
public class SecToken {

	private final JwtEncoder jwtEncoder;

	public SecToken(JwtEncoder jwtEncoder) {
		this.jwtEncoder = jwtEncoder;
	}
	
	
	@PostMapping("/token")
	public String token(Authentication auth) {
		
		Instant now = Instant.now();
		
		String scope = auth.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(" "))
				;
		JwtClaimsSet claims = JwtClaimsSet.builder()
				.issuer("self")
				.issuedAt(now)
				.expiresAt(now.plus(1000, ChronoUnit.MINUTES))
				.subject(auth.getName())
				.claim("scope", scope)
				.build()
				;
		return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
		
	
	}
	
	
}
