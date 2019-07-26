package br.com.rodrigo.cursomc.service;

import br.com.rodrigo.cursomc.domain.Customer;
import br.com.rodrigo.cursomc.repository.CustomerRepository;
import br.com.rodrigo.cursomc.service.dto.CustomerDTO;
import br.com.rodrigo.cursomc.service.mapper.CustomerMapper;
import br.com.rodrigo.cursomc.web.rest.errors.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	private CustomerMapper customerMapper;

	public List<CustomerDTO> findAll() {
		List<Customer> customers = customerRepository.findAll();
		return customerMapper.entitiesToDTOs(customers);
	}

	public CustomerDTO findById(Integer id) {
		Customer customer = customerRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id));

		return customerMapper.entityToDTO(customer);
	}

	public CustomerDTO create(CustomerDTO categoryDTO) {
		Customer customer = customerMapper.dtoToEntity(categoryDTO);

		customerRepository.save(customer);
		return customerMapper.entityToDTO(customer);
	}

	public CustomerDTO update(Integer id, CustomerDTO categoryDTO) {
		Customer customer = customerRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id));

		return null;
	}
}
