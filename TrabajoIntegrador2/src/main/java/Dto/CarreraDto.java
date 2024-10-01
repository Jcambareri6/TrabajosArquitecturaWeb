package Dto;

public class CarreraDto {

    private int idCarrera;
    private String nombre;
    private int Anios;

    public CarreraDto(int idCarrera, String nombre, int anios) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        Anios = anios;
    }

    public int getIdCarrera() {
        return idCarrera;
    }
    public String getNombre() {
        return nombre;
    }
    public int getAnios() {
        return Anios;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "CarreraDto{" +
                "idCarrera=" + idCarrera +
                ", nombre='" + nombre + '\'' +
                ", Anios=" + Anios +
                '}';
    }
}
