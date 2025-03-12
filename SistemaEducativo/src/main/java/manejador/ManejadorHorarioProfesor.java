/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejador;

/**
 *
 * @author santoslopeztzoy
 */

import java.util.ArrayList;
import java.sql.ResultSet;
import db.Conexion;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class ManejadorHorarioProfesor {
    
    private static ManejadorHorarioProfesor instancia;
    
    public static ManejadorHorarioProfesor getInstancia(){
        if(instancia==null){
            instancia=new ManejadorHorarioProfesor();
        }
        return instancia;
    }
    
    List<String[]> detallesHorario = new ArrayList<>();

    public List<String[]> getDetallesHorario(){
        return detallesHorario;
    }
    
    // Limpia la lista antes de cargar nuevos datos
    public void limpiarDetallesHorario() {
        detallesHorario.clear(); 
    }

    
    public void cargarHorarioDesdeBD(int idProfesor,String carrera,String facultad,String ciclo,String fechaInicioCurso,String fechaFinCurso) {
        
        try {
            //Conexion conexion = Conexion.getInstancia();
            String consulta= "CALL sp_DetallesHorarioProfesor(?,?,?,?,?,?)";
            Object[] params={idProfesor,carrera,facultad,ciclo,fechaInicioCurso,fechaFinCurso};
            ResultSet rs = Conexion.getInstancia().hacerConsulta(consulta,params);
            
            while (rs.next()) {
                String salones = rs.getString("aul.salon");
                String inicio = rs.getString("cursosCicloI.horarioClaseInicio");  // Formato HH:MM
               
                String diaClase = rs.getString("dias.dia");
                String cursoImpartir = rs.getString("curs.nombre");
                String horarioFin = rs.getString("cursosCicloI.horarioClaseFin");
                String cursoFechaInicio = rs.getString("fechaInicioCurso");
                String cursoFechaFin = rs.getString("fechaFinCurso");
                String[] horario1 = {salones,inicio,diaClase,cursoImpartir,horarioFin,cursoFechaInicio,cursoFechaFin};
                detallesHorario.add(horario1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar horarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
