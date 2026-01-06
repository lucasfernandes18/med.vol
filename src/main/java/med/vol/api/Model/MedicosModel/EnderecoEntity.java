package med.vol.api.Model.MedicosModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table (name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class EnderecoEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String bairro;
    private Long cep;
    private String cidade;
    private String uf;
    private String complemento;
    private Number numero;
}
