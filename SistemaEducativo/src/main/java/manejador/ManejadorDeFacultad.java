
package manejador;

import bean.Facultad;
import db.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author santoslopeztzoy
 */
public class ManejadorDeFacultad {
    private static ManejadorDeFacultad instancia;
    
    
    public static ManejadorDeFacultad getInstancia(){
        if(instancia==null){
            instancia=new ManejadorDeFacultad();
        }
        return instancia;
    }
    
    public Facultad validarExistencia(String nombreFacultad){
        Facultad facultad = null;
        
        String query="SELECT * FROM Facultad WHERE nombre=?";
        
        Object[] params={nombreFacultad};
        
        ResultSet consulta = Conexion.getInstancia().hacerConsulta(query, params);
        
        if(consulta!=null){
            try{
                while(consulta.next()){
                    facultad=new Facultad(
                    consulta.getString("nombre")
                    );
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }else{
            facultad=null;
        }
        
        return facultad;
        
    }
    
}
