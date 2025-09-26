package sat.solucoes.web.core.domain;

public class LoginDomain {

	private Long id;
	
	private String email;
	
	private String password;
	
	private String token;
	
	private Long expireIn;

	public LoginDomain(Long id, String email, String password, String token, Long expireIn) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.token = token;
		this.expireIn = expireIn;
	}

	public LoginDomain() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getExpireIn() {
		return expireIn;
	}

	public void setExpireIn(Long expireIn) {
		this.expireIn = expireIn;
	}
	
}
