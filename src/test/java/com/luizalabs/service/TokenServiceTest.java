package com.luizalabs.service;

import com.luizalabs.exception.AccessDeniedException;
import com.luizalabs.security.Credentials;
import com.luizalabs.security.JWTUtil;
import com.luizalabs.service.TokenService;
import com.luizalabs.util.CDIExtension;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(CDIExtension.class)
public class TokenServiceTest {

    @InjectMocks
    private TokenService tokenService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loginSuccess(){
        Credentials credentials = new Credentials();
        credentials.setUsername("admin");
        credentials.setPassword("admin");
        String token = tokenService.login(credentials);

        Jws<Claims> claims = JWTUtil.decode(token);
        assertEquals(claims.getBody().getSubject(), credentials.getUsername());
    }

    @Test
    public void loginAccessDenied(){
        Credentials credentials = new Credentials();
        credentials.setUsername("admi1n");
        credentials.setPassword("admin");
        assertThrows(AccessDeniedException.class, () -> tokenService.login(credentials), "Usuário ou senha incorretos!");
    }
}
