package com.example.socialnetwork.controller;

import com.example.socialnetwork.dto.requests.AuthenticationRequest;
import com.example.socialnetwork.dto.requests.RegisterRequest;
import com.example.socialnetwork.dto.response.AuthenticationResponse;
import com.example.socialnetwork.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {


    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest
                                                                   registerRequest){
        return ResponseEntity.ok(authenticationService.registration(registerRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest
                                                                   authenticationRequest){
        return ResponseEntity.ok(authenticationService.authentication(authenticationRequest));
    }

    @GetMapping("/register/confirm")
    public String confirm(@RequestParam("token") String token) {
        return authenticationService.confirmToken(token);
    }
}
