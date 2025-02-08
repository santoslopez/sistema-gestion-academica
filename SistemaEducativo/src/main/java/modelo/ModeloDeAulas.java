/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author santoslopeztzoy
 */

import db.Conexion;
import bean.Aulas;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import manejador.ManejadorDeAulas;


public class ModeloDeAulas extends AbstractTableModel {
    private ArrayList<Aulas> listadoDeAulas = null;
       
    
    private static ModeloDeAulas instancia;
    public static ModeloDeAulas getInstancia(){
        if(instancia==null){
            instancia=new ModeloDeAulas();
        }
        return instancia;
    }
    
    public ModeloDeAulas(){
        listadoDeAulas = new ManejadorDeAulas().getInstancia().listarAulasGuardados();
    }
    
    private String[] encabezado = {"ID AULA","Salon","Edificio","Nivel"};
    
    public String getColumnName(int column){
        return encabezado[column];
    }
    
    public int getColumnCount(){
        return encabezado.length;
    }
    
    public int getRowCount(){
        return listadoDeAulas.size();
    }
    
    public Object getValueAt(int row, int column){
        String resultado = null;
        Aulas aulas = listadoDeAulas.get(row);
        
        switch(column){
            
            case 0:
                resultado = String.valueOf(aulas.getIdAula());
            break;
            
            case 1:
                resultado = String.valueOf(aulas.getNombreSalon());
            break;
            
            case 2:
                resultado = String.valueOf(aulas.getNombreEdificio());
            break;
            
            case 3:
                resultado = String.valueOf(aulas.getNivelAula());
            break;
            
            
        }
        
        return resultado;
        
        
    }
    
    // actualizar JTable
    public void actualizarJTable(){
        listadoDeAulas = new ManejadorDeAulas().getInstancia().listarAulasGuardados();
        fireTableDataChanged();
    }
    
    
}
