
package manejador;

/**
 *
 * @author santoslopeztzoy
 */
import bean.Carreras;
import db.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ManejadorDeCarreras {
    private static ManejadorDeCarreras instancia;
    private ArrayList<Carreras> mostrarCarreras;
    
    public static ManejadorDeCarreras getInstancia(){
        if(instancia==null){
            instancia=new ManejadorDeCarreras();
        }
        return instancia;
    }
    
    public ManejadorDeCarreras(){
        mostrarCarreras = new ArrayList<Carreras>();
    }
    
    public ArrayList<Carreras> listarCarreras(){
        return mostrarCarreras;
    }
    
    public ArrayList<Carreras> listarCarrerasGuardadas(){
        Carreras carreras = null;
        mostrarCarreras.removeAll(mostrarCarreras);
       
        String queryCarreras = "CALL listarCarrerasPorFacultad()";
        
        Object[] params = {};
        ResultSet consulta = Conexion.getInstancia().hacerConsulta(queryCarreras, params);
        
        try{
            while(consulta.next()){
                carreras = new Carreras(
                        Integer.parseInt(consulta.getString("c.idCarrera")),
                        consulta.getString("c.nombre"),
                        consulta.getString("f.nombre")
                );
                mostrarCarreras.add(carreras);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return mostrarCarreras;
    }
    
}
