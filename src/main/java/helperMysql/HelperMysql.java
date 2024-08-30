package helperMysql;

import entities.Cliente;
import entities.Producto;
import entities.Factura;
import entities.Factura_Producto;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelperMysql {
    private Connection conn ;

    public HelperMysql() {//Constructor
        String driver = "com.mysql.cj.jdbc.Driver";
        String uri = "jdbc:mysql://localhost:3306/BdIntegrador";

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                 | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            System.err.println("error en el primer catch");
            System.exit(1);
        }
        try {
           this.conn = DriverManager.getConnection(uri, "IntegradorUser", "password");
           System.out.println();
            conn.setAutoCommit(false);
        } catch (Exception e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void createTables() throws SQLException {
        System.out.println(this.conn);

        // Crear la tabla Cliente
        String tableCliente = "CREATE TABLE IF NOT EXISTS Cliente (" +
                "idCliente INT NOT NULL, " +
                "Nombre VARCHAR(500), " +
                "Email VARCHAR(500), " +
                "PRIMARY KEY (idCliente));";
        this.conn.prepareStatement(tableCliente).execute();
        this.conn.commit();

        // Crear la tabla Producto
        String tableProducto = "CREATE TABLE IF NOT EXISTS Producto (" +
                "idProducto INT NOT NULL, " +
                "nombre VARCHAR(500), " +
                "edad INT NOT NULL, " +
                "valor FLOAT NOT NULL, " +
                "PRIMARY KEY (idProducto));";
        this.conn.prepareStatement(tableProducto).execute();
        this.conn.commit();

        // Crear la tabla Factura
        String tableFactura = "CREATE TABLE IF NOT EXISTS Factura (" +
                "idFactura INT NOT NULL, " +
                "idCliente INT NOT NULL, " +
                "PRIMARY KEY (idFactura), " +
                "FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente));";
        this.conn.prepareStatement(tableFactura).execute();
        this.conn.commit();

        // Crear la tabla Factura_Producto
        String tableFactura_Producto = "CREATE TABLE IF NOT EXISTS Factura_Producto (" +
                "idFactura INT NOT NULL, " +
                "idProducto INT NOT NULL, " +
                "cantidad INT, " +
                "PRIMARY KEY (idFactura, idProducto), " +
                "FOREIGN KEY (idFactura) REFERENCES Factura(idFactura), " +
                "FOREIGN KEY (idProducto) REFERENCES Producto(idProducto));";
        this.conn.prepareStatement(tableFactura_Producto).execute();
        this.conn.commit();
    }

    private Iterable<CSVRecord> getData(String archivo) throws IOException {
        String path = "src\\main\\resources\\" + archivo;
        Reader in = new FileReader(path);
        String[] header = {};  // Puedes configurar tu encabezado personalizado aquí si es necesario
        CSVParser csvParser = CSVFormat.EXCEL.withHeader(header).parse(in);

        Iterable<CSVRecord> records = csvParser.getRecords();
        return records;
    }

    public void insertData() throws Exception {
        this.InsertClientData(this.getData("clientes.csv"));
        this.InsertProductData(this.getData("productos.csv"));
        this.InsertFacturaData(this.getData("facturas.csv"));


       // InsertProduct_FacturaData(this.getData("facturas-productos.csv"));

    }


  //inserta los datos del cliente desde el csv
    public void InsertClientData (Iterable<CSVRecord> data) throws Exception{
        for (CSVRecord row : data) {
            if (row.size() <= 3) { // Verificar que hay al menos 4 campos en el CSVRecord
                String idCliente = row.get(0);
                String nombre = row.get(1);
                String email = row.get(2);


                if (!idCliente.isEmpty() && !nombre.isEmpty() && !email.isEmpty()) {
                    try {
                        int id = Integer.parseInt(idCliente);
                        Cliente cliente = new Cliente(id, row.get(1), row.get(2));
                       insertCliente(cliente, this.conn);
                    } catch (NumberFormatException e) {
                        System.err.println("Error de formato en datos de Cliente: " + e.getMessage());
                    }
                }
            }
        }
    }
    //inserta los datos del producto desde el csv
    public void InsertProductData(Iterable<CSVRecord> data) throws Exception{
        for (CSVRecord row : data) {
            if (row.size() <= 3) {

                String idProducto = row.get(0);
                String nombre = row.get(1);
                String valor = row.get(2);
                System.out.println(idProducto);
                if(!idProducto.isEmpty() && !nombre.isEmpty() && valor.isEmpty()){
                    try {
                        int id = Integer.parseInt(idProducto);
                        int valorProducto = Integer.parseInt(valor);
                        Producto producto = new Producto(id,nombre,valorProducto);
                        insertProducto(producto,this.conn);
                    } catch (NumberFormatException  e) {
                        System.err.println("Error de formato en datos del producto: " + e.getMessage());
                    }
                }

            }
        }
    }
// inserta los datos de la factura desde el csv
public void InsertFacturaData(Iterable<CSVRecord> data) throws Exception{
    for (CSVRecord row : data) {
        if (row.size() <= 2) {
            String idFactura = row.get(0);
            String idCliente = row.get(1);
            if(!idFactura.isEmpty() && idCliente.isEmpty()){
                try {
                    int id = Integer.parseInt(idCliente);
                    int idClient = Integer.parseInt(idCliente);
                    Factura f = new Factura(id, idClient);
                    insertFactura(f, this.conn);
                }catch (NumberFormatException  e) {
                    System.err.println("Error de formato en datos de la factura : " + e.getMessage());
                }
            }
        }
    }
}
// inserta los datos de producto-factura desde el csv
public void InsertProduct_FacturaData(Iterable<CSVRecord> data) throws Exception{
    for (CSVRecord row : data) {
        String idFactura = row.get(0);
        String idProducto = row.get(1);
        String cantidad = row.get(2);
        if(!idProducto.isEmpty() &&!idFactura.isEmpty() && ! cantidad.isEmpty()){
            try {
            int IdF= Integer.parseInt(idFactura);
            int id = Integer.parseInt(idProducto);
            int cant = Integer.parseInt(cantidad);
            Factura_Producto facturaProducto = new Factura_Producto(IdF,id,cant);
            insertFactura_Producto(facturaProducto,this.conn);
            }catch (NumberFormatException  e) {
                System.err.println("Error de formato en  los datos : " + e.getMessage());
            }

        }

    }
}

    // inserta un cliente en la base de datos
    public int insertCliente (Cliente cliente, Connection conn) throws Exception {
        String insert = "INSERT INTO Cliente (idCliente, nombre, email) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(insert);
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getEmail());
            if (ps.executeUpdate() == 0) {
                throw new Exception("No se pudo insertar");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            closePsAndCommit(conn, ps);
            System.out.println("insertado");
        }
        return 0;
    }


    // inserta un producto en la base de datos
    public int insertProducto (Producto producto, Connection conn) throws Exception {
        String insert = "INSERT INTO Producto (idProducto, nombre, valor) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(insert);
            ps.setInt(1, producto.getIdProducto());
            ps.setString(2, producto.getNombre());
            ps.setFloat(3, producto.getValor());
            if (ps.executeUpdate() == 0) {
                throw new Exception("No se pudo insertar");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePsAndCommit(conn, ps);
        }
        return 0;
    }



    // inserta una factura en la base de datos
    public int insertFactura (Factura factura, Connection conn) throws Exception {
        String insert = "INSERT INTO Factura (idFactura, idCliente) VALUES (?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(insert);
            ps.setInt(1, factura.getIdFactura());
            ps.setInt(2, factura.getIdCliente());
            if (ps.executeUpdate() == 0) {
                throw new Exception("No se pudo insertar");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePsAndCommit(conn, ps);
        }
        return 0;
    }


    // inserta una factura_producto en la base de datos
    public int insertFactura_Producto (Factura_Producto fp, Connection conn) throws Exception {
        String insert = "INSERT INTO Factura_Producto (idFactura, idProducto, cantidad) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(insert);
            ps.setInt(1, fp.getIdFactura());
            ps.setInt(2, fp.getIdProducto());
            ps.setInt(3, fp.getCantidad());
            if (ps.executeUpdate() == 0) {
                throw new Exception("No se pudo insertar");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePsAndCommit(conn, ps);
        }
        return 0;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void closePsAndCommit(Connection conn, PreparedStatement ps) {
        if (conn != null){
            try {
                ps.close();
                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void dropTables() throws SQLException {
        // Borrar la tabla Factura_Producto
        String dropFactura_Producto = "DROP TABLE IF EXISTS Factura_Producto;";
        this.conn.prepareStatement(dropFactura_Producto).execute();
        this.conn.commit();

        // Borrar la tabla Factura
        String dropFactura = "DROP TABLE IF EXISTS Factura;";
        this.conn.prepareStatement(dropFactura).execute();
        this.conn.commit();

        // Borrar la tabla Producto
        String dropProducto = "DROP TABLE IF EXISTS Producto;";
        this.conn.prepareStatement(dropProducto).execute();
        this.conn.commit();

        // Borrar la tabla Cliente
        String dropCliente = "DROP TABLE IF EXISTS Cliente;";
        this.conn.prepareStatement(dropCliente).execute();
        this.conn.commit();
    }


}
