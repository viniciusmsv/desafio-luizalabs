package com.luizalabs.service;

import com.luizalabs.exception.AccessDeniedException;
import com.luizalabs.security.Credentials;
import com.luizalabs.security.JWTUtil;

public class TokenService {

    public String login(Credentials credentials) {
        /**
         * Autenticacao e autorizacao foram mockados. Solução final envolveria salvar em alguma base de dados,
         * para validar usuario e senha com o token. E também validar o tempo de expiração.
         */
        if (JWTUtil.USERNAME.equals(credentials.getUsername()) && JWTUtil.PASSWORD.equals(credentials.getPassword())) {
            return JWTUtil.create(JWTUtil.USERNAME);
        } else {
            throw new AccessDeniedException("Usuário ou senha incorretos!");
        }
    }
}
