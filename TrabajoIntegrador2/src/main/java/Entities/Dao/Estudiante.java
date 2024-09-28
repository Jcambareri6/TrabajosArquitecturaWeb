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

    private int libretaUniversitaria;

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

    @OneToMany(mappedBy = "estudianteEnCarrera")
    private List<CarrerasCursadas> carrera;

    // Default constructor
    public Estudiante() {

    }



    // Parametrized constructor

    public Estudiante(int libretaUniversitaria, String nombre, String apellido, int edad, String genero, String ciudadResidencia) {
        this.libretaUniversitaria = libretaUniversitaria;
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
        Genero = genero;
        CiudadResidencia = ciudadResidencia;
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

    public int getLibretaUniversitaria() {
        return libretaUniversitaria;
    }

    public void setLibretaUniversitaria(int libretaUniversitaria) {
        this.libretaUniversitaria = libretaUniversitaria;
    }

    public List<CarrerasCursadas> getCarreras() {
        return carrera;
    }

    public void setCarreras(List<CarrerasCursadas> Carreras) {
        this.carrera = Carreras;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "libretaUniversitaria=" + libretaUniversitaria +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Edad=" + Edad +
                ", Genero='" + Genero + '\'' +
                ", CiudadResidencia='" + CiudadResidencia + '\'' +
                '}';
    }
}
