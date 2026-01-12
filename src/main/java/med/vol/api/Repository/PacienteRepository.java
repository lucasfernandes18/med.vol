package med.vol.api.Repository;

import med.vol.api.Model.MedicosModel.PacientesModel.PacientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacientesEntity, Long> {
}
