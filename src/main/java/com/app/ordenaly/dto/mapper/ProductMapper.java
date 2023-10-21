package com.app.ordenaly.dto.mapper;

import com.app.ordenaly.dto.ProductDto;
import com.app.ordenaly.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

  @Mappings({
          @Mapping(source = "id", target = "id"),
          @Mapping(source = "productName", target = "productName"),
          @Mapping(source = "description", target = "description"),
          @Mapping(source = "price", target = "price"),
          @Mapping(source = "inStock", target = "inStock")
  })
  ProductDto productToProductDto(Product product);

}
