public class EstudianteDto{

    private int libretaUniversitaria;
    private String Nombre;
    private String Apellido;
    private int Edad;
    private String Genero;
    private String CiudadResidencia;

    public EstudianteDto(int libretaUniversitaria, String Nombre, String Apellido, int Edad, String Genero, String CiudadResidencia) {
        this.libretaUniversitaria = libretaUniversitaria;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.Genero = Genero;
        this.CiudadResidencia = CiudadResidencia;
    }


    public int getLibretaUniversitaria() {
        return libretaUniversitaria;
    }
    public String getNombre() {
        return Nombre;
    }
    public String getApellido() {
        return Apellido;
    }
    public int getEdad() {
        return Edad;
    }
    public String getGenero() {
        return Genero;
    }
    public String getCiudadResidencia() {
        return CiudadResidencia;
    }



    @java.lang.Override
    public java.lang.String toString() {
        return "EstudianteDto{" +
                "libretaUniversitaria=" + libretaUniversitaria +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Edad=" + Edad +
                ", Genero='" + Genero + '\'' +
                ", CiudadResidencia='" + CiudadResidencia + '\'' +
                '}';
    }

}