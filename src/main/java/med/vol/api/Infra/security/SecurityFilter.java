package med.vol.api.Infra.security;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.vol.api.Domain.Usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.temporal.ValueRange;

@Component
public class SecurityFilter extends OncePerRequestFilter {

@Autowired
private TokenService tokenService;

@Autowired
private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      var tokenJwt = recuperarToken(request);
      if  (tokenJwt != null) {
          var subject = tokenService.getSubject(tokenJwt);
          UserDetails usuario = usuarioRepository.findByLogin(subject);

          var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
          SecurityContextHolder.getContext().setAuthentication(authentication);
      }

        // indica para que a aplicação continue após chegar na camada de filtros
        filterChain.doFilter(request, response);

    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null ) {
            return authorizationHeader.replace("Bearer ", "");
        }
        //replace remove o prefixo do retorno do token
         return null;
    }
}
