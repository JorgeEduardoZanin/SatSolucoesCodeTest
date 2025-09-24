package sat.solucoes.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;



public record OrderRequest(
		@NotEmpty(message = "O nome do produto tem que existir!")  String name, 
		@NotNull(message = "O valor do produto tem que existr!") BigDecimal value) {

}
