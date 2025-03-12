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
import bean.CursosCicloImpartir;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import manejador.ManejadorCursosCicloImpartir;



public class ModeloCursosCicloImpartir extends AbstractTableModel{
   
    
    private ArrayList<CursosCicloImpartir> listado = null;
    private static ModeloCursosCicloImpartir instancia;
    
    private static ModeloCursosCicloImpartir getInstancia(){
        if(instancia==null){
            instancia=new ModeloCursosCicloImpartir();
        }
        return instancia;
    }
    
    public ModeloCursosCicloImpartir(){
        listado=new ManejadorCursosCicloImpartir().getInstancia().listarCursosCicloImpartirGuardados();
    }
    
    private String[] encabezado = {"ID","Curso","Carrera","Horario de clase inicio","Horario clase fin","Fecha inicio","Fecha fin","Ciclo","Salón","Fecha inicio curso","Fecha fin curso"};
    
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
        
        CursosCicloImpartir cursos = listado.get(row);
        
        
        switch(column){
            case 0:
                resultado = String.valueOf(cursos.getIdCursoCiclo());
            break;
            
            case 1:
                resultado = String.valueOf(cursos.getCursoNombre());
            break;
            
            case 2:
                resultado = String.valueOf(cursos.getCarreraNombre());
            break;
            
            /*case 2:
                resultado = String.valueOf(cursos.getYearImpartido());
                
            break;*/
            
            case 3:
                resultado = String.valueOf(cursos.getFechaInicioClase());
            break;
            
            case 4:
                resultado =  String.valueOf(cursos.getFechaFinClase());
            break;
            
            case 5:
                resultado = String.valueOf(cursos.getHorarioClaseInicio());
            break;
            
                        
            case 6:
                resultado = String.valueOf(cursos.getHorarioClaseFin());
            break;
            
            case 7:
                resultado = String.valueOf(cursos.getCicloDescripcion());
            break;
            
            case 8:
                resultado = String.valueOf(cursos.getAulaSalon());
            break;
            


        }
        
        return resultado;
    }
    
    public void actualizarJTable(){
        listado = new ManejadorCursosCicloImpartir().getInstancia().listarCursosCicloImpartirGuardados();
        fireTableDataChanged();
    }
    
    
}
