package dao;

import entities.Factura;
import  entities.Factura_Producto;
import entities.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Factura_ProductoDAO {
    private Connection conn;

    public Factura_ProductoDAO(Connection conn) {
        this.conn = conn;
    }
    public void insertFactura_Producto(Factura_Producto facturaProducto) {
        String query = "INSERT INTO Factura_Producto (idFactura, idProducto, cantidad) VALUES (?, ?, ?)";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, facturaProducto.getIdFactura());
            ps.setInt(2, facturaProducto.getIdProducto());
            ps.setInt(3, facturaProducto.getCantidad());
            ps.executeUpdate();
            System.out.println("Factura_Producto insertada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    public Factura_Producto find(Factura pk, Producto pk2) {
        String query = "SELECT fp.cantidad" +
                "FROM Factura_Producto fp " +
                "WHERE fp.idFactura = ? &&" +
                "fp.idProducto = ?";

        Factura_Producto fpById = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, pk2.getIdProducto());
            rs = ps.executeQuery();
            if (rs.next()) {
                int cantidad = rs.getInt("cantidad");
                fpById = new Factura_Producto(pk, pk2, cantidad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return fpById;
    }


}