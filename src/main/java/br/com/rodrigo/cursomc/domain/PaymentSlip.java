package br.com.rodrigo.cursomc.domain;

import br.com.rodrigo.cursomc.domain.enums.PaymentStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class PaymentSlip extends Payment {
	private static final long serialVersionUID = -9201663201199275522L;

	private Date dueDate;
	private Date payday;

	@Builder
	public PaymentSlip(Integer id, PaymentStatus status, Order order, Date dueDate, Date payday) {
		super(id, status, order);
		this.dueDate = dueDate;
		this.payday = payday;
	}
}
