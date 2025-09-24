package sat.solucoes.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sat.solucoes.dto.OrderRequest;
import sat.solucoes.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	
	private OrderService orderService;
		
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<Map<String, String>> criarPedido(@Valid @RequestBody OrderRequest orderRequest) {
	
		orderService.save(orderRequest);

		return ResponseEntity.ok(Map.of("message: ", "Seu pedido foi criado com sucesso!"));
	}
}
