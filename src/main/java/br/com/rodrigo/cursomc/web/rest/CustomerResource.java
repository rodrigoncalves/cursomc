package br.com.rodrigo.cursomc.web.rest;

import br.com.rodrigo.cursomc.service.CustomerService;
import br.com.rodrigo.cursomc.service.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class CustomerResource {

	private CustomerService categoryService;

	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDTO>> findAllCustomers() {
		log.info("findAllCustomers");

		List<CustomerDTO> dto = categoryService.findAll();
		return ResponseEntity.ok(dto);
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer id) {
		log.info("getCustomer");
		log.info("id: " + id);

		CustomerDTO dto = categoryService.findById(id);
		return ResponseEntity.ok(dto);
	}


	@PostMapping("/customers")
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO categoryDTO) {
		log.info("createCustomer");
		log.info("categoryDTO: " + categoryDTO);

		CustomerDTO dto = categoryService.create(categoryDTO);

		URI location = ServletUriComponentsBuilder
			.fromCurrentContextPath().path("/{id}")
			.buildAndExpand(dto.getId()).toUri();

		return ResponseEntity.created(location).body(dto);
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Integer id, @RequestBody CustomerDTO categoryDTO) {
		log.info("updateCustomer");
		log.info("id: " + id);
		log.info("categoryDTO: " + categoryDTO);

		CustomerDTO dto = categoryService.update(id, categoryDTO);
		return ResponseEntity.ok(dto);
	}

}
