package br.com.rodrigo.cursomc;

import br.com.rodrigo.cursomc.domain.Category;
import br.com.rodrigo.cursomc.domain.City;
import br.com.rodrigo.cursomc.domain.Product;
import br.com.rodrigo.cursomc.domain.State;
import br.com.rodrigo.cursomc.repository.CategoryRepository;
import br.com.rodrigo.cursomc.repository.CityRepository;
import br.com.rodrigo.cursomc.repository.ProductRepository;
import br.com.rodrigo.cursomc.repository.StateRepository;
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
	private StateRepository stateRepository;
	private CityRepository cityRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Category cat1 = Category.builder().name("Informática").build();
		Category cat2 = Category.builder().name("Escritório").build();

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

		State state1 = State.builder().name("Minas Gerais").build();
		State state2 = State.builder().name("São Paulo").build();

		City c1 = City.builder().name("Uberlândia").state(state1).build();
		City c2 = City.builder().name("São Paulo").state(state2).build();
		City c3 = City.builder().name("Campinas").state(state2).build();

		state1.getCities().add(c1);
		state2.getCities().addAll(Arrays.asList(c2, c3));

		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

	}
}
