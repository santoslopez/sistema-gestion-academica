
package manejador;

import bean.Facultad;
import db.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author santoslopeztzoy
 */
public class ManejadorDeFacultad {
    private static ManejadorDeFacultad instancia;
    private ArrayList<Facultad> mostrarFacultad;
    
    public static ManejadorDeFacultad getInstancia(){
        if(instancia==null){
            instancia=new ManejadorDeFacultad();
        }
        return instancia;
    }
    
    // constructor
    public ManejadorDeFacultad(){
        mostrarFacultad = new ArrayList<Facultad>();
    }
    
    public ArrayList<Facultad> listarFacultad(){
        return mostrarFacultad;
    }
    
    public ArrayList<Facultad> listarFacultadesGuardados(){
        Facultad facultad = null;
        mostrarFacultad.removeAll(mostrarFacultad);
        
        String queryFacultad = "CALL listarFacultades()";
        Object[] params ={};
        ResultSet consulta = Conexion.getInstancia().hacerConsulta(queryFacultad, params);
        
        try{
            while(consulta.next()){
                facultad = new Facultad(
                Integer.parseInt(consulta.getString("idFacultad")),
                        consulta.getString("nombre")
                );
                mostrarFacultad.add(facultad);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return mostrarFacultad;
    }
    
    
    
}
