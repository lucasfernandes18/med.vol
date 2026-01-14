package med.vol.api.Model.MedicosModel;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.vol.api.Model.MedicosModel.EnderecoMedicoModel.EnderecoEntity;

@Entity
@Table (name = "medicos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MedicoEntity {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Boolean ativo;

    @Enumerated(EnumType.STRING) // Indica ao JPA que este campo é um enum e deve ser persistido como texto no banco,
// evitando problemas caso a ordem dos valores do enum seja alterada.
    private Especialidades especialidade;

    @Embedded // o jpa considera os campos dessa tabela atribuindo elas a essa entidade
    private EnderecoEntity endereco;

    public MedicoEntity(MedicosDTO dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new EnderecoEntity(dados.endereco());
    }

    public void atualizarInformacoes(@Valid DadosDeAtualizacaoMedico atualizacao) {
        if (atualizacao.nome() != null){
            this.nome = atualizacao.nome();
        }
        if (atualizacao.telefone() != null){
            this.telefone = atualizacao.telefone();
        }
        if (atualizacao.endereco() != null){
            this.endereco.atualizarInformacoes(atualizacao.endereco());
        }
    }

    public void desativar( ){
        this.ativo = false;
    }

}
