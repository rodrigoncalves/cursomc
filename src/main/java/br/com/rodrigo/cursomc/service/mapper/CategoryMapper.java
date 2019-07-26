package br.com.rodrigo.cursomc.service.mapper;

import br.com.rodrigo.cursomc.domain.Category;
import br.com.rodrigo.cursomc.service.dto.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper extends AbstractMapper<Category, CategoryDTO> {

	@Override
	public CategoryDTO entityToDTO(Category entity) {
		return CategoryDTO.builder()
			.id(entity.getId())
			.description(entity.getDescription())
			.build();
	}

	@Override
	public Category dtoToEntity(CategoryDTO dto) {
		return Category.builder()
			.id(dto.getId())
			.description(dto.getDescription())
			.build();
	}

}
