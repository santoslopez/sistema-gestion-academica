
package modelo;

/**
 *
 * @author santoslopeztzoy
 */
import java.util.ArrayList;
import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import bean.Usuario;
import manejador.ManejadorDeUsuario;


public class ModeloDeUsuario extends AbstractTableModel {
    private ArrayList<Usuario> listadoDeDatos = null;
    private static ModeloDeUsuario instancia;
    public static ModeloDeUsuario getInstancia(){
        if(instancia==null){
            instancia=new ModeloDeUsuario();
        }
        return instancia;
    }
    public ModeloDeUsuario(){
        listadoDeDatos = new ManejadorDeUsuario().getInstancia().listarUsuariosGuardados();
    }
    
    private String[] encabezado = {"Nombres","Apellidos","Fecha nacimiento","Correo","Usuario","Fecha registro","Carnet","Foto","Estado"};
    
    public String getColumnName(int column){
        return encabezado[column];
    }
    public int getColumnCount(){
        return encabezado.length;
    }
    
    // obtener numeros de objetos en la lista
    public int getRowCount(){
        return listadoDeDatos.size();
    }
    
    public Object getValueAt(int row, int column){
        String resultado = null;
        Usuario usuario = listadoDeDatos.get(row);
        
        switch(column){
            case 0:
                resultado = String.valueOf(usuario.getNombres());
            break;
            
            case 1:
                resultado = String.valueOf(usuario.getApellidos());
            break;
            
            case 2:
                resultado = String.valueOf(usuario.getFechaNacimiento());
            break;
            
            case 3:
                resultado = String.valueOf(usuario.getCorreo());
            break;
            
            case 4:
                resultado = String.valueOf(usuario.getUsername());
            break;
            
            case 5:
                resultado = String.valueOf(usuario.getFechaRegistro());
            break;
            
            case 6:
                resultado = String.valueOf(usuario.getCarnet());
            break;
            
            case 7:
                resultado = String.valueOf(usuario.getFoto());
            break;
            
            case 8:
                resultado = String.valueOf(usuario.getEstado());
            break;
        }
        return resultado;
    }
}
