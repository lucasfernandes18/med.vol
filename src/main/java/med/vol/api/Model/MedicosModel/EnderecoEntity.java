package med.vol.api.Model.MedicosModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
@ToString

public class EnderecoEntity {

    private String logradouro;
    private String bairro;
    private Long cep;
    private String cidade;
    private String uf;
    private String complemento;
    private Integer numero;


public EnderecoEntity(EnderecoDTO dados){
    this.logradouro = dados.logradouro();
    this.bairro = dados.bairro();
    this.cep = dados.cep();
    this.cidade = dados.cidade();
    this.uf = dados.uf();
    this.complemento = dados.complemento();
    this.numero = dados.numero();
}







}
