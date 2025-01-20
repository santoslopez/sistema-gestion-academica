
package modelo;

import bean.Carreras;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import manejador.ManejadorDeCarreras;

/**
 *
 * @author santoslopeztzoy
 */
public class ModeloDeCarreras extends AbstractTableModel {
    private static ModeloDeCarreras instancia;
    
    private ArrayList<Carreras> listadoDeCarreras = null;
    
    private static ModeloDeCarreras getInstancia(){
        if(instancia==null){
            instancia=new ModeloDeCarreras();
        }
        return instancia;
    }
    
    public ModeloDeCarreras(){
        listadoDeCarreras=new ManejadorDeCarreras().getInstancia().listarCarrerasGuardadas();
    }
    
    private String[] encabezado = {"ID","Nombre","Facultad"};
    
    public String getColumnName(int column){
        return encabezado[column];
    }
    
    public int getColumnCount(){
        return encabezado.length;
    }
    
    public int getRowCount(){
        return listadoDeCarreras.size();
    }
    
    public Object getValueAt(int row, int column){
        String resultado = null;
        Carreras carreras = listadoDeCarreras.get(row);
        
        switch(column){
            
            case 0:
                resultado = String.valueOf(carreras.getIdCarrera());
            break;
            
            case 1:
                resultado = String.valueOf(carreras.getNombre());
            break;
            
            case 2:
                resultado = String.valueOf(carreras.getNombreFacultad());
            break;
        }
        
        return resultado;
    }
}
