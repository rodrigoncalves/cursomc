package br.com.rodrigo.cursomc.service;

import br.com.rodrigo.cursomc.domain.Category;
import br.com.rodrigo.cursomc.repository.CategoryRepository;
import br.com.rodrigo.cursomc.service.dto.CategoryDTO;
import br.com.rodrigo.cursomc.service.mapper.CategoryMapper;
import br.com.rodrigo.cursomc.web.rest.errors.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {

	private CategoryRepository categoryRepository;
	private CategoryMapper categoryMapper;

	public List<CategoryDTO> findAll() {
		List<Category> categories = categoryRepository.findAll();

		return categoryMapper.entitiesToDTOs(categories);
	}

	public CategoryDTO findById(Integer id) {
		Category category = categoryRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Category not found: " + id));

		return categoryMapper.entityToDTO(category);
	}

	public CategoryDTO create(CategoryDTO categoryDTO) {
		Category category = categoryMapper.dtoToEntity(categoryDTO);

		categoryRepository.save(category);
		return categoryMapper.entityToDTO(category);
	}

	public CategoryDTO update(Integer id, CategoryDTO categoryDTO) {
		Category category = categoryRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Category not found: " + id));

		category.setDescription(categoryDTO.getDescription());
		categoryRepository.save(category);

		return categoryMapper.entityToDTO(category);
	}
}
