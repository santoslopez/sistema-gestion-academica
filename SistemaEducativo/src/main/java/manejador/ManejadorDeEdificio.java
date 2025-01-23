
package manejador;

/**
 *
 * @author santoslopeztzoy
 */

import bean.Edificio;
import java.util.ArrayList;
import db.Conexion;
import java.sql.ResultSet;


public class ManejadorDeEdificio {
    private static ManejadorDeEdificio instancia;
    private ArrayList<Edificio> mostrarEdificios;
    
    public static ManejadorDeEdificio getInstancia(){
        if(instancia==null){
            instancia=new ManejadorDeEdificio();
        }
        return instancia;
    }
    
    public ManejadorDeEdificio(){
        mostrarEdificios = new ArrayList<Edificio>();
    }
    
    public ArrayList<Edificio> listarEdificios(){
        return mostrarEdificios;
    }
    
    
    public ArrayList<Edificio> listarEdificiosGuardados(){
        Edificio edif = null;
        
        mostrarEdificios.removeAll(mostrarEdificios);
        
        String consulta = "SELECT * FROM Edificio";
        
        Object[] params = {};
        
        ResultSet resultSet = Conexion.getInstancia().hacerConsulta(consulta, params);
        
        try{
            while(resultSet.next()){
                edif = new Edificio(
                Integer.parseInt(resultSet.getString("idEdificio")),
                resultSet.getString("nombreEdificio"));
                
                mostrarEdificios.add(edif);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
        
        return mostrarEdificios;
    }
    
}
