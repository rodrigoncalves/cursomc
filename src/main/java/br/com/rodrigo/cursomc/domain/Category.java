package br.com.rodrigo.cursomc.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
public class Category {

	private static final long serialVersionUID = 2214911413769255530L;

	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	@ManyToMany(mappedBy = "categories")
	private final List<Product> products = new ArrayList<>();
}

