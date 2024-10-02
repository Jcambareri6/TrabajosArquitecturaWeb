package Dto;

public class CarreraDto {

    private int idCarrera;
    private String nombre;
    private int Anios;
    private int cantidadInscriptos;

    public CarreraDto(int idCarrera, String nombre, int anios,int cantidadInscriptos) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.Anios = anios;
        this.cantidadInscriptos=cantidadInscriptos;
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

    public int getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public void setCantidadInscriptos(int cantidadInscriptos) {
        this.cantidadInscriptos = cantidadInscriptos;
    }

    @Override
    public String toString() {
        return "CarreraDto{" +
                "idCarrera=" + idCarrera +
                ", nombre='" + nombre + '\'' +
                ", Anios=" + Anios +
                ", cantidadInscriptos=" + cantidadInscriptos +
                '}';
    }
}
