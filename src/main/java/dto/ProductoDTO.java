package dto;

public class ProductoDTO {
    private int idProducto;
    private String nombre;
    private float totalRecaudado;

    public ProductoDTO(int idProducto, String nombre, float totalRecaudado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.totalRecaudado = totalRecaudado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTotalRecaudado(float totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", totalRecaudado=" + totalRecaudado +
           '}';
}
}