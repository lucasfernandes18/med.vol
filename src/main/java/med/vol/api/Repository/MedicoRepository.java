package med.vol.api.Repository;

import med.vol.api.Model.MedicosModel.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {
}
