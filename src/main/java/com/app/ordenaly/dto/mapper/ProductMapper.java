package com.app.ordenaly.dto.mapper;

import com.app.ordenaly.dto.ProductDto;
import com.app.ordenaly.model.Product;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

  @Mappings({
          @Mapping(source = "id", target = "id"),
          @Mapping(source = "productName", target = "nombre"),
          @Mapping(source = "description", target = "descripcion"),
          @Mapping(source = "price", target = "precio"),
          @Mapping(source = "inStock", target = "disponible")
  })
  ProductDto productToProductDto(Product product);

  @InheritInverseConfiguration
  Product ProductDtoToProduct(ProductDto productDto);

}
