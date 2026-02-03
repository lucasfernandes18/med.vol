package med.vol.api.Model.MedicosModel.Medicos.EnderecoMedico;

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
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private Integer numero;

    public EnderecoEntity(EnderecoDTO enderecoDTO) {
        this.logradouro = enderecoDTO.logradouro();
        this.bairro = enderecoDTO.bairro();
        this.cep = enderecoDTO.cep();
        this.cidade = enderecoDTO.cidade();
        this.uf = enderecoDTO.uf();
        this.complemento =enderecoDTO.complemento();
        this.numero = enderecoDTO.numero();
    }

    public void atualizarInformacoes(EnderecoDTO dados){
    if(dados.logradouro() != null){
        this.logradouro = dados.logradouro();
    }
    if(dados.bairro() != null){
        this.bairro = dados.bairro();
    }
    if(dados.cep() != null){
        this.cep = dados.cep();
    }
    if(dados.cidade() != null){
        this.cidade = dados.cidade();
    }
    if(dados.uf() != null){
        this.uf = dados.uf();
    }
    if(dados.complemento() != null){
        this.complemento = dados.complemento();
    }
    if(dados.numero() != null){
        this.numero = dados.numero();
    }

}






}
