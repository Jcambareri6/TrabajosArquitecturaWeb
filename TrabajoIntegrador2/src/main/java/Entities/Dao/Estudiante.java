package Entities.Dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long libretaUniversitaria;

    @Column
    private String Nombre;

    @Column
    private String Apellido;

    @Column
    private int Edad;

    @Column
    private String Genero;

    @Column
    private String CiudadResidencia;

    @OneToMany(mappedBy = "estudiante")
    private List<CarrerasCursadas> Carreras;

    // Default constructor
    public Estudiante() {
        this.Carreras = new ArrayList<>();
    }

    // Parametrized constructor
    public Estudiante(String Nombre, String Apellido, int Edad, String Genero) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.Genero = Genero;
        this.Carreras = new ArrayList<>();
    }

    // Getters and Setters


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getCiudadResidencia() {
        return CiudadResidencia;
    }

    public void setCiudadResidencia(String CiudadResidencia) {
        this.CiudadResidencia = CiudadResidencia;
    }

    public List<CarrerasCursadas> getCarreras() {
        return Carreras;
    }

    public void setCarreras(List<CarrerasCursadas> Carreras) {
        this.Carreras = Carreras;
    }
}
