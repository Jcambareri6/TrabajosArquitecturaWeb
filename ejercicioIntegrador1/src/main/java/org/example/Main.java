package org.example;

import dao.ClienteDAO;
import dao.ProductoDAO;
import dto.ClienteDTO;
import dto.ProductoDTO;
import entities.Producto;
import helperMysql.HelperMysql;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        HelperMysql helper = new HelperMysql();
        helper.dropTables();
        helper.createTables();
        helper.insertData();

        ProductoDAO P = new ProductoDAO(helper.getConn());

        //Ejercicio3
        ProductoDTO productoMasRecaudado = P.obtenerProductoMasRecaudado();
        System.out.println(productoMasRecaudado.toString());

        //Ejercicio4
        ClienteDAO c = new ClienteDAO(helper.getConn());
        List<ClienteDTO> Clientes = c.obtenerClientesFacturado();
        for (ClienteDTO cl : Clientes) {
            System.out.println(cl.toString());
        }
        helper.closeConnection();
    }


}