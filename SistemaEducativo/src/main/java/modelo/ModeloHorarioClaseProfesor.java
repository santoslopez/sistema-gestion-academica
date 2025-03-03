/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author santoslopeztzoy
 */

import bean.HorarioClaseProfesor;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import manejador.ManejadorHorarioClaseProfesor;

public class ModeloHorarioClaseProfesor extends AbstractTableModel {
    
    private ArrayList<HorarioClaseProfesor> listado = null;
    private static ModeloHorarioClaseProfesor instancia;
    
    public static ModeloHorarioClaseProfesor getInstancia(){
        if(instancia==null){
            instancia=new ModeloHorarioClaseProfesor();
        }
        return instancia;
    }
    
    public ModeloHorarioClaseProfesor(){
        listado = new ManejadorHorarioClaseProfesor().getInstancia().listarHorariosClaseProfesor();
    }
    
    private String[] encabezado = {"ID","Curso ciclo","Dias impartir","Profesor"};
    
    public String getColumnName(int column){
        return encabezado[column];
    }
    
    public int getColumnCount(){
        return encabezado.length;
    }
    
    public int getRowCount(){
        return listado.size();
    }
    
    public Object getValueAt(int row, int column){
        String resultado = null;
        
        HorarioClaseProfesor horario = listado.get(row);
        
        switch(column){
            case 0:
                resultado = String.valueOf(horario.getIdHorarioClaseProfesor());
            break;
            
            case 1:
                resultado = String.valueOf(horario.getIdCursoCiclo());
            break;
            
            case 2:
                resultado = String.valueOf(horario.getIdDiasSemana());
            break;
            
            case 3:
                resultado = String.valueOf(horario.getIdProfesor());
            break;
        }
        
        return resultado;
    }
    
    public void actualizarJTable(){
        listado = new ManejadorHorarioClaseProfesor().getInstancia().getListarHorariosProfesor();
        fireTableDataChanged();
    }
}
