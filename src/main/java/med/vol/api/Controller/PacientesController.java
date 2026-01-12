package med.vol.api.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import med.vol.api.Model.MedicosModel.PacientesModel.PacientesDTO;
import med.vol.api.Model.MedicosModel.PacientesModel.PacientesEntity;
import med.vol.api.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")

public class PacientesController {

    @Autowired
   private PacienteRepository pacienteRepository;

    @PutMapping
    @Transactional
    public void cadastrarPacientes(@RequestBody @Valid PacientesDTO dadosPacientes){
        pacienteRepository.save (new PacientesEntity(dadosPacientes));
    }
}
