package br.com.rodrigo.cursomc.service.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDTO {
	private Integer id;
	private String description;
	private List<ProductDTO> products;
}
