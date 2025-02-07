/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author santoslopeztzoy
 */

import java.util.ArrayList;
import db.Conexion;
import bean.Ciclos;
import javax.swing.table.AbstractTableModel;
import manejador.ManejadorDeCiclos;


public class ModeloDeCiclos extends AbstractTableModel {
    
    private ArrayList<Ciclos> listarCiclos = null; 
    
    private static ModeloDeCiclos instancia;
    
    public static ModeloDeCiclos getInstancia(){
        if(instancia==null){
            instancia=new ModeloDeCiclos();
        }
        return instancia;
    }
    
    public ModeloDeCiclos(){
        listarCiclos = ManejadorDeCiclos.getInstancia().listarCiclosGuardados();
    }
    
    public String[] encabezado= {"ID","Descripcion"};
    
    public String getColomnName(int column){
        return encabezado[column];
    }
    
    public int getColumnCount(){
        return encabezado.length;
    }
    
    public int getRowCount(){
        return listarCiclos.size();
    }
    
    public Object getValueAt(int row, int column){
        String resultado = null;
        Ciclos ciclos = listarCiclos.get(row);
        
        switch(column){
            case 0:
                resultado = String.valueOf(ciclos.getIDCiclo());
            break;
            
            case 1:
                resultado = String.valueOf(ciclos.getDescripcion());
            break;
           
        }
        
        return resultado;
        
    }
    
    
    
    public void actualizarJTable(){
        listarCiclos = new ManejadorDeCiclos().getInstancia().listarCiclosGuardados();
        /* notifica al JTable que los datos en el modelo han cambiado, 
        y que debe actualizar su visualización para reflejar esos cambios.*/
        fireTableDataChanged();
        
    }
}
