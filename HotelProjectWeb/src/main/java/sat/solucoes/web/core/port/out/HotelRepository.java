package sat.solucoes.web.core.port.out;

import java.util.List;

import sat.solucoes.web.core.domain.HotelDomain;

public interface HotelRepository {

	void create(HotelDomain hotelDomain);
	
	HotelDomain findById(long id);
	
	List<HotelDomain> findAllPaginate(int page, int pageSize);
	
	HotelDomain update(HotelDomain hotelDomain);
	
	void delete(long id);
	
	HotelDomain findHotelByEmail(String email);
	
}
