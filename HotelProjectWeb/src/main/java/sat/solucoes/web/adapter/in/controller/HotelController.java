package sat.solucoes.web.adapter.in.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sat.solucoes.web.adapter.dto.request.hotel.HotelRequest;
import sat.solucoes.web.adapter.mapper.HotelMapper;
import sat.solucoes.web.core.port.in.HotelUseCase;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	private final HotelUseCase hotelUseCase;
	
	public HotelController(HotelUseCase hotelUseCase) {
		this.hotelUseCase = hotelUseCase;
	}

	public ResponseEntity<Map<String, String>> create(@RequestBody HotelRequest hotelRequest){
		
		hotelUseCase.create(HotelMapper.hotelRequestToHotelDomain(hotelRequest));
		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message: ", "Seu hotel foi criado com sucesso!"));
	}
	
	
}
