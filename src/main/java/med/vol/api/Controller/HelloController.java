package med.vol.api.Controller;


import med.vol.api.Model.MedicosModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @PutMapping
public void cadastrar(@RequestBody MedicosModel dados){
        System.out.println(dados);
    }

}
