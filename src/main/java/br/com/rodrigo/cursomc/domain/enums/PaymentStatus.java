package br.com.rodrigo.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentStatus {

	PENDING(1, "Pending"),
	PAID(2, "Paid"),
	CANCELED(3, "Canceled");

	private Integer id;
	private String description;

	public static PaymentStatus toEnum(Integer id) {
		if (id != null) {
			for (PaymentStatus type : PaymentStatus.values()) {
				if (id.equals(type.getId())) {
					return type;
				}
			}
		}

		return null;
	}
}
