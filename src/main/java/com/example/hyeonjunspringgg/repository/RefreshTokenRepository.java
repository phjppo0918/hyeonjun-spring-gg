package com.example.hyeonjunspringgg.repository;

import com.example.hyeonjunspringgg.dto.AuthResponseDTO;

import java.util.Optional;

public interface RefreshTokenRepository {

   Optional<AuthResponseDTO> isExist(String token);
}
