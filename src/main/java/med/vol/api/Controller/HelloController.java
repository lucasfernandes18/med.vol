package med.vol.api.Controller;


import jakarta.transaction.Transactional;
import med.vol.api.Model.MedicosModel.MedicoEntity;
import med.vol.api.Model.MedicosModel.MedicosDTO;
import med.vol.api.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class HelloController {

    @Autowired
private MedicoRepository medicoRepository;

    @PutMapping
    @Transactional //
public void cadastrarMedicos(@RequestBody MedicosDTO dados){
       medicoRepository.save(new MedicoEntity(dados));
    }



}
