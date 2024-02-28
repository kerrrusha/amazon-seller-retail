package com.kerrrusha.amazonsellerretail.security;

import com.kerrrusha.amazonsellerretail.dto.user.request.UserLoginRequestDto;
import com.kerrrusha.amazonsellerretail.dto.auth.JwtAuthenticationResponse;
import com.kerrrusha.amazonsellerretail.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationResponse authenticate(UserLoginRequestDto request) {
        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));

        UserDetails user = userRepository.findByEmail(authentication.getName()).orElseThrow();

        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
}
