package br.com.rodrigo.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@Entity
public class Order implements Serializable {
	private static final long serialVersionUID = -5641773427782160604L;

	@Id
	@GeneratedValue
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date date;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
	private Payment payment;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "delivery_address_id")
	private Address deliveryAddress;

	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items;
}
