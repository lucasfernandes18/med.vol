package med.vol.api.Model.MedicosModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table (name = "medico")
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
    private Long telefone;
    private Long crm;
    private Especialidades especialidades;

    @Embedded // o jpa considera os campos dessa tabela atribuindo elas a essa entidade
    private EnderecoEntity endereco;

    public MedicoEntity(MedicosModel dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidades = dados.especialidades();
        this.endereco = new EnderecoEntity(dados.endereco());
    }
}
