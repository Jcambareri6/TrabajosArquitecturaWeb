package Dto;

import Entities.Dao.Carrera;
import Entities.Dao.Estudiante;
import java.util.Date;

public class InscripcionDto {
    private Carrera carreraCursada;
    private Estudiante estudianteEnCurso;
    private Date Fecha_inscripcion;


    public InscripcionDto(Carrera c, Estudiante es){
        this.carreraCursada=c;
        this.estudianteEnCurso=es;
        this.Fecha_inscripcion = new Date();
    }
    public Carrera getCarreraCursada() {
        return carreraCursada;
    }

    public Estudiante getEstudianteEnCurso() {
        return estudianteEnCurso;
    }

    public Date getFecha_inscripcion() {
        return Fecha_inscripcion;
    }
}
