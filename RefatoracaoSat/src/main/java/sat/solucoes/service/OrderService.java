package sat.solucoes.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import sat.solucoes.dto.OrderRequest;
import sat.solucoes.exception.OrderException;
import sat.solucoes.exception.enums.ExceptionOrderType;
import sat.solucoes.mapper.OrderMapper;
import sat.solucoes.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	private NotificationService notificationService;
	
	public OrderService(OrderRepository orderRepository, NotificationService notificationService) {
		this.orderRepository = orderRepository;
		this.notificationService = notificationService;
	}

	public void save(OrderRequest orderRequest) {
		
		if(orderRequest.value().compareTo(BigDecimal.ZERO) <=0) {
			throw new OrderException(ExceptionOrderType.VALUE_MUST_BE_GREATER_THAN_ZERO);
		}
		
		var responseEntity = orderRepository.save(OrderMapper.OrderRequestToOrderEntity(orderRequest));
		
		
	    notificationService.sendEmail(responseEntity.getId(), "Pedido criado!");
	    
	}
	
}
