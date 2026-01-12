package med.vol.api.Model.MedicosModel.PacientesModel;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

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

    @Embedded
    private EnderecoPacientesDTO endereco;

   public PacientesEntity (PacientesDTO dadosPacientes){
        this.nome = dadosPacientes.nome();
        this.email = dadosPacientes.email();
        this.telefone = dadosPacientes.telefone();
        this.endereco = dadosPacientes.endereco();
    }













}
