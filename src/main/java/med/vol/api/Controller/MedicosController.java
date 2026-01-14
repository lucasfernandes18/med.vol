package med.vol.api.Controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.Model.MedicosModel.DadosDeAtualizacaoMedico;
import med.vol.api.Model.MedicosModel.MedicoEntity;
import med.vol.api.Model.MedicosModel.MedicoListagem;
import med.vol.api.Model.MedicosModel.MedicosDTO;
import med.vol.api.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicosController {

    @Autowired
private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional //
     //@Valid se conecta com o bean validation e solicita as verificações desse dto.
public void cadastrarMedicos(@RequestBody @Valid  MedicosDTO dados){
       medicoRepository.save(new MedicoEntity(dados));
    }


   //Pega apenas as informações especificadas no trelo usando um dto.
    @GetMapping
    public Page<MedicoListagem> listarMedicos(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoListagem::new);
    }
    // Mapeia a lista de entidades Medico para DTOs MedicoListagem e retorna o resultado
    // Interface Page da o controle de quantos elementos são retornados e as informações de quantos existem no banco

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid DadosDeAtualizacaoMedico atualizacao){
     var medico = medicoRepository.getReferenceById(atualizacao.id());
     medico.atualizarInformacoes(atualizacao);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void desativaredico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.desativar();
    }




}
