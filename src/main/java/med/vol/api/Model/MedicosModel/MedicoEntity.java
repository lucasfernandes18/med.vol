package med.vol.api.Model.MedicosModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "medico")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicoEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Long telefone;
    private Long crm;
    private Especialidades especialidades;
    private DadosEndereco endereco;
}
