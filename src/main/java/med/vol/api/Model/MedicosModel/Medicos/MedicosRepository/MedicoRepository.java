package med.vol.api.Model.MedicosModel.Medicos.MedicosRepository;

import med.vol.api.Model.MedicosModel.Medicos.MedicoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {
    Page<MedicoEntity> findAllByAtivoTrue(Pageable paginacao);
}
