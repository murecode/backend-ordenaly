package com.app.ordenaly.dto.mapper;

import org.mapstruct.*;
import com.app.ordenaly.dto.UserDetailsDto;
import com.app.ordenaly.model.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserDetailsMapper {
  @Mappings({
          @Mapping(source = "id", target = "user_id"),
          @Mapping(source = "fullname", target = "name"),
          @Mapping(source = "username", target = "user_name"),
          @Mapping(source = "password", target = "password"),
  })
  UserDetailsDto UserToUserDetailsDto(User user);
  @InheritInverseConfiguration
  User UserDetailsDtoToUser(UserDetailsDto userDetailsDto);
}
