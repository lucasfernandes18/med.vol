package med.vol.api.Model.MedicosModel.Pacientes.PacientesService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import med.vol.api.Model.MedicosModel.Pacientes.DTOs.DadosDeAtualizacaoPacientes;
import med.vol.api.Model.MedicosModel.Pacientes.PacientesEntity;
import med.vol.api.Model.MedicosModel.Pacientes.PacientesRepository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;


    public PacientesEntity informacoesDeAtualizacao(@Valid  Long id, DadosDeAtualizacaoPacientes atualizacaoPacientes) {
       PacientesEntity pacientesEntity = pacienteRepository.getReferenceById(id);

        if (atualizacaoPacientes.nome() != null){
            pacientesEntity.setNome(atualizacaoPacientes.nome());
        }
        if (atualizacaoPacientes.email() != null){
            pacientesEntity.setEmail(atualizacaoPacientes.email());
        }
        if (atualizacaoPacientes.telefone() != null){
            pacientesEntity.setTelefone(atualizacaoPacientes.telefone());
        }
        if (atualizacaoPacientes.atividade() != null){
            pacientesEntity.setAtividade(atualizacaoPacientes.atividade());
        }
        if (atualizacaoPacientes.endereco() != null){
            pacientesEntity.getEndereco().atualizacaoEnderecoPacientes(atualizacaoPacientes.endereco());
        }
        return pacienteRepository.save(pacientesEntity);


    }

    public void desativarPacientes(){
        PacientesEntity pacientesEntity = new PacientesEntity();
        pacientesEntity.setAtividade(false);
    }



}
