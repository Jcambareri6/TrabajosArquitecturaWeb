package dto;


public class ClienteDTO {
    private int idCliente;
    private String nombre;
    private float totalFacturado;

    // Constructor, getters y setters
    public ClienteDTO(int idCliente, String nombre, float totalFacturado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.totalFacturado = totalFacturado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public float getTotalFacturado() {
        return totalFacturado;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", totalFacturado=" + totalFacturado +
                '}';
    }
}