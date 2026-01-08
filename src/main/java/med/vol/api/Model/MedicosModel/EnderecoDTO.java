package med.vol.api.Model.MedicosModel;

public record EnderecoDTO(String logradouro, String bairro, Long cep, String cidade, String uf, String complemento, Integer numero) {
}
