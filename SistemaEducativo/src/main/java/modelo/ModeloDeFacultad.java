
package modelo;

import bean.Facultad;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import manejador.ManejadorDeFacultad;

/**
 *
 * @author santoslopeztzoy
 */
public class ModeloDeFacultad extends AbstractTableModel {
    private static ModeloDeFacultad instancia;
    private ArrayList<Facultad> listadoDeFacultad = null;
    private static ModeloDeFacultad getInstancia(){
        if(instancia==null){
            instancia=new ModeloDeFacultad();
        }
        return instancia;
    }
    
    public ModeloDeFacultad(){
        listadoDeFacultad = new ManejadorDeFacultad().getInstancia().listarFacultadesGuardados();
    }
    
    
    private String[] encabezado = {"ID","Facultad"};
    
    public String getColumnName(int column){
        return encabezado[column];
    }
    
    public int getColumnCount(){
        return encabezado.length;
    }
    
    public int getRowCount(){
        return listadoDeFacultad.size();
    }
    
    public Object getValueAt(int row, int column){
        String resultado = null;
        Facultad facultad = listadoDeFacultad.get(row);
        
        switch(column){
            
            case 0:
                resultado = String.valueOf(facultad.getIdFacultad());
            break;
            
            case 1:
                
                resultado = String.valueOf(facultad.getNombre());
            
            break;
            
            
        }
        
        return resultado;
    }
            
    
}
