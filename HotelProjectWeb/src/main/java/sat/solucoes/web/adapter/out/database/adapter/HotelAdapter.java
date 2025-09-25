package sat.solucoes.web.adapter.out.database.adapter;

import sat.solucoes.web.adapter.mapper.HotelMapper;
import sat.solucoes.web.adapter.out.database.repository.HotelDatabaseRepository;
import sat.solucoes.web.core.domain.HotelDomain;
import sat.solucoes.web.core.port.out.HotelRepository;

public class HotelAdapter implements HotelRepository{

	private final HotelDatabaseRepository hotelDatabaseRepository;
	
	public HotelAdapter(HotelDatabaseRepository hotelDatabaseRepository) {
		this.hotelDatabaseRepository = hotelDatabaseRepository;
	}

	@Override
	public void create(HotelDomain hotelDomain) {
		hotelDatabaseRepository.save(HotelMapper.hotelDomainToHotelEntity(hotelDomain));
		
	}

}
