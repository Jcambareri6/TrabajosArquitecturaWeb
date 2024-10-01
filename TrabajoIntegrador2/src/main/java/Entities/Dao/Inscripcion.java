package Entities.Dao;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Inscripcion {
    @EmbeddedId
    private  CarrerasCursadasPk pk_CarrerasCursadas;
    @ManyToOne
    @MapsId("idCarrera")
    @JoinColumn(name ="idCarrera")
    private Carrera carreraCursada;
    @ManyToOne
    @MapsId("idEstudiante")
    @JoinColumn(name ="idEstudiante")
    private Estudiante estudianteEnCurso;
    private Date Fecha_inscripcion;
    private  Date fecha_Graduacion;

    public Inscripcion(Carrera c, Estudiante es){
        this.pk_CarrerasCursadas = new CarrerasCursadasPk(c.getIdCarrera(),es.getLibretaUniversitaria());
        this.carreraCursada=c;
        this.estudianteEnCurso=es;
        this.Fecha_inscripcion = new Date();
    }
    public CarrerasCursadasPk getPk_CarrerasCursadas() {
        return pk_CarrerasCursadas;
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

    public Inscripcion() {

    }



}
