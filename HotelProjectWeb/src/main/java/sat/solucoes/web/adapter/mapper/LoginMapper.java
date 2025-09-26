package sat.solucoes.web.adapter.mapper;

import sat.solucoes.web.adapter.dto.request.login.LoginRequest;
import sat.solucoes.web.adapter.dto.response.login.LoginResponse;
import sat.solucoes.web.core.domain.LoginDomain;

public class LoginMapper {

	public static LoginDomain LoginRequestToLoginDomain(LoginRequest loginRequest) {
		var domain =  new LoginDomain();
		domain.setEmail(loginRequest.email());
		domain.setPassword(loginRequest.password());
	
		return domain;
	}
	
	public static LoginResponse loginDomainToLoginResponse(LoginDomain loginDomain) {
		return new LoginResponse(loginDomain.getToken(), loginDomain.getExpireIn());
	}
	
}
