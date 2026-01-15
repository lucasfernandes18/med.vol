package med.vol.api.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import med.vol.api.Model.MedicosModel.PacientesModel.DadosDeAtualizacaoPacientes;
import med.vol.api.Model.MedicosModel.PacientesModel.InformacoesPacientes;
import med.vol.api.Model.MedicosModel.PacientesModel.PacientesDTO;
import med.vol.api.Model.MedicosModel.PacientesModel.PacientesEntity;
import med.vol.api.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")

public class PacientesController {

    @Autowired
   private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrarPacientes(@RequestBody @Valid PacientesDTO dadosPacientes){
        pacienteRepository.save (new PacientesEntity(dadosPacientes));
    }

    @GetMapping
    public Page<InformacoesPacientes> listarPacientes(Pageable paginacao){
      return  pacienteRepository.findAll(paginacao).map(InformacoesPacientes::new);
    }

    @PutMapping
    public void atualizarPacientes(DadosDeAtualizacaoPacientes pacientes){
       var pacientesAtualizados = pacienteRepository.getReferenceById(pacientes.id());
       pacientesAtualizados.informacoesDeAtualizacao(pacientes);
    }

    @DeleteMapping("/{id}")
    public void desativarPaciente(@PathVariable Long id){
      var paciente = pacienteRepository.getReferenceById(id);
        paciente.desativarPacientes();
    }





}
