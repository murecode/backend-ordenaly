package com.app.ordenaly.dto.mapper;

import com.app.ordenaly.dto.UserDto;
import com.app.ordenaly.model.User;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
  @Mappings({
          @Mapping(source = "firstname", target = "nombre"),
          @Mapping(source = "role", target = "rol")
  })
  UserDto UserToUserDto(User user);
  @InheritInverseConfiguration
  User UserDtoToUser(UserDto userDto);

}
