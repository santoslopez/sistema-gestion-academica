/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package jinternal;

import db.Conexion;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import modelo.ModeloDeCarreras;

/**
 *
 * @author santoslopeztzoy
 */
public class ListadoCarreras extends javax.swing.JInternalFrame {
    
    // necesario para recuperar el valor del jtable de cierta columna
    
    private int row;
    
    
    // necesario para filtrar la busqueda
    private TableRowSorter sorterTabla;
    
    
    private ModeloDeCarreras modelo;
    private static ListadoCarreras instancia;
    
    public static ListadoCarreras getInstancia(){
        if(instancia==null){
            instancia=new ListadoCarreras();
        }
        return instancia;
    }

    /**
     * Creates new form ListadoCarreras
     */
    public ListadoCarreras() {
        initComponents();
        
        setClosable(true);
        sorterTabla = new TableRowSorter(jTableListadoCarreras.getModel());
        jTableListadoCarreras.setRowSorter(sorterTabla);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenedorPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListadoCarreras = new javax.swing.JTable();
        lblTitul = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanelCarrerasDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIDCarrera = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCarrera = new javax.swing.JTextField();
        btnActualizarDatosCarrera = new javax.swing.JButton();

        lblTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Listado de carreras");

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        modelo = new ModeloDeCarreras();
        jTableListadoCarreras.setModel(modelo);
        jTableListadoCarreras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListadoCarrerasMouseClicked(evt);
            }
        });
        jTableListadoCarreras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableListadoCarrerasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListadoCarreras);

        lblTitul.setText("Buscar");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContenedorPrincipalLayout = new javax.swing.GroupLayout(jPanelContenedorPrincipal);
        jPanelContenedorPrincipal.setLayout(jPanelContenedorPrincipalLayout);
        jPanelContenedorPrincipalLayout.setHorizontalGroup(
            jPanelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorPrincipalLayout.createSequentialGroup()
                .addComponent(lblTitul, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
            .addGroup(jPanelContenedorPrincipalLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
            .addGroup(jPanelContenedorPrincipalLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelContenedorPrincipalLayout.setVerticalGroup(
            jPanelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorPrincipalLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContenedorPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(lblTitul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jTabbedPane2.setToolTipText("");

        jLabel1.setText("ID");

        txtIDCarrera.setEnabled(false);

        jLabel2.setText("Nombre");

        txtNombreCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCarreraActionPerformed(evt);
            }
        });

        btnActualizarDatosCarrera.setText("Actualizar datos");
        btnActualizarDatosCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosCarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCarrerasDatosLayout = new javax.swing.GroupLayout(jPanelCarrerasDatos);
        jPanelCarrerasDatos.setLayout(jPanelCarrerasDatosLayout);
        jPanelCarrerasDatosLayout.setHorizontalGroup(
            jPanelCarrerasDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtIDCarrera)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtNombreCarrera)
            .addComponent(btnActualizarDatosCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        jPanelCarrerasDatosLayout.setVerticalGroup(
            jPanelCarrerasDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCarrerasDatosLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(btnActualizarDatosCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Datos carreras", jPanelCarrerasDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2)
                .addGap(0, 0, 0)
                .addComponent(jPanelContenedorPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelContenedorPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String buscar = txtBuscar.getText();
        sorterTabla.setRowFilter(RowFilter.regexFilter("(?i)"+buscar));
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtNombreCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCarreraActionPerformed

    private void btnActualizarDatosCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosCarreraActionPerformed
        // TODO add your handling code here:
        int confirmarDatos = JOptionPane.showConfirmDialog(null, "¿Confirmar actualización de datos?","Mensaje",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if (confirmarDatos==JOptionPane.YES_OPTION){
            
            int idCarrera=Integer.parseInt(txtIDCarrera.getText())
;            
            
            String sentencia = "CALL modificarDatosCarreras(?,?)";
            Object[] params={txtNombreCarrera.getText(),idCarrera};
            ResultSet consulta=Conexion.getInstancia().hacerConsulta(sentencia,params);
            
            try{
                if(consulta!=null){
                    if(consulta.next()){
                        String mensajeObtenido = consulta.getString("mensaje");
                    
                        if(mensajeObtenido.equals("actualizado")){
                            JOptionPane.showMessageDialog(null, "Datos actualizado","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Error datos actualizado","Mensaje",JOptionPane.ERROR_MESSAGE);

                        }
                    }                  
                }
                

            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
    }//GEN-LAST:event_btnActualizarDatosCarreraActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTableListadoCarrerasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListadoCarrerasMouseClicked
        // TODO add your handling code here:
         // TODO add your handling code here:
        row = jTableListadoCarreras.rowAtPoint(evt.getPoint());
        txtIDCarrera.setText(jTableListadoCarreras.getValueAt(row,0).toString());
        txtNombreCarrera.setText(jTableListadoCarreras.getValueAt(row,1).toString());
       
    }//GEN-LAST:event_jTableListadoCarrerasMouseClicked

    private void jTableListadoCarrerasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableListadoCarrerasKeyPressed
        // TODO add your handling code here:
        int fila = jTableListadoCarreras.getSelectedRow();
        
        if (evt.getKeyCode()==KeyEvent.VK_UP && fila>0){
            fila--;
        }else if (evt.getKeyCode()==KeyEvent.VK_DOWN && fila < jTableListadoCarreras.getRowCount() - 1){
        
            fila++;
        }else{
            return;
        }
        
    // Mostrar los valores de la fila en los campos de texto
    txtIDCarrera.setText(jTableListadoCarreras.getValueAt(fila, 0).toString());
    txtNombreCarrera.setText(jTableListadoCarreras.getValueAt(fila, 1).toString());
    
        //System.out.println("holxxxa:; "+row);
    }//GEN-LAST:event_jTableListadoCarrerasKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarDatosCarrera;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelCarrerasDatos;
    private javax.swing.JPanel jPanelContenedorPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableListadoCarreras;
    private javax.swing.JLabel lblTitul;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIDCarrera;
    private javax.swing.JTextField txtNombreCarrera;
    // End of variables declaration//GEN-END:variables
}
