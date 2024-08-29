package factory;

import dao.ClienteDAO;
import  dao.Factura_ProductoDAO;
import dao.FacturaDAO;
import dao.ProductoDAO;

public abstract class AbstractFactory {
    public static final int MYSQL_JDBC = 1;


    public abstract ClienteDAO getClienteDAO();

    public abstract FacturaDAO getFacturaDAO();
    public  abstract  ProductoDAO getProductoDAO();
    public abstract  Factura_ProductoDAO getFactura_ProductoDAO();

    public static AbstractFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MYSQL_JDBC : {
                return MySQLDAOFactory.getInstance();
            }
            default: return null;
        }
    }

}
