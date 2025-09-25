package sat.solucoes.web.core.usecase;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sat.solucoes.web.core.domain.HotelDomain;
import sat.solucoes.web.core.port.in.HotelUseCase;
import sat.solucoes.web.core.port.out.HotelRepository;

public class HotelService implements HotelUseCase {

	private final BCryptPasswordEncoder passwordEncoder;
	
	private final HotelRepository hotelRepository;
	
	public HotelService(BCryptPasswordEncoder passwordEncoder, HotelRepository hotelRepository) {
		this.passwordEncoder = passwordEncoder;
		this.hotelRepository = hotelRepository;
	}

	@Override
	public void create(HotelDomain hotelDomain) {
		
		hotelDomain.setPassword(passwordEncoder.encode(hotelDomain.getPassword()));
		
		hotelRepository.create(hotelDomain);
	}

}
