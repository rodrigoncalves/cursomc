package br.com.rodrigo.cursomc.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class OrderItem {

	@Id
	@GeneratedValue
	private Integer id;

	private Double desconto;
	private Integer quantidade;
	private Double price;
}
