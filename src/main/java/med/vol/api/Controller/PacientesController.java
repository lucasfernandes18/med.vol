package med.vol.api.Controller;

import med.vol.api.Model.MedicosModel.PacientesModel.PacientesModel;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @PutMapping
    public void cadastrarPacientes(@RequestBody PacientesModel dados){
        System.out.println(dados);
    }
}
