package com.example.socialnetwork.service;

import com.example.socialnetwork.dto.requests.AuthenticationRequest;
import com.example.socialnetwork.dto.requests.RegisterRequest;
import com.example.socialnetwork.dto.response.AuthenticationResponse;
import com.example.socialnetwork.entity.ConfirmationToken;
import com.example.socialnetwork.entity.User;
import com.example.socialnetwork.entity.enumClass.Role;
import com.example.socialnetwork.repository.UserRepository;
import com.example.socialnetwork.security.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final ConformationTokenService conformationTokenService;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final EmailSenderServiceImpl emailSenderService;

    @Autowired
    public AuthenticationService(UserRepository userRepository, ConformationTokenService conformationTokenService,
                                 PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, EmailSenderServiceImpl emailSenderService) {
        this.userRepository = userRepository;
        this.conformationTokenService = conformationTokenService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.emailSenderService = emailSenderService;
    }


    public AuthenticationResponse registration(RegisterRequest registerRequest) {

        User user = new User();

        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setMiddleName(registerRequest.getMiddleName());
        user.setFirstTimeLogin(Timestamp.from(Instant.now()));
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setAvatar(registerRequest.getAvatar());
        user.setBio(registerRequest.getBio());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setGithub(registerRequest.getGithub());
        user.setDateBirthday(registerRequest.getDateBirthday());
        user.setGender(registerRequest.getGender());
        user.setTechnology(registerRequest.getTechnology());
        user.setRole(Role.USER);

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        conformationTokenService.saveTokenConformation(confirmationToken);

        String link = "http://localhost:8000/api/v1/auth/register/confirm?token=" + token;

        emailSenderService.send(registerRequest.getEmail(), registerRequest.getMiddleName() + link);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse(
                jwtToken,
                token
        );

        return authenticationResponse;
    }

    public AuthenticationResponse authentication(AuthenticationRequest authenticationRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                authenticationRequest.getPassword()));

        var user = userRepository.findByEmail(authenticationRequest.getEmail());

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = conformationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationToken.setConfirmedAt(LocalDateTime.now());
        enableAppUser(
                confirmationToken.getUser().getEmail());
        return "confirmed";
    }

}
