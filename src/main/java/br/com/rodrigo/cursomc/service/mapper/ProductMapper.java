package br.com.rodrigo.cursomc.service.mapper;

import br.com.rodrigo.cursomc.domain.Product;
import br.com.rodrigo.cursomc.service.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends AbstractMapper<Product, ProductDTO> {

	@Override
	public ProductDTO entityToDTO(Product entity) {
		return ProductDTO.builder()
			.id(entity.getId())
			.name(entity.getName())
			.price(entity.getPrice())
			.build();
	}

	@Override
	public Product dtoToEntity(ProductDTO productDTO) {
		return Product.builder()
			.id(productDTO.getId())
			.name(productDTO.getName())
			.price(productDTO.getPrice())
			.build();
	}
}
