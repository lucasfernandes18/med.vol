package med.vol.api.Domain.Pacientes.DTOs;

import med.vol.api.Domain.Pacientes.EnderecoPacientes.EnderecoPacientesMapper;
import med.vol.api.Domain.Pacientes.PacientesEntity;

public class MapperPacientesDTO {
    public PacientesEntity map(PacientesDTO pacientesDTO) {
        PacientesEntity pacientesEntity = new PacientesEntity();
        pacientesEntity.setNome(pacientesDTO.nome());
        pacientesEntity.setEmail(pacientesDTO.email());
        pacientesEntity.setTelefone(pacientesDTO.telefone());
        pacientesEntity.setEndereco(new EnderecoPacientesMapper().map(pacientesDTO.endereco()));
        return pacientesEntity;
    }

}
