package med.vol.api.Model.MedicosModel.Pacientes.PacientesRepository;

import med.vol.api.Model.MedicosModel.Pacientes.PacientesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacientesEntity, Long> {
    Page<PacientesEntity> findAllByAtivoTrue(Pageable paginacao);
}
