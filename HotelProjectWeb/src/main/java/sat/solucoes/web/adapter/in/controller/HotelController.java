package sat.solucoes.web.adapter.in.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sat.solucoes.web.adapter.dto.request.hotel.HotelCreateRequest;
import sat.solucoes.web.adapter.dto.request.hotel.HotelUpdateRequest;
import sat.solucoes.web.adapter.dto.response.hotel.HotelByIdResponse;
import sat.solucoes.web.adapter.dto.response.hotel.HotelFindAllResponse;
import sat.solucoes.web.adapter.dto.response.hotel.HotelUpdateResponse;
import sat.solucoes.web.adapter.mapper.HotelMapper;
import sat.solucoes.web.core.port.in.HotelUseCase;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	private final HotelUseCase hotelUseCase;
	
	public HotelController(HotelUseCase hotelUseCase) {
		this.hotelUseCase = hotelUseCase;
	}
	/*
	 * 
	 * POST
	 * 
	 */
	@PostMapping
	public ResponseEntity<Map<String, String>> create(@RequestBody HotelCreateRequest hotelRequest){
		
		hotelUseCase.create(HotelMapper.hotelRequestToHotelDomain(hotelRequest));
		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message: ", "Seu hotel foi criado com sucesso!"));
	}
	/*
	 *
	 * GET
	 * 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<HotelByIdResponse> findById(@PathVariable Long id){
		var response  = hotelUseCase.findById(id);
		
		return ResponseEntity.ok(HotelMapper.hotelDomainToHotelByIdResponse(response));
	}
	
	@GetMapping
	public ResponseEntity<List<HotelFindAllResponse>> findAllPaginate(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		
		var response  = hotelUseCase.findAllPaginate(page, pageSize);
		
		return ResponseEntity.ok(HotelMapper.listHotelDomainToListHotelFindAllResponse(response));
	}
	/*
	 *
	 * UPDATE
	 * 
	 */
	@PutMapping
	public ResponseEntity<HotelUpdateResponse> update(@RequestBody HotelUpdateRequest hotelRequest, JwtAuthenticationToken token){
		var response = hotelUseCase.update(HotelMapper.hotelUpdateRequestToHotelDomain(hotelRequest), Long.valueOf(token.getName()));
		
		return ResponseEntity.ok(HotelMapper.hotelDomainToHotelUpdateResponse(response));
	}
	/*
	 *
	 *DELETE
	 * 
	 */
	@DeleteMapping
	public ResponseEntity<Map<String, String>> delete(JwtAuthenticationToken token){
		hotelUseCase.delete(Long.valueOf(token.getName()));
		return ResponseEntity.ok(Map.of("message:", "Usuario deletado com sucesso!"));
	}
	
	
	
	
}
