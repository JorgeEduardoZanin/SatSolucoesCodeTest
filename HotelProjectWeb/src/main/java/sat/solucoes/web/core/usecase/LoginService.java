package sat.solucoes.web.core.usecase;

import java.time.Instant;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import sat.solucoes.web.core.domain.LoginDomain;
import sat.solucoes.web.core.exception.LoginException;
import sat.solucoes.web.core.exception.enums.ExceptionLoginType;
import sat.solucoes.web.core.port.in.LoginUseCase;

public class LoginService implements LoginUseCase {

	private final HotelService hotelService;
	private final JwtEncoder jwtEncoder;
	private final BCryptPasswordEncoder passwordEncoder;

	public LoginService(HotelService hotelService, JwtEncoder jwtEncoder, BCryptPasswordEncoder passwordEncoder) {
		this.hotelService = hotelService;
		this.jwtEncoder = jwtEncoder;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public LoginDomain login(LoginDomain login) {
		
		var hotelLogin = hotelService.findHotelByEmail(login.getEmail());

		 if (!hotelLogin.isLoginCorrect(passwordEncoder, login)) {
	            throw new LoginException(ExceptionLoginType.INVALID_PASSWORD_OR_EMAIL);
	        }


	        var now = Instant.now();
	        var expiresIn = 10000L;

	        var claims = JwtClaimsSet.builder()
	                .issuer("mybackend")
	                .subject(hotelLogin.getId().toString())
	                .issuedAt(now)
	                .expiresAt(now.plusSeconds(expiresIn))
	                .build();

	        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	        
	        LoginDomain loginResponse = new LoginDomain();
	        loginResponse.setToken(jwtValue);
	        loginResponse.setExpireIn(expiresIn);
	        	      
	        return loginResponse;
		
	}

}
