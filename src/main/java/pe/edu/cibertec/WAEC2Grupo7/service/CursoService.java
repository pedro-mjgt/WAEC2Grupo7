package pe.edu.cibertec.WAEC2Grupo7.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2Grupo7.model.bd.Curso;
import pe.edu.cibertec.WAEC2Grupo7.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CursoService implements ICursoService {

    private CursoRepository cursoRepository;

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public void registrarCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public Optional<Curso> obtenerCursoxId(Integer id) {
        return cursoRepository.findById(id);
    }

    @Override
    public void eliminarCurso(Curso curso) {
        cursoRepository.delete(curso);
    }

}
