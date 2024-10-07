package Dto;

import Entities.Dao.Carrera;

import java.util.List;

public class CarrerasCursadasDto {
    private String NombreCarrera;
    private int Año_Fecha_inscripcionEstudiante;
    private int Count_Fecha_inscripcionEstudiante;
    private int Count_Fecha_graduacionEstudiante;


    public CarrerasCursadasDto(String nombreCarrera, int año_Fecha_inscripcionEstudiante, int count_Fecha_inscripcionEstudiante, int count_Fecha_graduacionEstudiante) {
        this.NombreCarrera = nombreCarrera;
        this.Año_Fecha_inscripcionEstudiante = año_Fecha_inscripcionEstudiante;
        this.Count_Fecha_inscripcionEstudiante = count_Fecha_inscripcionEstudiante;
        this.Count_Fecha_graduacionEstudiante = count_Fecha_graduacionEstudiante;
    }

    public String getNombreCarrera() {
        return NombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        NombreCarrera = nombreCarrera;
    }

    public int getAño_Fecha_inscripcionEstudiante() {
        return Año_Fecha_inscripcionEstudiante;
    }

    public void setAño_Fecha_inscripcionEstudiante(int año_Fecha_inscripcionEstudiante) {
        Año_Fecha_inscripcionEstudiante = año_Fecha_inscripcionEstudiante;
    }

    public int getCount_Fecha_graduacionEstudiante() {
        return Count_Fecha_graduacionEstudiante;
    }

    public void setCount_Fecha_graduacionEstudiante(int count_Fecha_graduacionEstudiante) {
        Count_Fecha_graduacionEstudiante = count_Fecha_graduacionEstudiante;
    }

    public int getCount_Fecha_inscripcionEstudiante() {
        return Count_Fecha_inscripcionEstudiante;
    }

    public void setCount_Fecha_inscripcionEstudiante(int count_Fecha_inscripcionEstudiante) {
        Count_Fecha_inscripcionEstudiante = count_Fecha_inscripcionEstudiante;
    }

    @Override
    public String toString() {
        return "CarrerasCursadasDto{" +
                ", NombreCarrera='" + NombreCarrera + '\'' +
                ", Año_Fecha_inscripcionEstudiante=" + Año_Fecha_inscripcionEstudiante +
                ", Count_Fecha_inscripcionEstudiante=" + Count_Fecha_inscripcionEstudiante +
                ", Count_Fecha_graduacionEstudiante=" + Count_Fecha_graduacionEstudiante +
                '}';
    }
}


