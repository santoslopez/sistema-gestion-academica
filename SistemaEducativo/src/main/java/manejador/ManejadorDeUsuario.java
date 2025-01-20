
package manejador;

/**
 *
 * @author santoslopeztzoy
 */

import db.Conexion;
import bean.Usuario;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ManejadorDeUsuario {
    private static ManejadorDeUsuario instancia;
    private ArrayList<Usuario> mostrarUsuario;
    
    public static ManejadorDeUsuario getInstancia(){
        if(instancia==null){
            instancia=new ManejadorDeUsuario();
        }
        return instancia;
    }
    
    // Constructor
    public ManejadorDeUsuario(){
        mostrarUsuario = new ArrayList<Usuario>();
    }
    
    public ArrayList<Usuario> listarUsuarios(){
        return mostrarUsuario;
    }
    
    
    public ArrayList<Usuario> listarUsuariosGuardados(){
        Usuario usuario = null;
        mostrarUsuario.removeAll(mostrarUsuario);
        
        String queryUsuarios = "CALL listarUsuarios(2)";
        
        Object[] params={};
        ResultSet consulta = Conexion.getInstancia().hacerConsulta(queryUsuarios,params);
        
        try{
            while(consulta.next()){
                Date fechaNacimiento = consulta.getDate("fechaNacimiento");
                Date fechaRegistro = consulta.getDate("fechaRegistro");
                usuario = new Usuario(
                        Integer.parseInt(consulta.getString("idUsuario")),
                        consulta.getString("nombres"),
                        consulta.getString("apellidos"),
                        fechaNacimiento,
                        consulta.getString("correo"),
                        consulta.getString("username"),
                        consulta.getString("contrasena"),
                        fechaRegistro,
                        consulta.getString("carnet"),
                        consulta.getString("foto"),
                        consulta.getString("estado"),
                        Integer.parseInt(consulta.getString("idTipoUsuario"))
                );
                mostrarUsuario.add(usuario);
                
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        return mostrarUsuario;
    }
    
    public Usuario iniciarSesion(String user,String password,int idTipoUsuario){
        Usuario usuario = null;
        
        String query = "SELECT * FROM Usuario WHERE username=? AND contrasena=? AND idTipoUsuario=?";
        Object[] params = {user,password,idTipoUsuario};
        
        ResultSet consulta=Conexion.getInstancia().hacerConsulta(query,params);
        
        if(consulta!=null){
            try{
                while(consulta.next()){
                    usuario = new Usuario(
                            consulta.getString("correo"),
                            consulta.getString("username"),
                            consulta.getString("contrasena"),
                            consulta.getString("estado"),
                            Integer.parseInt(consulta.getString("idTipoUsuario"))
                    );
                    
                }                
            }catch(SQLException exc){
                exc.printStackTrace();
            }

        }else{
            usuario=null;
        }
        
        return usuario;
        
    }
    
}
