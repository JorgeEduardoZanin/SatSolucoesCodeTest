package sat.solucoes.web.core.domain;

import org.springframework.security.crypto.password.PasswordEncoder;

public class HotelDomain {

	private Long id;
	
	private String name;
	
	private String password;
	
	private String email;
	
	private String address;
	
	private String number;
	
	private String state;
	
	private String city;
	
	private String cnpj;

	public HotelDomain(String name, String password, String email,  String address, String number, String state, String city, String cnpj) {
		this.password = password;
		this.email = email;
		this.name = name;
		this.address = address;
		this.number = number;
		this.state = state;
		this.city = city;
		this.cnpj = cnpj;
	}

	public HotelDomain() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return "HotelDomain [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", address="
				+ address + ", number=" + number + ", state=" + state + ", city=" + city + ", cnpj=" + cnpj + "]";
	}

	public boolean isLoginCorrect(PasswordEncoder passwordEncoder, LoginDomain login) {
        return passwordEncoder.matches(login.getPassword(), this.password);
    }
	
	
}
