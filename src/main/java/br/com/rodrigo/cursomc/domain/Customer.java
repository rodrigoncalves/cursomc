package br.com.rodrigo.cursomc.domain;

import br.com.rodrigo.cursomc.domain.enums.CustomerType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = -4990753727552057860L;

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String email;
	private String cpfOuCnpj;

	@Enumerated
	private CustomerType type;

	@OneToMany(mappedBy="customer")
	private final List<Address> addresses = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name="phone")
	private final Set<String> phones = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private final List<Order> orders = new ArrayList<>();
}
