package Entities.Dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Carrera {

    @Id
    private int idCarrera;

    @Column
    private String Nombre;

    @Column
    private int Anios;

    @OneToMany(mappedBy = "carreraCursada")
    private List<CarrerasCursadas> estudiante;

    public Carrera(int idCarrera, String nombre, int anios) {
        this.idCarrera = idCarrera;
        Nombre = nombre;
        Anios = anios;
    }

    public Carrera() {

    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getAnios() {
        return Anios;
    }

    public void setAnios(int anios) {
        Anios = anios;
    }
}
