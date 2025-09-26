package sat.solucoes.web.adapter.mapper;

import java.util.List;

import sat.solucoes.web.adapter.dto.request.hotel.HotelCreateRequest;
import sat.solucoes.web.adapter.dto.request.hotel.HotelUpdateRequest;
import sat.solucoes.web.adapter.dto.response.hotel.HotelByIdResponse;
import sat.solucoes.web.adapter.dto.response.hotel.HotelFindAllResponse;
import sat.solucoes.web.adapter.dto.response.hotel.HotelUpdateResponse;
import sat.solucoes.web.adapter.out.database.entity.HotelEntity;
import sat.solucoes.web.adapter.out.database.response.HotelLoginResponse;
import sat.solucoes.web.core.domain.HotelDomain;

public class HotelMapper {

	public static HotelDomain hotelRequestToHotelDomain(HotelCreateRequest hotelRequest) {
		return new HotelDomain(
				hotelRequest.name(),
				hotelRequest.password(),
				hotelRequest.email(),
				hotelRequest.address(),
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
	
	public static HotelDomain hotelUpdateRequestToHotelDomain(HotelUpdateRequest hotelRequest) {
		var domain = new HotelDomain();
		domain.setName(hotelRequest.name());
		domain.setAddress(hotelRequest.Address());
		domain.setCity(hotelRequest.city());
		domain.setNumber(hotelRequest.number());
		domain.setState(hotelRequest.state());
		domain.setEmail(hotelRequest.email());
		
		return domain;
	}
	
	public static HotelUpdateResponse hotelDomainToHotelUpdateResponse(HotelDomain hotelDomain) {
		
		return new HotelUpdateResponse(
				hotelDomain.getName(),
				hotelDomain.getEmail(), 
				hotelDomain.getAddress(),
				hotelDomain.getNumber(),
				hotelDomain.getState(), 
				hotelDomain.getCity(), 
				hotelDomain.getCnpj());
		
	}
	
	public static List<HotelFindAllResponse> listHotelDomainToListHotelFindAllResponse(List<HotelDomain> hotelDomains){
		
	return hotelDomains.stream()
			.map(h -> new HotelFindAllResponse(h.getName(), h.getCity(), h.getState()))
			.toList();
		
	}
	
	public static HotelByIdResponse hotelDomainToHotelByIdResponse(HotelDomain hotelDomain) {
		return new HotelByIdResponse(
				hotelDomain.getName(), 
				hotelDomain.getAddress(),
				hotelDomain.getNumber(),
				hotelDomain.getState(), 
				hotelDomain.getCity(), 
				hotelDomain.getCnpj());
	}
	
	public static HotelDomain hotelEntityToHotelDomain(HotelEntity hotelEntity) {
		return new HotelDomain(
				hotelEntity.getName(), 
				null, 
				hotelEntity.getEmail(), 
				hotelEntity.getAddress(),
				hotelEntity.getNumber(), 
				hotelEntity.getState(), 
				hotelEntity.getCity(), 
				hotelEntity.getCnpj());	
	}
	
	public static HotelDomain hotelLoginResponseToHotelDomain(HotelLoginResponse response) {
		
		var domain = new HotelDomain();
		domain.setPassword(response.password());
		domain.setEmail(response.email());
		domain.setId(response.id());
		domain.setName(response.name());
		
		return domain;
		
	}
	
}
