package med.vol.api.Domain.Usuario;

import jakarta.validation.Valid;
import med.vol.api.Domain.Usuario.DTOS.DadosDeAutenticacaoDTO;
import med.vol.api.Domain.Usuario.DTOS.RegistroUsuarioDTO;
import med.vol.api.Infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity efetirarLogin(@RequestBody @Valid DadosDeAutenticacaoDTO dados){

        var usernamePassword = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = this.manager.authenticate(usernamePassword);


        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity registrarUsuario (@RequestBody @Valid RegistroUsuarioDTO dados){
        if(this.usuarioRepository.findByLogin(dados.login()) != null) return ResponseEntity.badRequest().build();

        String encriptedPassword = new BCryptPasswordEncoder().encode(dados.senha());
        UsuarioEntity newUser = new UsuarioEntity(dados.login(), encriptedPassword, dados.role());

        this.usuarioRepository.save(newUser);

        return ResponseEntity.ok().build();
    }



}
