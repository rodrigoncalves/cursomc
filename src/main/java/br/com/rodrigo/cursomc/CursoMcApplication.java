package br.com.rodrigo.cursomc;

import br.com.rodrigo.cursomc.domain.Category;
import br.com.rodrigo.cursomc.domain.Product;
import br.com.rodrigo.cursomc.repository.CategoryRepository;
import br.com.rodrigo.cursomc.repository.ProductRepository;
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
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Category cat1 = Category.builder().description("Informática").build();
		Category cat2 = Category.builder().description("Escritório").build();

		Product p1 = Product.builder().name("Computador").price(2000.00).build();
		Product p2 = Product.builder().name("Impressora").price(800.00).build();
		Product p3 = Product.builder().name("Mouse").price(80.00).build();

		p1.getCategories().add(cat1);
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().add(cat1);

		List<Category> categories = Arrays.asList(cat1, cat2);
		List<Product> products = Arrays.asList(p1, p2, p3);

		categoryRepository.saveAll(categories);
		productRepository.saveAll(products);
	}
}
