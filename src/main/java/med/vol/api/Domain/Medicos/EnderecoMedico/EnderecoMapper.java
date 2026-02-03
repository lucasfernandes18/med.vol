package med.vol.api.Domain.Medicos.EnderecoMedico;

public class EnderecoMapper {


    public EnderecoEntity map(EnderecoDTO dto) {
        EnderecoEntity endereco = new EnderecoEntity();

        endereco.setLogradouro(dto.logradouro());
        endereco.setBairro(dto.bairro());
        endereco.setCep(dto.cep());
        endereco.setCidade(dto.cidade());
        endereco.setUf(dto.uf());
        endereco.setComplemento(dto.complemento());
        endereco.setNumero(dto.numero());

        return endereco;
}
}
