package br.com.rodrigo.cursomc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 2214911413769255530L;

	@Id
	@GeneratedValue
	private Integer id;
	private String description;

	@ManyToMany(mappedBy = "categories")
	private final List<Product> products = new ArrayList<>();

}
