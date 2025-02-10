
package modelo;

/**
 *
 * @author santoslopeztzoy
 */

import java.util.ArrayList;
import db.Conexion;
import bean.Edificio;
import javax.swing.table.AbstractTableModel;
import manejador.ManejadorDeEdificio;


public class ModeloDeEdificio extends AbstractTableModel {
    private static ModeloDeEdificio instancia;
    
    private ArrayList<Edificio> listadoDeEdificio = null;
    
    private static ModeloDeEdificio getInstancia(){
        if(instancia==null){
            instancia=new ModeloDeEdificio();
        }
        return instancia;
    }
    
    
    public ModeloDeEdificio(){
        listadoDeEdificio = new ManejadorDeEdificio().getInstancia().listarEdificiosGuardados();
    }
    
    public String[] encabezado = {"ID","Nombre edificio"};
    
    public String getColumnName(int column){
        return encabezado[column];
    }
    
    public int getColumnCount(){
        return encabezado.length;
    }
    
    public int getRowCount(){
        return listadoDeEdificio.size();
    }
    
    public Object getValueAt(int row, int column){
        String resultado = null;
        Edificio edificio = listadoDeEdificio.get(row);
        
        switch(column){
            case 0:
                resultado = String.valueOf(edificio.getIDEdificio());
            break;
            
            case 1:
                resultado = String.valueOf(edificio.getNombreEdificio());
            break;
        }
        
        return resultado;
    }
    
    public void actualizarJTable(){
        listadoDeEdificio = new ManejadorDeEdificio().getInstancia().listarEdificiosGuardados();
        fireTableDataChanged();
    }
}
