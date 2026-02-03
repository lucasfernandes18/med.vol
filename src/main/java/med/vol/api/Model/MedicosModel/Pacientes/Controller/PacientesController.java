package med.vol.api.Model.MedicosModel.Pacientes.Controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.Model.MedicosModel.Pacientes.DTOs.DadosDeAtualizacaoPacientes;
import med.vol.api.Model.MedicosModel.Pacientes.DTOs.InformacoesPacientes;
import med.vol.api.Model.MedicosModel.Pacientes.DTOs.MapperPacientesDTO;
import med.vol.api.Model.MedicosModel.Pacientes.DTOs.PacientesDTO;
import med.vol.api.Model.MedicosModel.Pacientes.PacientesEntity;
import med.vol.api.Model.MedicosModel.Pacientes.PacientesRepository.PacienteRepository;
import med.vol.api.Model.MedicosModel.Pacientes.PacientesService.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")

public class PacientesController {
    @Autowired
    private PacienteService pacienteService;

    @Autowired
   private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPacientes(@RequestBody @Valid PacientesDTO dadosPacientes, UriComponentsBuilder uriBuilder) {
        PacientesEntity pacientes = new MapperPacientesDTO().map(dadosPacientes);

        pacienteRepository.save (pacientes);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(pacientes.getId()).toUri();
        return ResponseEntity.created(uri).body(dadosPacientes);
    }

    @GetMapping
    public ResponseEntity<Page<InformacoesPacientes>> listarPacientes(Pageable paginacao){
      var page = pacienteRepository.findAllByAtivoTrue(paginacao).map(InformacoesPacientes::new);
      return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity atualizarPacientes(@RequestBody @Valid DadosDeAtualizacaoPacientes pacientes){
       var pacientesAtualizados = pacienteService.informacoesDeAtualizacao(pacientes.id(), pacientes);
       return ResponseEntity.ok(new InformacoesPacientes(pacientesAtualizados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity desativarPaciente(@PathVariable Long id){
      var paciente = pacienteRepository.getReferenceById(id);
        pacienteService.desativarPacientes();
        return ResponseEntity.noContent().build();
    }





}
