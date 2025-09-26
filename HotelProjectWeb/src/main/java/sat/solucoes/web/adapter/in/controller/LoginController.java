package sat.solucoes.web.adapter.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sat.solucoes.web.adapter.dto.request.login.LoginRequest;
import sat.solucoes.web.adapter.dto.response.login.LoginResponse;
import sat.solucoes.web.adapter.mapper.LoginMapper;
import sat.solucoes.web.core.port.in.LoginUseCase;

@RestController
@RequestMapping("/login")
public class LoginController {

	private final LoginUseCase loginUseCase;
	
	public LoginController(LoginUseCase loginUseCase) {
		this.loginUseCase = loginUseCase;
	}

	@PostMapping
	public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest loginRequest){
		var response = loginUseCase.login(LoginMapper.LoginRequestToLoginDomain(loginRequest));
		
		return ResponseEntity.ok(LoginMapper.loginDomainToLoginResponse(response));
	}
	
}
