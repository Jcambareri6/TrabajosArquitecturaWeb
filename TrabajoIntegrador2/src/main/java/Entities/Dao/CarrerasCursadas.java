package Entities.Dao;

import javax.persistence.*;

@Entity
@Table(name = "CarreraCursada")
public class CarrerasCursadas {

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
   private Date Fecha_inscripcion;
   private Date Fecha_graduacion (nullable=true);

    public CarrerasCursadas(CarrerasCursadasPk id,boolean graduado, int antiguedad) {
        this.id = id;
        Graduado = graduado;
        Antiguedad = antiguedad;
    }
    public CarrerasCursadas() {

    }


    public boolean isGraduado() {
        return Graduado;
    }

    public void setGraduado(boolean graduado) {
        Graduado = graduado;
    }

    public Date getFecha_inscripcion() { return Fecha_inscripcion; }

    public void setFecha_inscripcion(Date fecha_inscripcion) { this.Fecha_inscripcion = fecha_inscripcion; }

    public Date getFecha_graduacion() { return Fecha_graduacion; }

    public void setFecha_graduacion(Date fecha_graduacion) { this.Fecha_graduacion = fecha_graduacion; }



}
