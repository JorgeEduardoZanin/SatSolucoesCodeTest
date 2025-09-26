package sat.solucoes.web.adapter.dto.request.hotel;

public record HotelCreateRequest(String name, String password, String email, String address, String number, String state, String city, String cnpj) {

}
