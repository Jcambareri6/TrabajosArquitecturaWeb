package Dto;

public class CarreraReporteDto{
    private int idCarrera;
    private String nombre;
    private int Anios;
    private int incriptos;
    private int egresados;

    public CarreraReporteDto(int idCarrera, String nombre, int anios, int incriptos, int egresados) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.Anios = anios;
        this.incriptos = incriptos;
        this.egresados = egresados;
    }
}
