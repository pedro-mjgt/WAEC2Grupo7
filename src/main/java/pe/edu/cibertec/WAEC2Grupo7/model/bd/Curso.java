package pe.edu.cibertec.WAEC2Grupo7.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcurso;

    private String nomcurso;
    private String resumen;
    private Date fecharegistro;

    @ManyToOne
    @JoinColumn(name = "iddocente")
    private Docente docente;

}
