package Entities.Dao;

import javax.persistence.*;

@Entity
@Table(name = "CarreraCursada")
public class CarrerasCursadas {
    public CarrerasCursadas(CarrerasCursadasPk id,boolean graduado, int antiguedad) {
        this.id = id;
        Graduado = graduado;
        Antiguedad = antiguedad;
    }

    @EmbeddedId
    private CarrerasCursadasPk id;


   @ManyToOne
   @MapsId("idCarrera")
   @JoinColumn(name = "carrera_id", referencedColumnName = "idCarrera", nullable = false)
    private Carrera carreraCursada;
   @ManyToOne
   @MapsId("idEstudiante")
   @JoinColumn(name = "idEstudiante")
   private Estudiante estudianteEnCarrera;

    private boolean Graduado;
    private int Antiguedad;

    public CarrerasCursadas() {

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
