package med.vol.api.Model.MedicosModel.Medicos.MedicosController;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.Model.MedicosModel.Medicos.DTOS.MedicosMapper;
import med.vol.api.Model.MedicosModel.Medicos.DTOS.DadosDeAtualizacaoMedico;
import med.vol.api.Model.MedicosModel.Medicos.MedicoEntity;
import med.vol.api.Model.MedicosModel.Medicos.DTOS.MedicoListagem;
import med.vol.api.Model.MedicosModel.Medicos.DTOS.MedicosDTO;
import med.vol.api.Model.MedicosModel.Medicos.MedicosRepository.MedicoRepository;
import med.vol.api.Model.MedicosModel.Medicos.MedicoService.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
private MedicoRepository medicoRepository;
    @Autowired
    private MedicoService medicoService;


    @PostMapping
    @Transactional //
     //@Valid se conecta com o bean validation e solicita as verificações desse dto.
public ResponseEntity cadastrarMedicos(@RequestBody @Valid  MedicosDTO dados, UriComponentsBuilder uriBuilder){
        MedicoEntity medico = new MedicosMapper().map(dados);

        medicoRepository.save(medico);

       var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
       return ResponseEntity.created(uri).body(dados);
    }


   //Pega apenas as informações especificadas no trelo usando um dto.
    @GetMapping
    public ResponseEntity<Page<MedicoListagem>> listarMedicos(Pageable paginacao) {
         var page = medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoListagem::new);
         return ResponseEntity.ok(page);
    }
    // Mapeia a lista de entidades Medico para DTOs MedicoListagem e retorna o resultado
    // Interface Page da o controle de quantos elementos são retornados e as informações de quantos existem no banco

    @PutMapping
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody @Valid DadosDeAtualizacaoMedico atualizacao){
         var medico = medicoService.atualizarInformacoes(atualizacao.id(), atualizacao);

        return ResponseEntity.ok(new MedicoListagem(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativaredico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medicoService.desativar();
        return ResponseEntity.noContent().build();
    }

   @GetMapping("/{id}")
    public ResponseEntity detalharMedico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new MedicoListagem(medico));
    }




}
