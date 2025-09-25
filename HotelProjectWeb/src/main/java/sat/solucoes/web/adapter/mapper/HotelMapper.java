package sat.solucoes.web.adapter.mapper;

import sat.solucoes.web.adapter.dto.request.hotel.HotelRequest;
import sat.solucoes.web.adapter.out.database.entity.HotelEntity;
import sat.solucoes.web.core.domain.HotelDomain;

public class HotelMapper {

	public static HotelDomain hotelRequestToHotelDomain(HotelRequest hotelRequest) {
		return new HotelDomain(
				hotelRequest.name(),
				hotelRequest.password(),
				hotelRequest.email(),
				hotelRequest.Address(),
				hotelRequest.number(),
				hotelRequest.state(),
				hotelRequest.city(),
				hotelRequest.cnpj());
	}
	
	public static HotelEntity hotelDomainToHotelEntity(HotelDomain hotelDomain) {
		return new HotelEntity(
				hotelDomain.getName(),
				hotelDomain.getPassword(),
				hotelDomain.getEmail(),
				hotelDomain.getAddress(),
				hotelDomain.getNumber(),
				hotelDomain.getState(),
				hotelDomain.getCity(),
				hotelDomain.getCnpj());
	}
	
}
