package Entities.Dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.JoinColumn;

@Entity
public class CarrerasCursadas {

    @ManyToOne

    @JoinColumn(name="libretaUniversitaria")
    private Estudiante alumno;

    @ManyToOne
    @JoinColumn(name="idCarrera")
    private Carrera carrera;

    private boolean Graduado;
    private int Antiguedad;

    @Id
    private Long id;

    // Getters and Setters
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }



    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public boolean isGraduado() {
        return Graduado;
    }

    public void setGraduado(boolean graduado) {
        Graduado = graduado;
    }

    public int getAntiguedad() {
        return Antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        Antiguedad = antiguedad;
    }
}
