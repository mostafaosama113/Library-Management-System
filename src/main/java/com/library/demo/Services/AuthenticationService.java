package com.library.demo.Services;

import com.library.demo.Models.*;
import com.library.demo.Repositories.UserReposirtory;
import com.library.demo.Responses.GenaricResponse;
import com.library.demo.Responses.ResponseWithList;
import com.library.demo.Security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserReposirtory userReposirtory;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public GenaricResponse register(RegisterRequest request) {

        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        Optional<User> found = userReposirtory.findByEmail(user.getEmail());
        if (found.isPresent()) {
            return new GenaricResponse(HttpStatus.CONFLICT.value(), "user is already existing");
        }
        try {
            userReposirtory.save(user);
        }catch (Exception exception){
            return new GenaricResponse(HttpStatus.CONFLICT.value(), exception.getMessage());
        }
        String token = jwtUtil.generateToken(new HashMap<>(), user);
        AuthenticationResponse authenticationResponse= AuthenticationResponse.builder().token(token).build();

        return new ResponseWithList<>(List.of(authenticationResponse),HttpStatus.CREATED.value(),"user created successfully");
    }

    public GenaricResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (Exception exception) {
            return new GenaricResponse(HttpStatus.FORBIDDEN.value(), exception.getMessage());
        }
        User user = userReposirtory.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtUtil.generateToken(new HashMap<>(), user);

        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder().token(token).build();
        return new ResponseWithList<>(List.of(authenticationResponse), HttpStatus.OK.value(), "authentication successful");
    }

}
