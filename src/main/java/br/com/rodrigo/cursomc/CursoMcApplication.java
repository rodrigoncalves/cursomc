package br.com.rodrigo.cursomc;

import br.com.rodrigo.cursomc.domain.*;
import br.com.rodrigo.cursomc.domain.enums.CustomerType;
import br.com.rodrigo.cursomc.repository.*;
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
	private CustomerRepository customerRepository;
	private AddressRepository addressRepository;

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

		City city1 = City.builder().name("Uberlândia").state(state1).build();
		City city2 = City.builder().name("São Paulo").state(state2).build();
		City c3 = City.builder().name("Campinas").state(state2).build();

		state1.getCities().add(city1);
		state2.getCities().addAll(Arrays.asList(city2, c3));

		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1, city2, c3));

		Customer customer1 = Customer.builder()
			.name("Maria Silva")
			.email("maria@gmail.com")
			.cpfOuCnpj("36378912377")
			.type(CustomerType.PERSON)
			.build();

		customer1.getPhones().addAll(Arrays.asList("27363323", "93838393"));

		Address a1 = Address.builder()
			.logradouro("Rua Flores")
			.numero("300")
			.complemento("Apto 303")
			.bairro("Jardim")
			.cep("38220834")
			.customer(customer1)
			.city(city1)
			.build();
		Address a2 = Address.builder()
			.logradouro("Avenida Matos")
			.numero("105")
			.complemento("Sala 800")
			.bairro("Centro")
			.cep("38777012")
			.customer(customer1)
			.city(city2)
			.build();

		customer1.getAddresses().addAll(Arrays.asList(a1, a2));

		customerRepository.save(customer1);
		addressRepository.saveAll(Arrays.asList(a1, a2));

	}
}
