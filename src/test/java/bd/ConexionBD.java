package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConexionBD {
    Connection conn = null;
    private String url;
    private String user;
    private String password;

    public ConexionBD(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.user, this.password);
    }

    public Connection connect() {


        try {
            String dbClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbClass).newInstance();
            this.conn = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conexion exitosa");
            return this.conn;
        } catch (SQLException | ClassNotFoundException var2) {
            System.out.println(var2);
            var2.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException var2) {
            var2.printStackTrace(System.out);
        }

    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException var2) {
            var2.printStackTrace(System.out);
        }

    }

    public static void close(PreparedStatement ps) {
        try {
            ps.close();
        } catch (SQLException var2) {
            var2.printStackTrace(System.out);
        }

    }
}
