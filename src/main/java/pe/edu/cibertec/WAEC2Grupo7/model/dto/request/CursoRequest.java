package pe.edu.cibertec.WAEC2Grupo7.model.dto.request;

import lombok.Data;

import java.sql.Date;

@Data
public class CursoRequest {

    private Integer idcurso;
    private String nomcurso;
    private String resumen;
    private Date fecharegistro;
    private Integer iddocente;


}
