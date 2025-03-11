/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package jinternal;

import java.awt.event.KeyEvent;
import javax.swing.SwingUtilities;
import modelo.ModeloHorarioClaseProfesor;

/**
 *
 * @author santoslopeztzoy
 */
public class ListadoClasesProfesor extends javax.swing.JInternalFrame {
    
    // necesario para enviar el id para que se seleccione el horario solo del profesor seleccionado
    private int idProfesorSeleccionadoEnviar;
    private String facultadEnviar;
    private String carreraEnviar;
    private String cicloEnviar;
    
    // recuperar el valor de la fila que se le dio click
    private int row;

    private ModeloHorarioClaseProfesor modelo;
    private static ListadoClasesProfesor instancia;
    public static ListadoClasesProfesor getInstancia(){
        if(instancia==null){
            instancia=new ListadoClasesProfesor();
        }
        return instancia;
    }
     
    public ModeloHorarioClaseProfesor getModelo(){
        return modelo;
    }
    
    
    /**
     * Creates new form ListadoClasesProfesor
     */
    public ListadoClasesProfesor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenedor = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListado = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuVerHorarioProfesor = new javax.swing.JMenu();

        setClosable(true);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Listado de horario de profesor");

        modelo = new ModeloHorarioClaseProfesor();
        jTableListado.setModel(modelo);
        jTableListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListadoMouseClicked(evt);
            }
        });
        jTableListado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableListadoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListado);

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jMenuVerHorarioProfesor.setText("Ver calendario");
        jMenuVerHorarioProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuVerHorarioProfesorMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuVerHorarioProfesor);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuVerHorarioProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuVerHorarioProfesorMouseClicked
        // TODO add your handling code here:
        SwingUtilities.invokeLater(() -> new HorarioProfesor(idProfesorSeleccionadoEnviar,carreraEnviar,facultadEnviar,cicloEnviar));
        
    }//GEN-LAST:event_jMenuVerHorarioProfesorMouseClicked

    private void jTableListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListadoMouseClicked
        // TODO add your handling code here:
        row = jTableListado.rowAtPoint(evt.getPoint());
        
        String idSeleccionadoX = jTableListado.getValueAt(row,0).toString();
        this.idProfesorSeleccionadoEnviar=Integer.parseInt(idSeleccionadoX);
        this.facultadEnviar=jTableListado.getValueAt(row,2).toString();
        this.carreraEnviar=jTableListado.getValueAt(row,3).toString();
        this.cicloEnviar=jTableListado.getValueAt(row,6).toString();
        //System.out.println("el id seleccionado es: "+idProfesorSeleccionadoEnviar);
    }//GEN-LAST:event_jTableListadoMouseClicked

    private void jTableListadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableListadoKeyPressed
        // TODO add your handling code here:
        int fila = jTableListado.getSelectedRow();
        if(evt.getKeyCode()==KeyEvent.VK_UP && fila>0){
            fila--;
        }else if (evt.getKeyCode()==KeyEvent.VK_DOWN && fila<jTableListado.getRowCount()-1){
            fila++;
        }else{
            return;
        }
        String idSeleccionado = jTableListado.getValueAt(fila,0).toString();
        this.idProfesorSeleccionadoEnviar=Integer.parseInt(idSeleccionado);
        this.facultadEnviar=jTableListado.getValueAt(fila,2).toString();
        this.carreraEnviar=jTableListado.getValueAt(fila,3).toString();
        this.cicloEnviar=jTableListado.getValueAt(fila,6).toString();
     
    }//GEN-LAST:event_jTableListadoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuVerHorarioProfesor;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListado;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
