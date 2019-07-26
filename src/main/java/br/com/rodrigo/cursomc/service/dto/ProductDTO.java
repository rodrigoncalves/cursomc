package br.com.rodrigo.cursomc.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
	private Integer id;
	private String name;
	private Double price;
}
