package db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Conexion {
    private static Conexion instancia;

    public static synchronized Conexion getInstancia(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }

    private Connection conection;
    private Statement statement;
    private String urlDriver="com.mysql.cj.jdbc.Driver";
    
    public Conexion(){
        try {
            // Cargar el driver de SQL Server
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
           
            Class.forName(urlDriver).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC: " + e.getMessage());
        }

        try {
            // Definir la URL de la base de datos (puede ser en Azure o local)
            /*String url = "jdbc:sqlserver://localhost:1433;databaseName=SistemaEducativo;
            
            user=SA;password=pbd.2024;encrypt=true;trustServerCertificate=false;";*/
            
            String url = "jdbc:mysql://localhost:3306/sistemaeducativo?serverTimezone=UTC";
            String user = "root";
            String password = "thecrimson";
            
            
            // Intentar establecer la conexión
            conection = DriverManager.getConnection(url,user,password);

            if (conection != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            } else {
                //System.out.println("Fallo la conexión a la base de datos.");
                JOptionPane.showMessageDialog(null, "Error capturado "+conection, "Mensaje", JOptionPane.ERROR_MESSAGE);

            }
            statement = conection.createStatement();

        } catch (SQLException e) {
            //System.out.println("Error en la conexión: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error capturado "+e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    /*
    Realizar consultas: SELECT y evitar inyección SQL
    */
    public ResultSet hacerConsulta(String consulta, Object[] params){
        ResultSet resultSet = null;
        try{
            PreparedStatement p = conection.prepareStatement(consulta);
            for(int i=0;i<params.length;i++){
                p.setObject(i+1, params[i]);
            }
            resultSet = p.executeQuery();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error capturado "+ex.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
            //ex.getStackTrace();
        }
        return resultSet;
        
    }
    // Actualmente no se utiliza debido a que se crearon procedimientos almacenados para realizar insert, update y delete
    /*public ResultSet ejecutarSentencia(String consulta,Object[] params){
        ResultSet resultSet = null;
        try{
            PreparedStatement prep = conection.prepareStatement(consulta);
            for(int i=0;i<params.length;i++){
                prep.setObject(i+1,params[i]);
            }
            prep.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return resultSet;
    }*/
}
