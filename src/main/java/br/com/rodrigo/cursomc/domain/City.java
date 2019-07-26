package br.com.rodrigo.cursomc.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
public class City {
	private static final long serialVersionUID = -4107662795315801239L;

	@Id
	@GeneratedValue
	private Integer id;
	private String name;

	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;

}
