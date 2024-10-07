package Dto;

public class CarreraReporteDto{
    private int idCarrera;
    private String nombre;
    private int añoInscripcion;
    private int incriptos;
    private int egresados;

    public CarreraReporteDto(int idCarrera, String nombre, int anios, int incriptos, int egresados) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.añoInscripcion = anios;
        this.incriptos = incriptos;
        this.egresados = egresados;
    }

    @Override
    public String toString() {
        return "CarreraReporteDto{" +
                "idCarrera=" + idCarrera +
                ", nombre='" + nombre + '\'' +
                ", AñoDeInscripcion=" + añoInscripcion +
                ", incriptos=" + incriptos +
                ", egresados=" + egresados +
                '}';
    }
}
