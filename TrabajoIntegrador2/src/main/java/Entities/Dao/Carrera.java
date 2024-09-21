package Entities.Dao;

import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Carrera {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCarrera;

    @Column
    private String NombreCarrera;




    @OneToMany(mappedBy = "carrera")
    private List<Estudiante> estudiantes;

    public Carrera() {
        super();
        this.estudiantes = new ArrayList<Estudiante>();
    }

    public Long getIdCarrera() {
        return this.idCarrera;
    }

    public String getNombre() {
        return this.NombreCarrera;
    }






}