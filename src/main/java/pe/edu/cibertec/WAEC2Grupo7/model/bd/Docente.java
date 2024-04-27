package pe.edu.cibertec.WAEC2Grupo7.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;

@Data
@Entity
@Table(name = "docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddocente;

    private String nomdocente;
    private String apedocente;
    private Date fechnacdocente;

}
