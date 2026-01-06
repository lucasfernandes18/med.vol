package med.vol.api.Controller;


import med.vol.api.Model.MedicosModel.MedicosModel;
import med.vol.api.Model.MedicosModel.PacientesModel.PacientesModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class HelloController {


    @PutMapping
public void cadastrarMedicos(@RequestBody MedicosModel dados){
        System.out.println(dados);
    }



}
