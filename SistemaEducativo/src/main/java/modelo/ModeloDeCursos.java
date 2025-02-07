
package modelo;

/**
 *
 * @author santoslopeztzoy
 */
import bean.Cursos;
import db.Conexion;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import manejador.ManejadorDeCursos;


public class ModeloDeCursos extends AbstractTableModel {
    private ArrayList<Cursos> listadoDeCursos = null;
    
    private static ModeloDeCursos instancia;
    
    public static ModeloDeCursos getInstancia(){
        if(instancia==null){
            instancia=new ModeloDeCursos();
        }
        return instancia;
    }
    
    public ModeloDeCursos(){
        listadoDeCursos=new ManejadorDeCursos().getInstancia().listarCursosGuardados();
                
    }
    
    private String[] encabezado = {"ID","Codigo curso","Nombre cursos"};
    
    public String getColumnName(int column){
        return encabezado[column];
    }
    
    public int getColumnCount(){
        return encabezado.length;
    }
    
    public int getRowCount(){
        return listadoDeCursos.size();
    }
    
    public Object getValueAt(int row,int column){
        String resultado = null;
        
        Cursos cursos = listadoDeCursos.get(row);
        
        switch(column){
            case 0:
                resultado = String.valueOf(cursos.getIdCurso());
            break;
            
            case 1:
                resultado = String.valueOf(cursos.getCodigo());
            break;
            
            case 2:
                resultado = String.valueOf(cursos.getNombre());
            break;
                
        }
        return resultado;
    }
    
    public void actualizarJTable(){
        listadoDeCursos = new ManejadorDeCursos().getInstancia().listarCursosGuardados();
        
        /* notifica al JTable que los datos en el modelo han cambiado, 
        y que debe actualizar su visualización para reflejar esos cambios.*/
        fireTableDataChanged();
    }
}
