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
          @Mapping(source = "id", target = "itemId"),
          @Mapping(source = "product.productName", target = "producto"),
          @Mapping(source = "product.price", target = "precio"),
          @Mapping(source = "quantity", target = "cantidad")
  })
  ItemDto itemToItemDto(Item item);

  @InheritInverseConfiguration
  Item itemDtoToItem(ItemDto itemDto);

  //Mapeando lista de items a una lista de itemDto
  List<ItemDto> toItemDtoList( List<Item> itemList );

  //Mapeando lista de itemDto a una lista de item
  List<Item> toItemList( List<ItemDto> itemDtoList );

}
