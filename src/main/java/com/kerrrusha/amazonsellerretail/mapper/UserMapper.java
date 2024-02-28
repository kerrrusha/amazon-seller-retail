package com.kerrrusha.amazonsellerretail.mapper;

import com.kerrrusha.amazonsellerretail.config.MapperConfig;
import com.kerrrusha.amazonsellerretail.domain.User;
import com.kerrrusha.amazonsellerretail.dto.user.response.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);
}
