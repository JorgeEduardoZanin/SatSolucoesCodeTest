package sat.solucoes.web.core.port.in;

import sat.solucoes.web.core.domain.LoginDomain;

public interface LoginUseCase {

	LoginDomain login(LoginDomain login);
	
}
