package sat.solucoes.web.core.port.in;

import java.util.List;

import sat.solucoes.web.core.domain.HotelDomain;

public interface HotelUseCase {

	void create(HotelDomain hotelDomain);
	
	HotelDomain findById(long id);
	
	List<HotelDomain> findAllPaginate(int page, int pageSize);
	
	HotelDomain update(HotelDomain hotelDomain, long id);
	
	void delete(long id);
}
