
package manejador;

import bean.Cursos;
import db.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author santoslopeztzoy
 */
public class ManejadorDeCursos {
    private ArrayList<Cursos> mostrarCursos;
    
    private static ManejadorDeCursos instancia;
    public static ManejadorDeCursos getInstancia(){
        if(instancia==null){
            instancia=new ManejadorDeCursos();
        }
        return instancia;
    }
    
    public ManejadorDeCursos(){
        mostrarCursos=new ArrayList<Cursos>();
    }
    
    
    public ArrayList<Cursos> mostrarCursos(){
        return mostrarCursos;
    }
    
    public ArrayList<Cursos> listarCursosGuardados(){
        Cursos cursos = null;
        mostrarCursos.removeAll(mostrarCursos);
        
        String querySelect = "SELECT * FROM Cursos";
        
        Object[] params={};
        
        ResultSet consulta = Conexion.getInstancia().hacerConsulta(querySelect, params);
        
        
        try{
            while(consulta.next()){
                cursos=new Cursos(
                Integer.parseInt(consulta.getString("idCurso")),
                        consulta.getString("codigo"),
                        consulta.getString("nombre")
                );
                mostrarCursos.add(cursos);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return mostrarCursos;
        
    }
    
}
