package com.kerrrusha.amazonsellerretail.service.impl;

import com.kerrrusha.amazonsellerretail.domain.Role;
import com.kerrrusha.amazonsellerretail.domain.User;
import com.kerrrusha.amazonsellerretail.dto.user.request.UserRegistrationRequestDto;
import com.kerrrusha.amazonsellerretail.dto.user.response.UserResponseDto;
import com.kerrrusha.amazonsellerretail.mapper.UserMapper;
import com.kerrrusha.amazonsellerretail.repository.UserRepository;
import com.kerrrusha.amazonsellerretail.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Collections.singleton;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists with such email: " + request.getEmail());
        }

        User user = new User();
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRoles(singleton(Role.USER));
        User savedUser = userRepository.save(user);

        return userMapper.toDto(savedUser);
    }
}
