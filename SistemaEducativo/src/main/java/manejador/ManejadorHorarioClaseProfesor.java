/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package manejador;

/**
 *
 * @author santoslopeztzoy
 */

import bean.HorarioClaseProfesor;
import db.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ManejadorHorarioClaseProfesor {
    
    private ArrayList<HorarioClaseProfesor> mostrar;
    private static ManejadorHorarioClaseProfesor instancia;
    public static ManejadorHorarioClaseProfesor getInstancia(){
        if(instancia==null){
            instancia=new ManejadorHorarioClaseProfesor();
        }
        return instancia;
    }
    
    public ManejadorHorarioClaseProfesor(){
        mostrar = new ArrayList<HorarioClaseProfesor>();
    }
    
    
    public ArrayList<HorarioClaseProfesor> getListarHorariosProfesor(){
        return mostrar;
    }
    
    
    public ArrayList<HorarioClaseProfesor> listarHorariosClaseProfesor(){
        HorarioClaseProfesor horario = null;
        
        mostrar.removeAll(mostrar);
        
        String query = "CALL listarDatosHorarioProfesor()";
        Object[] params ={};
        
        ResultSet consulta = Conexion.getInstancia().hacerConsulta(query, params);
        
        try{
            while(consulta.next()){
                horario=new HorarioClaseProfesor(
                        consulta.getInt("idUsuario"),
                  consulta.getString("Profesor"),
                        consulta.getString("Facultad"),
                        consulta.getString("Carrera"),
                        consulta.getString("cursosCicloI.fechaInicioClase"),
                        consulta.getString("cursosCicloI.fechaFinClase"),
                        //consulta.getString("Curso"),
                        consulta.getString("Ciclo"),
                        //consulta.getString("aul.salon"),
                        consulta.getString("edif.nombreEdificio")
                        //consulta.getString("cursosCicloI.horarioClaseInicio"),
                        //consulta.getString("cursosCicloI.horarioClaseFin")
                );
                
                mostrar.add(horario);
            }
        }catch(Exception ex){
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Se produjo el siguiente error: "+ex.getMessage(),"Mensaje",JOptionPane.ERROR_MESSAGE);
        }
        
        return mostrar;
    }
}
