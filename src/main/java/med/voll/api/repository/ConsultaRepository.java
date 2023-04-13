package med.voll.api.repository;

import med.voll.api.entity.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
