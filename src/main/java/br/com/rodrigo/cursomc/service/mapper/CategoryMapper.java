package br.com.rodrigo.cursomc.service.mapper;

import br.com.rodrigo.cursomc.domain.Category;
import br.com.rodrigo.cursomc.service.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CategoryMapper extends AbstractMapper<Category, CategoryDTO> {

	private ProductMapper productMapper;

	@Override
	public CategoryDTO entityToDTO(Category entity) {
		return CategoryDTO.builder()
			.id(entity.getId())
			.description(entity.getName())
			.products(productMapper.entitiesToDTOs(entity.getProducts()))
			.build();
	}

	@Override
	public Category dtoToEntity(CategoryDTO dto) {
		return Category.builder()
			.id(dto.getId())
			.name(dto.getDescription())
			.build();
	}

}
