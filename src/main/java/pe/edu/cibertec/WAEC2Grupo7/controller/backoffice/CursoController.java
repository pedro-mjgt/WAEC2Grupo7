package pe.edu.cibertec.WAEC2Grupo7.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.cibertec.WAEC2Grupo7.model.bd.Curso;
import pe.edu.cibertec.WAEC2Grupo7.model.bd.Docente;
import pe.edu.cibertec.WAEC2Grupo7.model.dto.request.CursoRequest;
import pe.edu.cibertec.WAEC2Grupo7.model.dto.response.ResultadoResponse;
import pe.edu.cibertec.WAEC2Grupo7.service.ICursoService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@RequestMapping("/curso")
public class CursoController {

    private ICursoService iCursoService;

    @GetMapping("")
    public String formCurso(Model model) {
        model.addAttribute("listacursos", iCursoService.listarCursos());
        return  "backoffice/curso/formcurso";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Curso> listaCursos() {
        return iCursoService.listarCursos();
    }

    @PostMapping("/register")
    @ResponseBody
    public ResultadoResponse registerCurso(@RequestBody CursoRequest cursoRequest) {
        String mensaje = "Curso registrado correctamente";
        boolean respuesta = true;

        try {
            Curso curso = new Curso();

            if (cursoRequest.getIdcurso() > 0) {
                curso.setIdcurso(cursoRequest.getIdcurso());
            }

            curso.setNomcurso(cursoRequest.getNomcurso());
            curso.setResumen(cursoRequest.getResumen());
            curso.setFecharegistro(cursoRequest.getFecharegistro());

            Docente docente = new Docente();
            docente.setIddocente(cursoRequest.getIddocente());
            curso.setDocente(docente);

            iCursoService.registrarCurso(curso);
        }
        catch (Exception ex) {
            mensaje = "Curso no registrado, error en la BD";
            respuesta = false;
        }

        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @PostMapping("/eliminar")
    public String eliminarCurso(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        String mensaje = "Curso eliminado correctamente";

        try {
            Optional<Curso> curso = iCursoService.obtenerCursoxId(id);
            if (curso.isPresent()) {
                iCursoService.eliminarCurso(curso.get());
                redirectAttributes.addFlashAttribute("mensaje", mensaje);
            }
            else {
                mensaje = "No se encontro el curso";
                redirectAttributes.addFlashAttribute("error", mensaje);
            }
        }
        catch (Exception ex) {
            mensaje = "Error al eliminar el curos";
            redirectAttributes.addFlashAttribute("error", mensaje);
        }

        return "redirect:/curso";
    }

}
