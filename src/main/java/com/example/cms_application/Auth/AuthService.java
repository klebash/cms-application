package com.example.cms_application.Auth;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.cms_application.config.JWTService;
import com.example.cms_application.model.User;
import com.example.cms_application.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo repository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        Optional<User> adminUser = repository.findByUsername("admin");

        if (adminUser.isEmpty()) {
            System.out.println("Admin user not found");
            String encodedPassword = passwordEncoder.encode("admin123");
            User reg_user = User.builder()
                    .username("admin")
                    .password(encodedPassword)
                    .build();
            repository.save(reg_user);
        }
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
            User user = repository.findByUsername(request.getUsername())
                    .orElseThrow();
            String jwtToken = jwtService.GenerateToken(user);
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .build();
    }

}
