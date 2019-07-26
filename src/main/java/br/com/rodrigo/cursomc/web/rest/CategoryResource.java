package br.com.rodrigo.cursomc.web.rest;

import br.com.rodrigo.cursomc.service.CategoryService;
import br.com.rodrigo.cursomc.service.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class CategoryResource {

	private CategoryService categoryService;

	@GetMapping("/categories")
	public ResponseEntity<List<CategoryDTO>> findAllCategories() {
		log.info("findAllCategories");

		List<CategoryDTO> dto = categoryService.findAll();
		return ResponseEntity.ok(dto);
	}

	@GetMapping("/categories/{id}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer id) {
		log.info("getCategory");
		log.info("id: " + id);

		CategoryDTO dto = categoryService.findById(id);
		return ResponseEntity.ok(dto);
	}


	@PostMapping("/categories")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
		log.info("createCategory");
		log.info("categoryDTO: " + categoryDTO);

		CategoryDTO dto = categoryService.create(categoryDTO);

		URI location = ServletUriComponentsBuilder
			.fromCurrentContextPath().path("/{id}")
			.buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(location).body(dto);
	}

	@PutMapping("/categories/{id}")
	public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO) {
		log.info("updateCategory");
		log.info("id: " + id);
		log.info("categoryDTO: " + categoryDTO);

		CategoryDTO dto = categoryService.update(id, categoryDTO);
		return ResponseEntity.ok(dto);
	}

}
