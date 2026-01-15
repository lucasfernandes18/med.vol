package med.vol.api.Model.MedicosModel.PacientesModel;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import med.vol.api.Model.MedicosModel.EnderecoMedicoModel.EnderecoEntity;
import med.vol.api.Model.MedicosModel.EnderecoPacientes.EnderecoPacientesDTO;
import med.vol.api.Model.MedicosModel.EnderecoPacientes.EnderecoPacientesEntity;

@Entity
@Table(name = "pacientes")
@Data
@RequiredArgsConstructor
public class PacientesEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Long telefone;
    private Boolean atividade;

    @Embedded
    private EnderecoPacientesEntity endereco;

   public PacientesEntity (PacientesDTO dadosPacientes){
        this.nome = dadosPacientes.nome();
        this.email = dadosPacientes.email();
        this.telefone = dadosPacientes.telefone();
        this.atividade = true;
        this.endereco = new EnderecoPacientesEntity(dadosPacientes.endereco());
    }

    public void informacoesDeAtualizacao(@Valid DadosDeAtualizacaoPacientes atualizacaoPacientes) {
       if (atualizacaoPacientes.nome() != null){
           this.nome = atualizacaoPacientes.nome();
       }
        if (atualizacaoPacientes.email() != null){
            this.email = atualizacaoPacientes.email();
        }
        if (atualizacaoPacientes.telefone() != null){
            this.telefone = atualizacaoPacientes.telefone();
        }
        if (atualizacaoPacientes.atividade() != null){
            this.atividade = atualizacaoPacientes.atividade();
        }
        if (atualizacaoPacientes.endereco() != null){
            this.endereco.atualizacaoEnderecoPacientes(atualizacaoPacientes.endereco());
        }

    }

    public void desativarPacientes(){
       this.atividade = false;
    }












}
