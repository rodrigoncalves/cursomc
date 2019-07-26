package br.com.rodrigo.cursomc.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

abstract class AbstractMapper<CLASS, DTO> {

	public abstract DTO entityToDTO(CLASS entity);

	public abstract CLASS dtoToEntity(DTO dto);

	public List<DTO> entitiesToDTOs(List<CLASS> entities) {
		if (entities == null) return null;
		return entities.stream()
			.map(this::entityToDTO)
			.collect(Collectors.toList());
	}
}
