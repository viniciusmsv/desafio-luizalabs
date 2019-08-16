package com.luizalabs.security;

import com.luizalabs.exception.AccessDeniedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebFilter("/api/*")
public class JWTFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(JWTFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        try {
            if (req.getRequestURI().startsWith("/desafio-luizalabs/api/token") ||
                    req.getRequestURI().startsWith("/desafio-luizalabs/api/swagger.json")) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

            String token = req.getHeader(JWTUtil.TOKEN_HEADER);

            if (token == null || token.trim().isEmpty()) {
                LOGGER.info("Acesso negado!");
                throw new AccessDeniedException("Acesso negado!");
            }


            Jws<Claims> parser = JWTUtil.decode(token);
            if (!JWTUtil.USERNAME.equals(parser.getBody().getSubject())) {
                LOGGER.info("Acesso negado!");
                throw new AccessDeniedException("Acesso negado!");
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            LOGGER.log(Level.INFO, "Acesso negado!", e);
            res.sendError(401, "Acesso negado!");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
