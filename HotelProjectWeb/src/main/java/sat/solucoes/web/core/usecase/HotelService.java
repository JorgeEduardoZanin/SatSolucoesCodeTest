package sat.solucoes.web.core.usecase;

import java.util.List;

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

	@Override
	public HotelDomain findById(long id) {
		var response = hotelRepository.findById(id);
		return response;
	}

	@Override
	public List<HotelDomain> findAllPaginate(int page, int pageSize) {
		var response  = hotelRepository.findAllPaginate(page, pageSize);
		return response;
	}

	@Override
	public HotelDomain update(HotelDomain hotelDomain, long id) {
		
		var domain = hotelRepository.findById(id);
		domain.setAddress(hotelDomain.getAddress());
		domain.setCity(hotelDomain.getCity());
		domain.setNumber(hotelDomain.getNumber());
		domain.setState(hotelDomain.getState());
		domain.setEmail(hotelDomain.getEmail());
		
		var response = hotelRepository.update(domain);
		
		return response;
	}

	@Override
	public void delete(long id) {
		hotelRepository.delete(id);
		
	}
	
	public HotelDomain findHotelByEmail(String email) {
		var domain = hotelRepository.findHotelByEmail(email);
		return domain;
	}

	
}
