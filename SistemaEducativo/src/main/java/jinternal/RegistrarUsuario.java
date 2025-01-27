/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package jinternal;

import bean.LlenarComboBox;
import db.Conexion;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author santoslopeztzoy
 */
public class RegistrarUsuario extends javax.swing.JInternalFrame {
    
    private static RegistrarUsuario instancia;
    public static RegistrarUsuario getInstancia(){
        if(instancia==null){
            instancia=new RegistrarUsuario();
        }
        return instancia;
    }
    
    public void llenarComboBox(){
        String consulta="SELECT DISTINCT t.idTipoUsuario,t.nombreTipo FROM TipoUsuario AS t INNER JOIN Usuario AS u ON t.idTipoUsuario=u.idTipoUsuario;";
        // no hace nada debido a que no es relevante para la consulta que estamos haciendo
        Object[] params={};
        LlenarComboBox.getInstancia().tipoCuenta(jComboBoxTipoUsuario,consulta,params,"idTipoUsuario","nombreTipo");
    }
    
    
    /**
     * Creates new form RegistrarUsuario
     */
    public RegistrarUsuario() {
        initComponents();
        //habilitar cierre
        setClosable(true);
        llenarComboBox();
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
        lblNombres = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblUsuario1 = new javax.swing.JLabel();
        jComboBoxTipoUsuario = new javax.swing.JComboBox<>();
        btnRegistrarUsuario = new javax.swing.JButton();

        setTitle("Registrar Usuario");

        lblTitulo.setText("REGISTRAR USUARIO");

        lblNombres.setText("Nombres");

        txtFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoActionPerformed(evt);
            }
        });

        lblFechaNacimiento.setText("Fecha de nacimiento");

        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });

        lblApellidos.setText("Apellidos");

        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        lblUsuario.setText("Usuario");

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        lblCorreo.setText("Correo");

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        lblUsuario1.setText("Tipo usuario");

        jComboBoxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRegistrarUsuario.setText("Guardar");
        btnRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
            .addComponent(lblNombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtFechaNacimiento)
            .addComponent(lblFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(lblApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtApellidos)
            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtCorreo)
            .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtUsuario)
            .addComponent(lblUsuario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jComboBoxTipoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApellidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFechaNacimiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

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

    private void txtFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacimientoActionPerformed

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuarioActionPerformed
        // TODO add your handling code here:
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String fechaNacimiento = txtFechaNacimiento.getText();
        
        String usuario=txtUsuario.getText();
        String carnet="default";
        String correo=txtCorreo.getText();
        
        
        int confirmarGuardar = JOptionPane.showConfirmDialog(null, 
                "¿Estás seguro de registrar el usuario?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if (confirmarGuardar==JOptionPane.YES_OPTION){

            String sentencia = "CALL crearUsuario(?,?,?,?,?,?,?)"; 
            
            
            // necesario para recuperar el ID del tipo de usuario
            LlenarComboBox llenar = (LlenarComboBox)jComboBoxTipoUsuario.getSelectedItem();
            
            int idComboBox= llenar.getId();
            
            Object[] params = {nombres,apellidos,fechaNacimiento,correo,usuario,carnet,idComboBox};

            ResultSet resultado = Conexion.getInstancia().hacerConsulta(sentencia,params);
            
            try{
               if(resultado!=null){
                   if(resultado.next()){
                       String mensajeObtenido = resultado.getString("mensaje");
                       
                       if (mensajeObtenido.equals("enuso")){
                           JOptionPane.showMessageDialog(null, "Error, registro no realizado. El nombre de usuario o correo ya existe.","Mensaje",JOptionPane.ERROR_MESSAGE);
                           
                       }else if(mensajeObtenido.equals("registrado")){
                           JOptionPane.showMessageDialog(null, "Registro exitoso","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                           txtNombres.setText("");
                           txtApellidos.setText("");
                           txtFechaNacimiento.setText("");
                           txtUsuario.setText("");
                           txtCorreo.setText("");   
                       }else{
                           
                       }
                   }
               }
            
                            
             
            }catch(Exception ex){
                ex.printStackTrace();
            }


        }
    }//GEN-LAST:event_btnRegistrarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarUsuario;
    private javax.swing.JComboBox<String> jComboBoxTipoUsuario;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
