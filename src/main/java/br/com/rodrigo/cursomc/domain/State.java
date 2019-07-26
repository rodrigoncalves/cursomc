package br.com.rodrigo.cursomc.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
public class State  {
	private static final long serialVersionUID = 3470224101179215720L;

	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	@OneToMany(mappedBy = "state")
	private final List<City> cities = new ArrayList<>();

}
