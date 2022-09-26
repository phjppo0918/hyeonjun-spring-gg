package com.example.hyeonjunspringgg.service;

import com.example.hyeonjunspringgg.dto.AuthResponseDTO;
import com.example.hyeonjunspringgg.dto.CreateUserRequestDTO;
import com.example.hyeonjunspringgg.dto.LoginRequestDTO;
import com.example.hyeonjunspringgg.dto.UserResponseDTO;
import com.example.hyeonjunspringgg.dto.oauth2.OAuthUserDTO;
import com.example.hyeonjunspringgg.entity.User;
import com.example.hyeonjunspringgg.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.security.auth.message.AuthException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public List<UserResponseDTO> getAll() {
        List<User> targets =userRepository.findAll();
        return targets.stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
    }

    public AuthResponseDTO verifyLogin(LoginRequestDTO dto) throws AuthException {
        User user = userRepository.findByAccountId(dto.getAccountId())
                .orElseThrow(EntityNotFoundException::new);
        if(!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new AuthException();
        }

       // UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getAccountId(), dto.getPassword());

        return new AuthResponseDTO(user);
    }

    public UserResponseDTO save(CreateUserRequestDTO dto) {
        userRepository.findByAccountId(dto.getAccountId())
                    .ifPresent(u -> {throw new EntityExistsException();});

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));

        User saved = userRepository.save(dto.toEntity());
        return new UserResponseDTO(saved);
    }

    @Transactional
    public void delete(Long id) {
        User target = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        target.delete();
    }

    public User saveIfNone(OAuthUserDTO dto){
        return userRepository.findByAccountId(dto.getAccountId())
                .orElseGet(() -> {
                    dto.setNickname(dto.getAccountId());
                    return userRepository.save(dto.toEntity());
                });
    }
}
