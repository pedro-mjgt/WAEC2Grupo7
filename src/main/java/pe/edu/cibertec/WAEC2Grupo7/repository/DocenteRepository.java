package pe.edu.cibertec.WAEC2Grupo7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.WAEC2Grupo7.model.bd.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {
}
