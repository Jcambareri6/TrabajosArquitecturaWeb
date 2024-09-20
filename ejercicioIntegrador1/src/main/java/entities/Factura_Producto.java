package entities;

public class Factura_Producto {

    private Factura idFactura;
    private Producto idProducto;
    private int cantidad;

    public Factura_Producto(Factura idFactura, Producto idProducto, int cantidad) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }


    public int getIdFactura() {
        return idFactura != null ? idFactura.getIdFactura() : 0;
    }

    public int getIdProducto() {
        return idProducto != null ? idProducto.getIdProducto() : 0;
    }


    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }



    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Factura_Producto{" +
                "idFactura=" + idFactura +
                ", idProducto=" + idProducto +
                ", cantidad=" + cantidad +
                '}';
    }
}
