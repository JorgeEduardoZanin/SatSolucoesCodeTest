package sat.solucoes.web.adapter.mapper;

import java.util.List;
import java.util.Optional;

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
		var entity =  new HotelEntity(
				hotelDomain.getName(),
				hotelDomain.getPassword(),
				hotelDomain.getEmail(),
				hotelDomain.getAddress(),
				hotelDomain.getNumber(),
				hotelDomain.getState(),
				hotelDomain.getCity(),
				hotelDomain.getCnpj());

		 Optional.ofNullable(hotelDomain.getId()).ifPresent(entity::setId);
		 
		 return entity;
	
	}
	
	public static HotelDomain hotelUpdateRequestToHotelDomain(HotelUpdateRequest hotelRequest) {
		var domain = new HotelDomain();
		domain.setName(hotelRequest.name());
		domain.setAddress(hotelRequest.address());
		domain.setCity(hotelRequest.city());
		domain.setNumber(hotelRequest.number());
		domain.setState(hotelRequest.state());
		domain.setEmail(hotelRequest.email());
		System.out.println(domain);
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
		var domain = new HotelDomain(
				hotelEntity.getName(), 
				hotelEntity.getPassword(), 
				hotelEntity.getEmail(), 
				hotelEntity.getAddress(),
				hotelEntity.getNumber(), 
				hotelEntity.getState(), 
				hotelEntity.getCity(), 
				hotelEntity.getCnpj());	

		domain.setId(hotelEntity.getId());
		
		return domain;
	}
	
	public static HotelDomain hotelLoginResponseToHotelDomain(HotelLoginResponse response) {
		
		var domain = new HotelDomain();
		domain.setPassword(response.password());
		domain.setEmail(response.email());
		domain.setId(response.id());
		domain.setName(response.name());
		
		return domain;
		
	}
	
	public static List<HotelDomain> listHotelFindAllResponseToListHotelDomain(List<HotelFindAllResponse> responses){
		
		return responses.stream()
				.map(s ->{
					var domain = new HotelDomain();
					domain.setName(s.name());
					domain.setCity(s.city());
					domain.setState(s.state());
					return domain;
				})
				.toList();
		
	}
	
}
