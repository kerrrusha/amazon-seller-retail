package com.kerrrusha.amazonsellerretail.controller;

import com.kerrrusha.amazonsellerretail.dto.auth.JwtAuthenticationResponse;
import com.kerrrusha.amazonsellerretail.dto.user.request.UserLoginRequestDto;
import com.kerrrusha.amazonsellerretail.dto.user.request.UserRegistrationRequestDto;
import com.kerrrusha.amazonsellerretail.dto.user.response.UserResponseDto;
import com.kerrrusha.amazonsellerretail.security.AuthenticationService;
import com.kerrrusha.amazonsellerretail.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Registration and authorization endpoints")
public class AuthController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public UserResponseDto register(@Valid @RequestBody UserRegistrationRequestDto request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    @Operation(summary = "Authenticate a user (do login)")
    public JwtAuthenticationResponse login(@Valid @RequestBody UserLoginRequestDto request) {
        return authenticationService.authenticate(request);
    }
}
