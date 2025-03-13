/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jinternal;

/**
 *
 * @author santoslopeztzoy
 */

import db.Conexion;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.GridLayout;
import java.sql.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import manejador.ManejadorHorarioProfesor;


public class HorarioProfesor extends JFrame{
    // necesario para recuperar el valor del id profesor que se pasa desde la otra ventana
    private int idProfesorRecuperado;
    
    public int getIDProfesorRecuperado(){
        return idProfesorRecuperado;
    }
    
    
    private JPanel panelCalendario;
    private Map<String,String> horario;
    
  
    
    public HorarioProfesor(int idProfesor,String carrera,String facultad,String ciclo,String fechaInicioCurso,String fechaFinCurso){
        
        //idProfesorRecuperado=2;
        setTitle("Horario de profesor");
        setSize(900,900);
        // para cerrar solo esta ventana o JFrame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
        /*JLabel titulo = new JLabel("Reporte de horario de clases del profesor(a): ");
        titulo.setFont(new Font("Arial",Font.BOLD,16));*/
        
        
        // Obtener horas únicas desde la BD
       horario = new HashMap<>();
        horario.clear();
        
        
        // se crea o limpia el panel antes de agregar nuevos componentes
        
        if(panelCalendario!=null){
            panelCalendario.removeAll();
        }else{
            panelCalendario = new JPanel(new GridLayout(8,6));

        }
        
        
        String[] dias = {"Hora","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"};
        String[] horas = {"08:00", "10:00", "12:00", "14:00", "16:00", "18:00", "20:00"};
       
        ManejadorHorarioProfesor.getInstancia().limpiarDetallesHorario();

        ManejadorHorarioProfesor.getInstancia().cargarHorarioDesdeBD(idProfesor,carrera,facultad,ciclo,fechaInicioCurso,fechaFinCurso);
        
        // agregar los días como encabezado
        for(String dia:dias){
           panelCalendario.add(new JLabel(dia,SwingConstants.CENTER));
           
        }
        
        // Crear la grilla de horario
        for (String hora : horas) {  // Usar los horarios cargados dinámicamente
            panelCalendario.add(new JLabel(hora, SwingConstants.CENTER));
            
            for (int i = 1; i < dias.length; i++) {
                // se obtiene el dia del encabezado
                String dia = dias[i];  
                String clave = dia + " " + hora;  // Clave para buscar en horario
                // Obtener el curso si existe
                String curso = horario.getOrDefault(clave,"");  
               
                JButton boton = new JButton(curso);
                boton.setBackground(curso.isEmpty() ? Color.LIGHT_GRAY : Color.CYAN);

                // Imprimir los valores guardados
                for (String[] items : ManejadorHorarioProfesor.getInstancia().getDetallesHorario()) {
                    
                    // se verifica si el encabezado de dia y hora es igual a lo que se recupera de la base de datos
                    if (hora.equals(items[1]) && dia.equals(items[2])) {  
                        
                        boton.setText("<html>Salón: "+items[0]+"<br>"+items[1]+"<br>"+items[2]+"<br>"+items[3]+"<br>"+"Horario fin:"+items[4]+"</html>");
                        // Muestra un mensaje en el botón con detalles
                        boton.setToolTipText("<html>Salón: "+items[0]+"<br>"+items[1]+"<br>"+items[2]+"<br>"+items[3]+"<br>"+"Horario fin: "+items[4]+"</html>");  
                    }
                }

                panelCalendario.add(boton);
            }
        }
        
        // refrescar la UI para actualizar los datos
        panelCalendario.revalidate();
        panelCalendario.repaint();
        
        // usar scroll en caso hay demasiados datos
        add(new JScrollPane(panelCalendario)); 
        setVisible(true);
    }
}
