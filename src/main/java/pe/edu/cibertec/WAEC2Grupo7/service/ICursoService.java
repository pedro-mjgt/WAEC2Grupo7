package pe.edu.cibertec.WAEC2Grupo7.service;

import pe.edu.cibertec.WAEC2Grupo7.model.bd.Curso;

import java.util.List;
import java.util.Optional;

public interface ICursoService {

    List<Curso> listarCursos();
    void registrarCurso(Curso curso);
    Optional<Curso> obtenerCursoxId(Integer id);
    void eliminarCurso(Curso curso);


}
