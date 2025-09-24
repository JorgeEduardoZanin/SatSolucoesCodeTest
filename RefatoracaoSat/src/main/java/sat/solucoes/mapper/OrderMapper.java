package sat.solucoes.mapper;

import sat.solucoes.dto.OrderRequest;
import sat.solucoes.entity.OrderEntity;

public class OrderMapper {

	public static OrderEntity OrderRequestToOrderEntity(OrderRequest orderRequest) {
		return new OrderEntity(orderRequest.name(), orderRequest.value());
	}
	
	
}
