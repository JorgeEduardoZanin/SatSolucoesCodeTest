package sat.solucoes.web.adapter.out.database.adapter;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import sat.solucoes.web.adapter.mapper.HotelMapper;
import sat.solucoes.web.adapter.out.database.repository.HotelDatabaseRepository;
import sat.solucoes.web.core.domain.HotelDomain;
import sat.solucoes.web.core.port.out.HotelRepository;

@Component
public class HotelAdapter implements HotelRepository{

	private final HotelDatabaseRepository hotelDatabaseRepository;
	
	public HotelAdapter(HotelDatabaseRepository hotelDatabaseRepository) {
		this.hotelDatabaseRepository = hotelDatabaseRepository;
	}

	@Override
	public void create(HotelDomain hotelDomain) {
		hotelDatabaseRepository.save(HotelMapper.hotelDomainToHotelEntity(hotelDomain));
		
	}

	@Override
	public HotelDomain findById(long id) {
		var response = hotelDatabaseRepository.findById(id)
			.orElseThrow();
		return HotelMapper.hotelEntityToHotelDomain(response);
	}

	@Override
	public List<HotelDomain> findAllPaginate(int page, int pageSize) {
		hotelDatabaseRepository.findAllPaginated(PageRequest.of(page, pageSize, Sort.Direction.ASC, "name"));
		return null;
	}

	@Override
	public HotelDomain update(HotelDomain hotelDomain) {
		var response = hotelDatabaseRepository.saveAndFlush(HotelMapper.hotelDomainToHotelEntity(hotelDomain));
		return HotelMapper.hotelEntityToHotelDomain(response);
	}

	@Override
	public void delete(long id) {
		hotelDatabaseRepository.deleteById(id);
	}

	@Override
	public HotelDomain findHotelByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
