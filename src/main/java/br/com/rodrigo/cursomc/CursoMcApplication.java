package br.com.rodrigo.cursomc;

import br.com.rodrigo.cursomc.domain.Category;
import br.com.rodrigo.cursomc.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner {

	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Category cat1 = Category.builder().description("Informática").build();
		Category cat2 = Category.builder().description("Escritório").build();

		List<Category> categories = Arrays.asList(cat1, cat2);
		categoryRepository.saveAll(categories);
	}
}
