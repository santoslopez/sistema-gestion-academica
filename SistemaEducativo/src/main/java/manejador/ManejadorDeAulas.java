
package manejador;

/**
 *
 * @author santoslopeztzoy
 */

import db.Conexion;
import bean.Aulas;
import java.util.ArrayList;

import java.sql.ResultSet;

public class ManejadorDeAulas {
    
    private ArrayList<Aulas> mostrarAulas;
    
    private static ManejadorDeAulas instancia;
    
    public static ManejadorDeAulas getInstancia(){
        if(instancia==null){
            instancia=new ManejadorDeAulas();
        }
        return instancia;
    }
    
    public ManejadorDeAulas(){
        mostrarAulas = new ArrayList<Aulas>();
    }
    
    public ArrayList<Aulas> listarAulas(){
        return mostrarAulas;
    }
    
    public ArrayList<Aulas> listarAulasGuardados(){
        Aulas aulas = null;
        mostrarAulas.removeAll(mostrarAulas);
        
        String query = "CALL listarSalonesDeEdificio()";
        Object[] params={};
        
        ResultSet consulta = Conexion.getInstancia().hacerConsulta(query, params);
        
        
        try{
            while(consulta.next()){
                aulas = new Aulas(
                Integer.parseInt(consulta.getString("a.idAula")),
                        consulta.getString("a.salon"),
                        consulta.getString("e.nombreEdificio"),
                        Integer.parseInt(consulta.getString("a.nivel"))
                        
                );
                mostrarAulas.add(aulas);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return mostrarAulas;
    }
    
}
