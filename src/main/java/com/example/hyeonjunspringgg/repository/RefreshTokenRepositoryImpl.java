package com.example.hyeonjunspringgg.repository;

import com.example.hyeonjunspringgg.dto.AuthResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RefreshTokenRepositoryImpl implements RefreshTokenRepository {
    @Override
    public Optional<AuthResponseDTO> isExist(String token) {
        return Optional.empty();
    }
}
