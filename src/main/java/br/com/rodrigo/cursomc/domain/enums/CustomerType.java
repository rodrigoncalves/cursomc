package br.com.rodrigo.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CustomerType {

	PERSON(1, "PERSON"),
	COMPANY(2, "COMPANY");

	private Integer cod;
	private String description;

	public static CustomerType toEnum(Integer cod) {
		if (cod != null) {
			for (CustomerType type : CustomerType.values()) {
				if (cod.equals(type.getCod())) {
					return type;
				}
			}
		}

		return null;
	}
}
