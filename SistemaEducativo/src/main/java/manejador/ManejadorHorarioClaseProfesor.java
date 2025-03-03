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
        
        String query = "SELECT * FROM HorarioClaseProfesor";
        Object[] params ={};
        
        ResultSet consulta = Conexion.getInstancia().hacerConsulta(query, params);
        
        try{
            while(consulta.next()){
                horario=new HorarioClaseProfesor(
                consulta.getInt("idHorarioClaseProfesor"),
                        consulta.getInt("idCursoCiclo"),
                        consulta.getInt("idDiasSemana"),
                        consulta.getInt("idProfesor")
                );
                
                mostrar.add(horario);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return mostrar;
    }
}
