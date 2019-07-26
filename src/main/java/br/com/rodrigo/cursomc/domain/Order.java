package br.com.rodrigo.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

@Data
@Builder
@Entity
public class Order implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;

	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instante;

//	@OneToOne(cascade= CascadeType.ALL, mappedBy="pedido")
//	private Pagamento pagamento;

	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name="delivery_address_id")
	private Address deliveryAddress;

//	@OneToMany(mappedBy="id.pedido")
//	private Set<ItemPedido> itens = new HashSet<>();
}
