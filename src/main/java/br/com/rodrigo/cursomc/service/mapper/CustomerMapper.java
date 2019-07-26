package br.com.rodrigo.cursomc.service.mapper;

import br.com.rodrigo.cursomc.domain.Customer;
import br.com.rodrigo.cursomc.service.dto.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper extends AbstractMapper<Customer, CustomerDTO> {
	@Override
	public CustomerDTO entityToDTO(Customer entity) {
		return CustomerDTO.builder()
			.id(entity.getId())
			.name(entity.getName())
			.cpfOuCnpj(entity.getCpfOuCnpj())
			.email((entity.getEmail()))
			.build();
	}

	@Override
	public Customer dtoToEntity(CustomerDTO dto) {
		return Customer.builder()
			.id(dto.getId())
			.name(dto.getName())
			.cpfOuCnpj(dto.getCpfOuCnpj())
			.email(dto.getEmail())
			.build();
	}
}
