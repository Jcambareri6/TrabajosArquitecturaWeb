package Entities.Dao;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Carrera {

    @Id
    private int idCarrera;

    @Column
    private String nombre;

    @Column
    private int Anios;

    @OneToMany(mappedBy = "carreraCursada",fetch = FetchType.LAZY)
    private List<Inscripcion> estudiante;

    public Carrera(int idCarrera, String nombre, int anios) {
        this.idCarrera = idCarrera;
        nombre = nombre;
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
        return nombre;
    }

    public void setNombre(String nombre) {nombre = nombre;
    }

    public int getAnios() {
        return Anios;
    }

    public void setAnios(int anios) {
        Anios = anios;
    }
    public  int GetCantInscriptos(){
        return this.estudiante.size();
    }
}
