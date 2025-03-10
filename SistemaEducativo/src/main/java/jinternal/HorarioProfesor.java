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
import javax.swing.*;
import java.awt.GridLayout;
import java.sql.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import manejador.ManejadorHorarioProfesor;


public class HorarioProfesor extends JFrame{
    
    private JPanel panelCalendario;
    private Map<String,String> horario;
    
    public HorarioProfesor(){
        setTitle("Horario de profesor");
        setSize(900,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        // Obtener horas únicas desde la BD
       horario = new HashMap<>();
        
        panelCalendario = new JPanel(new GridLayout(8,6));
        
        String[] dias = {"Hora","Lunes","Martes","Miércoles","Jueves","Viernes","Sábado"};
        String[] horas = {"08:00", "10:00", "12:00", "14:00", "16:00", "18:00", "20:00"};
       
        
        ManejadorHorarioProfesor.getInstancia().cargarHorarioDesdeBD(2);
        
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
        // usar scroll en caso hay demasiados datos
        add(new JScrollPane(panelCalendario)); 
        setVisible(true);
    }
}
