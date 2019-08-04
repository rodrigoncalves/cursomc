package br.com.rodrigo.cursomc.domain;

import br.com.rodrigo.cursomc.domain.enums.PaymentStatus;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
public class Payment implements Serializable {
	private static final long serialVersionUID = 7723360962527050234L;

	@Id
	private Integer id;

	private PaymentStatus status;

	@OneToOne
	@JoinColumn(name = "payment_id")
	@MapsId
	private Order order;
}
