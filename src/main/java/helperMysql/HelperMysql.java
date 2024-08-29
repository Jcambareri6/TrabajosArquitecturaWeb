package helperMysql;

import entities.Cliente;
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

        //  CLIENTES
        for (CSVRecord row : getData("clientes.csv")) {


            if (row.size() <= 3) { // Verificar que hay al menos 4 campos en el CSVRecord
                String idCliente = row.get(0);
                String nombre = row.get(1);
                String email = row.get(2);


                if (!idCliente.isEmpty() && !nombre.isEmpty() && !email.isEmpty()) {
                    try {
                        int id = Integer.parseInt(idCliente);
                        Cliente cliente = new Cliente(id, row.get(1), row.get(2));
                        insertCliente(cliente, conn);
                    } catch (NumberFormatException e) {
                        System.err.println("Error de formato en datos de dirección: " + e.getMessage());
                    }
                } else {
                    System.out.println("estoy en el else");
                }
            }
        }
        System.out.println("Direcciones insertadas");




    }
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

}
