package med.vol.api.Model.MedicosModel.Medicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.vol.api.Model.MedicosModel.Medicos.EnderecoMedico.EnderecoEntity;
import med.vol.api.Model.MedicosModel.Medicos.DTOS.MedicosDTO;

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

    @Enumerated(EnumType.STRING) // Mostra ao JPA que este campo é um enum e deve ser persistido como texto no banco,
// evitando problemas caso a ordem dos valores do enum seja alterada.
    private Especialidades especialidade;

    @Embedded // o jpa considera os campos dessa tabela atribuindo elas a essa entidade
    private EnderecoEntity endereco;




    public MedicoEntity(MedicosDTO medicosDTO) {
        this.nome = medicosDTO.nome();
        this.email = medicosDTO.email();
        this.telefone = medicosDTO.telefone();
        this.crm = medicosDTO.crm();
        this.especialidade = medicosDTO.especialidade();
        this.endereco = new EnderecoEntity(medicosDTO.endereco());
    }
}





