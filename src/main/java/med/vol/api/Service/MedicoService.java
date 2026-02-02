package med.vol.api.Service;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.vol.api.Model.MedicosModel.Medicos.DadosDeAtualizacaoMedico;
import med.vol.api.Model.MedicosModel.Medicos.MedicoEntity;
import med.vol.api.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data

public class MedicoService {


    @Autowired
    private MedicoRepository medicoRepository;


        public MedicoEntity atualizarInformacoes(@Valid Long id, DadosDeAtualizacaoMedico atualizacao) {
            MedicoEntity medicoEntity = medicoRepository.getReferenceById(id);

        if (atualizacao.nome() != null){
           medicoEntity.setNome(atualizacao.nome());
        }
        if (atualizacao.telefone() != null){
            medicoEntity.setTelefone(atualizacao.telefone());
        }
        if (atualizacao.endereco() != null){
            medicoEntity.getEndereco().atualizarInformacoes(atualizacao.endereco());
        }

        return medicoRepository.save(medicoEntity);
    }

    public void desativar( ){
        MedicoEntity medicoEntity = new MedicoEntity();
        medicoEntity.setAtivo(false);
        }


}
