package med.vol.api.Domain.Pacientes.EnderecoPacientes;

public class EnderecoPacientesMapper {
    public EnderecoPacientesEntity map (EnderecoPacientesDTO pacientesDTO) {
        EnderecoPacientesEntity enderecoPacientesEntity = new EnderecoPacientesEntity();
        enderecoPacientesEntity.setLogradouro(pacientesDTO.logradouro());
        enderecoPacientesEntity.setBairro(pacientesDTO.bairro());
        enderecoPacientesEntity.setCep(pacientesDTO.cep());
        enderecoPacientesEntity.setCidade(pacientesDTO.cidade());
        enderecoPacientesEntity.setUf(pacientesDTO.uf());
        enderecoPacientesEntity.setComplemento(pacientesDTO.complemento());
        enderecoPacientesEntity.setNumero(pacientesDTO.numero());

        return enderecoPacientesEntity;
    }




}
