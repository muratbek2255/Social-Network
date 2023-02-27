package com.example.socialnetwork.service;


import com.example.socialnetwork.entity.ConfirmationToken;
import com.example.socialnetwork.repository.ConformationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class ConformationTokenService {

    private final ConformationTokenRepository conformationTokenRepository;

    public void saveTokenConformation(ConfirmationToken token) {
        conformationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return conformationTokenRepository.findByToken(token);
    }

    @Autowired
    public ConformationTokenService(ConformationTokenRepository conformationTokenRepository) {
        this.conformationTokenRepository = conformationTokenRepository;
    }

    public int setConfirmedAt(String token) {
        return conformationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
