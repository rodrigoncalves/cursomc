package br.com.rodrigo.cursomc.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {
	private Integer id;
	private String description;
}
