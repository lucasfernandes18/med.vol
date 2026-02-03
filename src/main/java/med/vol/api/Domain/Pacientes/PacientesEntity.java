package med.vol.api.Domain.Pacientes;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import med.vol.api.Domain.Pacientes.EnderecoPacientes.EnderecoPacientesEntity;
import med.vol.api.Domain.Pacientes.DTOs.PacientesDTO;

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
    private Boolean ativo;

    @Embedded
    private EnderecoPacientesEntity endereco;

   public PacientesEntity (PacientesDTO dadosPacientes){
        this.nome = dadosPacientes.nome();
        this.email = dadosPacientes.email();
        this.telefone = dadosPacientes.telefone();
        this.ativo = true;
        this.endereco = new EnderecoPacientesEntity(dadosPacientes.endereco());
    }













}
