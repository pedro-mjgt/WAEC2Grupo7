package pe.edu.cibertec.WAEC2Grupo7.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.WAEC2Grupo7.model.bd.Docente;
import pe.edu.cibertec.WAEC2Grupo7.service.IDocenteService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/docente")
public class DocenteController {

    private IDocenteService iDocenteService;

    @GetMapping("/get")
    @ResponseBody
    public List<Docente> listaDocentes() {
        return iDocenteService.listarDocentes();
    }

}
