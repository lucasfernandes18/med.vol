package med.vol.api.Controller;


import med.vol.api.Model.MedicosModel.MedicoEntity;
import med.vol.api.Model.MedicosModel.MedicosModel;
import med.vol.api.Model.MedicosModel.PacientesModel.PacientesModel;
import med.vol.api.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class HelloController {

    @Autowired
private MedicoRepository medicoRepository;

    @PutMapping
public void cadastrarMedicos(@RequestBody MedicoEntity dados){
       medicoRepository.save(new MedicoEntity(dados))
    }



}
