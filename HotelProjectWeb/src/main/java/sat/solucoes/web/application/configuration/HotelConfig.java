package sat.solucoes.web.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sat.solucoes.web.core.port.in.HotelUseCase;
import sat.solucoes.web.core.port.out.HotelRepository;
import sat.solucoes.web.core.usecase.HotelService;

@Configuration
public class HotelConfig {

	@Bean
	public HotelUseCase hotelUseCase(BCryptPasswordEncoder passwordEncoder, HotelRepository hotelRepository) {
		return new HotelService(passwordEncoder, hotelRepository);
	}
	
}
