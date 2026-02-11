package med.vol.api.Infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import med.vol.api.Domain.Usuario.UsuarioEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    public String generateToken(UsuarioEntity usuario){
        try {
            var algorithm = Algorithm.HMAC256("secret");
            return JWT.create()
                    .withIssuer("API Voll.med")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar token", exception);
        }

    }

    private Instant dataExpiracao(){
        //duas horas de expiração apartir do horário do login
        return LocalDateTime.now().plusDays(7).toInstant(ZoneOffset.of("-03:00"));
    }



}
