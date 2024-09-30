package Entities.Dao;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CarreraCursada")
public class CarrerasCursadas {

    @EmbeddedId
    private CarrerasCursadasPk id;


   @ManyToOne(cascade = CascadeType.REFRESH )
   @MapsId("idCarrera")
   @JoinColumn(name="idCarrera")
   private Carrera carreraCursada;

   @ManyToOne(cascade = CascadeType.REFRESH )
   @MapsId("idEstudiante")
   @JoinColumn(name="idEstudiante")
   private Estudiante estudianteEnCarrera;

   private boolean Graduado;
   private Date Fecha_inscripcion;
   private Date Fecha_graduacion;




    public CarrerasCursadas( Estudiante es, Carrera c, Date fecha_graduacion) {

        this.id=new CarrerasCursadasPk(c.getIdCarrera(),es.getLibretaUniversitaria());
//        this.estudianteEnCarrera=es;
//        this.carreraCursada=c;
        Fecha_inscripcion =  new Date();
        Fecha_graduacion = fecha_graduacion;
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

    public Carrera getCarreraCursada() {
        return carreraCursada;
    }

    public void setCarreraCursada(Carrera carreraCursada) {
        this.carreraCursada = carreraCursada;
    }

    public Estudiante getEstudianteEnCarrera() {
        return estudianteEnCarrera;
    }

    public void setEstudianteEnCarrera(Estudiante estudianteEnCarrera) {
        this.estudianteEnCarrera = estudianteEnCarrera;
    }

    @Override
    public String toString() {
        return "CarrerasCursadas{" +
                "id=" + id +
                ", carreraCursada=" + carreraCursada +
                ", estudianteEnCarrera=" + estudianteEnCarrera +
                ", Graduado=" + Graduado +
                ", Fecha_inscripcion=" + Fecha_inscripcion +
                ", Fecha_graduacion=" + Fecha_graduacion +
                '}';
    }
}
