package bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Consultas {
    private Connection connection;
    private String urlBD = "jdbc:mysql://localhost:3306/demoqa";
    private String userBD = "root";
    private String passBD = "";
    public Map<String,String> getDatosPersona(){
        ConexionBD conexionBD = new ConexionBD(urlBD,userBD,passBD);
        Map<String,String> datos = new HashMap<String, String>();
        try {
            connection = conexionBD.connect();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM persona");
            System.out.println("CONSULTA REALIZADA");
            if (rs.next()){
                datos.put("nombre",rs.getString(1));
                datos.put("apellido",rs.getString(2));
                datos.put("email",rs.getString(3));
                datos.put("genero",rs.getString(4));
                datos.put("numero",rs.getString(5));
                datos.put("fechaNacimiento",rs.getString(6));
                datos.put("direccion",rs.getString(7));
                datos.put("estado",rs.getString(8));
                datos.put("ciudad",rs.getString(9));
            }


            statement.close();
            connection.close();
            return datos;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return datos;
        }
    }
    public void crearUsuario(String user,String pass){

        ConexionBD conexionBD = new ConexionBD(urlBD,userBD,passBD);
        Map<String,String> datos = new HashMap<String, String>();
        try {
            connection = conexionBD.connect();
            Statement statement = connection.createStatement();
            statement.executeQuery("INSERT INTO `login` (`usuario`, `password`) VALUES ('"+user+"', '"+pass+"')");
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public Map<String,String > obtenerCredencialesDB(){
        ConexionBD conexionBD = new ConexionBD(urlBD,userBD,passBD);
        Map<String,String> datos = new HashMap<String, String>();
        try {
            connection = conexionBD.connect();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM login");
            System.out.println("CONSULTA REALIZADA");
            if (rs.next()){
                datos.put("user",rs.getString(1));
                datos.put("pass",rs.getString(2));
            }


            statement.close();
            connection.close();
            return datos;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return datos;
        }
    }
    public List<String> obtenerISBN(){
        ConexionBD conexionBD = new ConexionBD(urlBD,userBD,passBD);
        List<String> isbn = new ArrayList<>();
        try {
            connection = conexionBD.connect();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM libro");
            System.out.println("CONSULTA REALIZADA");
            while (rs.next()){
                isbn.add(rs.getString(1));
            }


            statement.close();
            connection.close();
            return isbn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return isbn;
        }
    }
}
