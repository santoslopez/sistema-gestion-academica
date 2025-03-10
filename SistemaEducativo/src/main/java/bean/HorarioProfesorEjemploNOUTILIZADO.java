/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class HorarioProfesorEjemploNOUTILIZADO extends JFrame {
    private JPanel panelCalendario;
    private Map<String, String> horario;

    public HorarioProfesorEjemploNOUTILIZADO() {
        setTitle("Horario del Profesor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mapa para almacenar los horarios
        horario = new HashMap<>();
        horario.put("Lunes 08:00", "Programación");
        horario.put("Martes 10:00", "Bases de Datos");
        horario.put("Miércoles 12:00", "Redes");

        panelCalendario = new JPanel(new GridLayout(8, 6));
        String[] dias = {"Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        String[] horas = {"08:00", "10:00", "12:00", "14:00", "16:00", "18:00", "20:00"};

        // Agregar los días como encabezados
        for (String dia : dias) {
            panelCalendario.add(new JLabel(dia, SwingConstants.CENTER));
        }

        // Crear la grilla de horario
        for (String hora : horas) {
            panelCalendario.add(new JLabel(hora, SwingConstants.CENTER));
            for (int i = 1; i < dias.length; i++) {
                String clave = dias[i] + " " + hora;
                JButton boton = new JButton(horario.getOrDefault(clave, ""));
                boton.setBackground(boton.getText().isEmpty() ? Color.LIGHT_GRAY : Color.CYAN);
                panelCalendario.add(boton);
            }
        }

        add(panelCalendario);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HorarioProfesorEjemploNOUTILIZADO::new);
    }
}
