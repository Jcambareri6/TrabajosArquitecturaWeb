package org.example;

import helperMysql.HelperMysql;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        HelperMysql helper = new HelperMysql();
        helper.dropTables();
        helper.createTables();
        helper.insertData();
        helper.closeConnection();
    }
}