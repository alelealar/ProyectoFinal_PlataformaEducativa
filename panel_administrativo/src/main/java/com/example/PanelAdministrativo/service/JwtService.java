package com.example.PanelAdministrativo.service;

import com.example.PanelAdministrativo.model.Alumno;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * Genera y valida los tokens JWT que usa el storefront para consumir la API REST.
 */
@Service
public class JwtService {

    public static final String CLAIM_ROL = "rol";
    public static final String CLAIM_MATRICULA = "matricula";
    public static final String ROL_ALUMNO = "ALUMNO";

    private final SecretKey llave;
    private final long expiracionMs;

    public JwtService(@Value("${jwt.secret}") String secreto,
                      @Value("${jwt.expiracion-ms}") long expiracionMs) {
        this.llave = Keys.hmacShaKeyFor(secreto.getBytes(StandardCharsets.UTF_8));
        this.expiracionMs = expiracionMs;
    }

    public String generarTokenAlumno(Alumno alumno) {
        Date ahora = new Date();
        return Jwts.builder()
                .subject(String.valueOf(alumno.getId()))
                .claim(CLAIM_ROL, ROL_ALUMNO)
                .claim(CLAIM_MATRICULA, alumno.getMatricula())
                .issuedAt(ahora)
                .expiration(new Date(ahora.getTime() + expiracionMs))
                .signWith(llave)
                .compact();
    }

    /**
     * Valida firma y vigencia del token.
     *
     * @throws io.jsonwebtoken.JwtException si el token no es válido o ya expiró
     */
    public Claims validarToken(String token) {
        return Jwts.parser()
                .verifyWith(llave)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public long getExpiracionSegundos() {
        return expiracionMs / 1000;
    }
}
