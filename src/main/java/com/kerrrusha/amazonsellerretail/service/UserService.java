package com.kerrrusha.amazonsellerretail.service;

import com.kerrrusha.amazonsellerretail.dto.user.request.UserRegistrationRequestDto;
import com.kerrrusha.amazonsellerretail.dto.user.response.UserResponseDto;

public interface UserService {

    UserResponseDto register(UserRegistrationRequestDto request);

}
