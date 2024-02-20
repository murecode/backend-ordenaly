package com.app.ordenaly.dto.mapper;

import com.app.ordenaly.dto.UserDto;
import com.app.ordenaly.models.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
  @Mappings({
          @Mapping(source = "id", target="user_id"),
          @Mapping(source = "username", target = "username"),
          @Mapping(source = "fullname", target = "name"),
          @Mapping(source = "role", target = "rol")
  })
  UserDto UserToUserDto(User user);
  @InheritInverseConfiguration
  User UserDtoToUser(UserDto userDto);
  List<UserDto> usersDto(List<User> userList);

}
