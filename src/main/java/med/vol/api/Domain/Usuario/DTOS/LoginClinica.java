package med.vol.api.Domain.Usuario.DTOS;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clinica")
public class LoginClinica {

    @GetMapping
    public ResponseEntity loginClinica(){
        System.out.println("login Realizado");
        return ResponseEntity.ok().build();
    }
}
