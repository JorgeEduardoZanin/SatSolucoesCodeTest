package sat.solucoes.web.core.port.out;

import sat.solucoes.web.core.domain.HotelDomain;

public interface HotelRepository {

	void create(HotelDomain hotelDomain);
	
}
