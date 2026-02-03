package med.vol.api.Model.MedicosModel.Medicos.DTOS;

import med.vol.api.Model.MedicosModel.Medicos.EnderecoMedico.EnderecoMapper;
import med.vol.api.Model.MedicosModel.Medicos.MedicoEntity;

public class MedicosMapper {

    public MedicoEntity map(MedicosDTO medicosDTO) {
        MedicoEntity medico = new MedicoEntity();
        medico.setNome(medicosDTO.nome());
        medico.setEmail(medicosDTO.email());
        medico.setTelefone(medicosDTO.telefone());
        medico.setCrm(medicosDTO.crm());
        medico.setEspecialidade(medicosDTO.especialidade());
        medico.setEndereco(new EnderecoMapper().map(medicosDTO.endereco()));

        return  medico;

    }



}







