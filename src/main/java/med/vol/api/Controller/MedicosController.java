package med.vol.api.Controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.Model.MedicosModel.Medicos.DadosDeAtualizacaoMedico;
import med.vol.api.Model.MedicosModel.Medicos.MedicoEntity;
import med.vol.api.Model.MedicosModel.Medicos.MedicoListagem;
import med.vol.api.Model.MedicosModel.Medicos.DTOS.MedicosDTO;
import med.vol.api.Repository.MedicoRepository;
import med.vol.api.Service.MedicoService;
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
        var medico = new MedicoEntity();

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




}
