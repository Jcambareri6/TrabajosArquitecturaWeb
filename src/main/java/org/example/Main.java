package org.example;

import dao.ProductoDAO;
import entities.Producto;
import helperMysql.HelperMysql;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        HelperMysql helper = new HelperMysql();
         helper.dropTables();
      helper.createTables();
         helper.insertData();
        //ProductoDAO  p =  new ProductoDAO(helper.)
      helper.closeConnection();
    }


}