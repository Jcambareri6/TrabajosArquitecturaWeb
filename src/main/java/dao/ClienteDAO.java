package dao;

import entities.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conn;

    public ClienteDAO(Connection conn) {
        this.conn = conn;
    }
    public void insertCliente(Cliente cliente) {
        String query = "INSERT INTO Cliente (idCliente, nombre, email) VALUES (?, ?, ?)";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getEmail());
            ps.executeUpdate();
            System.out.println("Cliente insertada exitosamente.");
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
        String query = "DELETE FROM Cliente WHERE idCliente = ?";
        PreparedStatement ps = null;
        boolean clienteEliminado = false;

        try{
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            int filasEliminadas = ps.executeUpdate();
            clienteEliminado = filasEliminadas > 0;

            if(clienteEliminado){
                System.out.println("Cliente eliminado exitosamente");
            } else {
                System.out.println("No se encontró un cliente con el id proporcionado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(ps != null){
                    ps.close();
                }
                conn.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return clienteEliminado;
    }


    public Cliente find(Integer pk) {
        String query = "SELECT c.nombre, c.email " +
                "FROM Cliente c " +
                "WHERE c.idCliente = ?";

        Cliente clienteById = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, pk);
            rs = ps.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                clienteById = new Cliente(pk, nombre, email);
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

        return clienteById;
    }


    // devuelve una lista de los clientes
    public List<Cliente> selectList() {
        String query = "SELECT idCliente, nombre, email FROM Cliente";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cliente> listaClientes = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()){
                int idCliente = rs.getInt("idCliente");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                Cliente cliente = new Cliente(idCliente, nombre, email);
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
        return listaClientes;
    }

}