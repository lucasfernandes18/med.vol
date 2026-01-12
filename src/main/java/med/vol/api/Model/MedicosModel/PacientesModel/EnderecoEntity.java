package med.vol.api.Model.MedicosModel.PacientesModel;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table (name = "endereco_pacientes")
@Embeddable
@Data
@RequiredArgsConstructor

public class EnderecoEntity {

    private String logradouro;
    private String bairro;
    private Long cep;
    private String cidade;
    private String uf;
    private String complemento;
    private Number numero;

    EnderecoEntity (EnderecoPacientesDTO dadosEndereco){
        this.logradouro = dadosEndereco.logradouro();
        this.bairro = dadosEndereco.bairro();
        this.cep = dadosEndereco.cep();
        this.cidade = dadosEndereco.cidade();
        this.uf = dadosEndereco.uf();
        this.complemento = dadosEndereco.complemento();
        this.numero = dadosEndereco.numero();
    }



}
