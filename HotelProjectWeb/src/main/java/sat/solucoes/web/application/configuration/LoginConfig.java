package sat.solucoes.web.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;

import sat.solucoes.web.core.port.in.LoginUseCase;
import sat.solucoes.web.core.usecase.HotelService;
import sat.solucoes.web.core.usecase.LoginService;

@Configuration
public class LoginConfig {

	@Bean
	public LoginUseCase loginService(HotelService hotelService, JwtEncoder jwtEncoder, BCryptPasswordEncoder passwordEncoder) {
		return new LoginService(hotelService, jwtEncoder, passwordEncoder);
	}
	
	
}
