package com.app.ordenaly.dto.mapper;

import com.app.ordenaly.dto.ItemDto;
import com.app.ordenaly.model.Item;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ProductMapper.class}
)
public interface ItemMapper {

  @Mappings({
          @Mapping(source = "id", target = "item_id"),
          @Mapping(source = "product.productName", target = "product_name"),
          @Mapping(source = "product.price", target = "price"),
          @Mapping(source = "quantity", target = "quantity")
  })
  ItemDto itemToItemDto(Item item);

  @InheritInverseConfiguration
  Item itemDtoToItem(ItemDto itemDto);

  //Mapeando lista de items a una lista de itemDto
  List<ItemDto> toItemDtoList( List<Item> itemList );

  //Mapeando lista de itemDto a una lista de item
  List<Item> toItemList( List<ItemDto> itemDtoList );

}
