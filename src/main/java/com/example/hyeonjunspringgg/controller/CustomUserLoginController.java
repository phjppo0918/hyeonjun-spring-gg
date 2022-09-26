package com.example.hyeonjunspringgg.controller;

import com.example.hyeonjunspringgg.dto.CreateUserRequestDTO;
import com.example.hyeonjunspringgg.dto.JWTTokenDTO;
import com.example.hyeonjunspringgg.dto.LoginRequestDTO;
import com.example.hyeonjunspringgg.dto.UserResponseDTO;
import com.example.hyeonjunspringgg.service.AuthService;
import com.example.hyeonjunspringgg.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class CustomUserLoginController {
    private final UserService userService;
    private final AuthService authService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        List<UserResponseDTO> result = userService.getAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> join(@RequestBody CreateUserRequestDTO dto) {
        log.info("join 실행");
        UserResponseDTO result = userService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PostMapping("login")
    public ResponseEntity<JWTTokenDTO> login(@RequestBody LoginRequestDTO dto,
                                             HttpServletResponse response) throws AuthException {
        JWTTokenDTO tokenDto = authService.getJwtToken(dto);
        authService.addJwtTokensInCookie(response, tokenDto);
        return ResponseEntity.ok(tokenDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}