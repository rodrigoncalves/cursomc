package br.com.rodrigo.cursomc.domain;

import br.com.rodrigo.cursomc.domain.enums.PaymentStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class PaymentCard extends Payment{
	private static final long serialVersionUID = 8824482888564701863L;

	private Integer parcelas;

	@Builder
	public PaymentCard(Integer id, PaymentStatus status, Order order, Integer parcelas) {
		super(id, status, order);
		this.parcelas = parcelas;
	}
}
