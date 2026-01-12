package med.vol.api.Controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.Model.MedicosModel.MedicoEntity;
import med.vol.api.Model.MedicosModel.MedicosDTO;
import med.vol.api.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
private MedicoRepository medicoRepository;

    @PutMapping
    @Transactional //
     //@Valid se conecta com o bean validation e solicita as verificações desse dto.
public void cadastrarMedicos(@RequestBody @Valid  MedicosDTO dados){
       medicoRepository.save(new MedicoEntity(dados));
    }



}
