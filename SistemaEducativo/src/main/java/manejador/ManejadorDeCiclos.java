
package manejador;

/**
 *
 * @author santoslopeztzoy
 * 
 * 
 */
import bean.Ciclos;
import java.util.ArrayList;

import java.sql.ResultSet;
import db.Conexion;


public class ManejadorDeCiclos {
    
    private ArrayList<Ciclos> mostrarCiclos;
    
    private static ManejadorDeCiclos instancia;
    public static ManejadorDeCiclos getInstancia(){
        if(instancia==null){
            instancia=new ManejadorDeCiclos();
        }
        return instancia;
    }
    
    public ManejadorDeCiclos(){
        mostrarCiclos=new ArrayList<Ciclos>();
    }
    
    public ArrayList<Ciclos> listarCiclos(){
        return mostrarCiclos;
    }
    
    public ArrayList<Ciclos> listarCiclosGuardados(){
        Ciclos ciclos = null;
        mostrarCiclos.removeAll(mostrarCiclos);
        
        
        String querySelect = "SELECT * FROM Ciclos";
        
        Object[] params={};
        
        ResultSet consulta = Conexion.getInstancia().hacerConsulta(querySelect, params);
        
        
        try{
                        while(consulta.next()){
                ciclos = new Ciclos(
                        Integer.parseInt(consulta.getString("idCiclo")),
                consulta.getString(("descripcion"))
                );
                mostrarCiclos.add(ciclos);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return mostrarCiclos;
    }
}
