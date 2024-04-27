package pe.edu.cibertec.WAEC2Grupo7.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2Grupo7.model.bd.Docente;
import pe.edu.cibertec.WAEC2Grupo7.repository.DocenteRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class DocenteService implements IDocenteService {

    private DocenteRepository docenteRepository;

    @Override
    public List<Docente> listarDocentes() {
        return docenteRepository.findAll();
    }

}
