package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import jdialg.ModificarPerfil;
import jinternal.ListadoAulas;
import jinternal.ListadoCarreras;
import jinternal.ListadoEdificios;
import jinternal.ListadoFacultad;
import jinternal.ListadoUsuarios;
import jinternal.RegistrarCarrera;
import jinternal.RegistrarFacultad;
import jinternal.RegistrarUsuario;

/**
 *
 * @author santoslopeztzoy
 */
public class MenuPrincipalJFrame extends javax.swing.JFrame {
    
    private static MenuPrincipalJFrame instancia;
    public static MenuPrincipalJFrame getInstancia(){
        if(instancia==null){
            instancia=new MenuPrincipalJFrame();
        }
        return instancia;
    }
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    // obtener ancho y alto
    int ancho = screenSize.width;
    int alto = screenSize.height;
    int dimensionRestar = 300;
    
    /**
     * Creates new form MenuPrincipalJFrame
     */
    public MenuPrincipalJFrame() {
        initComponents();
        this.setSize(ancho-dimensionRestar,alto-dimensionRestar);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        jLabelTitulo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuUsuarios = new javax.swing.JMenu();
        jMenuItemRegistrarUsuarios = new javax.swing.JMenuItem();
        jMenuItemListarUsuarios = new javax.swing.JMenuItem();
        jMenuCarreras = new javax.swing.JMenu();
        jMenuItemRegistrarCarreras = new javax.swing.JMenuItem();
        jMenuItemListarCarreras = new javax.swing.JMenuItem();
        jMenuFacultad = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItemListarFacultad = new javax.swing.JMenuItem();
        jMenuEdificios = new javax.swing.JMenu();
        jMenuItemListadoEdificios = new javax.swing.JMenuItem();
        jMenuAulas = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemActualizarPerfil = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));

        jLabelTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("SISTEMA EDUCATIVO");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel1.setText("Bienvenido:");

        escritorio.setLayer(jLabelTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(jLabel1))
                .addGap(0, 173, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        jMenuUsuarios.setText("Usuarios");

        jMenuItemRegistrarUsuarios.setText("Registrar");
        jMenuItemRegistrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistrarUsuariosActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItemRegistrarUsuarios);

        jMenuItemListarUsuarios.setText("Lista estudiantes");
        jMenuItemListarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarUsuariosActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItemListarUsuarios);

        jMenuBar1.add(jMenuUsuarios);

        jMenuCarreras.setText("Carreras");

        jMenuItemRegistrarCarreras.setText("Registrar");
        jMenuItemRegistrarCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistrarCarrerasActionPerformed(evt);
            }
        });
        jMenuCarreras.add(jMenuItemRegistrarCarreras);

        jMenuItemListarCarreras.setText("Listar");
        jMenuItemListarCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarCarrerasActionPerformed(evt);
            }
        });
        jMenuCarreras.add(jMenuItemListarCarreras);

        jMenuBar1.add(jMenuCarreras);

        jMenuFacultad.setText("Facultad");

        jMenuItem1.setText("Registrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuFacultad.add(jMenuItem1);

        jMenuItemListarFacultad.setText("Listar");
        jMenuItemListarFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarFacultadActionPerformed(evt);
            }
        });
        jMenuFacultad.add(jMenuItemListarFacultad);

        jMenuBar1.add(jMenuFacultad);

        jMenuEdificios.setText("Edificios");

        jMenuItemListadoEdificios.setText("Listado de edificios");
        jMenuItemListadoEdificios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListadoEdificiosActionPerformed(evt);
            }
        });
        jMenuEdificios.add(jMenuItemListadoEdificios);

        jMenuBar1.add(jMenuEdificios);

        jMenuAulas.setText("Aulas");

        jMenuItem3.setText("Listado de aulas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuAulas.add(jMenuItem3);

        jMenuBar1.add(jMenuAulas);

        jMenu1.setText("Perfil");

        jMenuItemActualizarPerfil.setText("Actualizar perfil");
        jMenuItemActualizarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemActualizarPerfilActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemActualizarPerfil);

        jMenuItem2.setText("Cerrar sesión");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemRegistrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistrarUsuariosActionPerformed
        // TODO add your handling code here:
        if(!escritorio.isAncestorOf(RegistrarUsuario.getInstancia())){
            escritorio.add(RegistrarUsuario.getInstancia());
            RegistrarUsuario.getInstancia().setVisible(true);
        }else{
            escritorio.setSelectedFrame(RegistrarUsuario.getInstancia());
        }
    }//GEN-LAST:event_jMenuItemRegistrarUsuariosActionPerformed

    private void jMenuItemListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarUsuariosActionPerformed
        // TODO add your handling code here:
        
        if(!escritorio.isAncestorOf(ListadoUsuarios.getInstancia())){
            escritorio.add(ListadoUsuarios.getInstancia());
            ListadoUsuarios.getInstancia().setVisible(true);
        }else{
            escritorio.setSelectedFrame(ListadoUsuarios.getInstancia());
        }
    }//GEN-LAST:event_jMenuItemListarUsuariosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if(!escritorio.isAncestorOf(RegistrarFacultad.getInstancia())){
            escritorio.add(RegistrarFacultad.getInstancia());
            RegistrarFacultad.getInstancia().setVisible(true);
        }else{
            escritorio.setSelectedFrame(RegistrarFacultad.getInstancia());
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemListarFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarFacultadActionPerformed
        // TODO add your handling code here:
       
        
        if(!escritorio.isAncestorOf(ListadoFacultad.getInstancia())){
            escritorio.add(ListadoFacultad.getInstancia());
            ListadoFacultad.getInstancia().setVisible(true);
        }else{
            escritorio.setSelectedFrame(ListadoFacultad.getInstancia());
        }
        
    }//GEN-LAST:event_jMenuItemListarFacultadActionPerformed

    private void jMenuItemListarCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarCarrerasActionPerformed
        // TODO add your handling code here:        
        if(!escritorio.isAncestorOf(ListadoCarreras.getInstancia())){
            escritorio.add(ListadoCarreras.getInstancia());
            ListadoCarreras.getInstancia().setVisible(true);
        }else{
            escritorio.setSelectedFrame(ListadoCarreras.getInstancia());
        }
        
    }//GEN-LAST:event_jMenuItemListarCarrerasActionPerformed

    private void jMenuItemRegistrarCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistrarCarrerasActionPerformed
        // TODO add your handling code here:
        
        if(!escritorio.isAncestorOf(RegistrarCarrera.getInstancia())){
            escritorio.add(RegistrarCarrera.getInstancia());
            RegistrarCarrera.getInstancia().setVisible(true);
        }else{
            escritorio.setSelectedFrame(RegistrarCarrera.getInstancia());
        }
        
    }//GEN-LAST:event_jMenuItemRegistrarCarrerasActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int confirmarCerrarSesion = JOptionPane.showConfirmDialog(null,"¿Confirmar cierre del programa?","Mensaje",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if(confirmarCerrarSesion==JOptionPane.YES_OPTION){
            System.exit(0);
        }
       
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItemActualizarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemActualizarPerfilActionPerformed
        // TODO add your handling code here:
        //ModificarPerfil m = new ModificarPerfil(this,true);
        ModificarPerfil.getInstancia().setVisible(true);
        String usuario = lblUsuario.getText();
        ModificarPerfil.getInstancia().setNombres(usuario);
        
    }//GEN-LAST:event_jMenuItemActualizarPerfilActionPerformed

    private void jMenuItemListadoEdificiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListadoEdificiosActionPerformed
        // TODO add your handling code here:
        if(!escritorio.isAncestorOf(ListadoEdificios.getInstancia())){
            escritorio.add(ListadoEdificios.getInstancia());
            ListadoEdificios.getInstancia().setVisible(true);
        }else{
            escritorio.setSelectedFrame(ListadoEdificios.getInstancia());
        }
    }//GEN-LAST:event_jMenuItemListadoEdificiosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        
        if(!escritorio.isAncestorOf(ListadoAulas.getInstancia())){
            escritorio.add(ListadoAulas.getInstancia());
            ListadoAulas.getInstancia().setVisible(true);
        }else{
            escritorio.setSelectedFrame(ListadoAulas.getInstancia());
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalJFrame().setVisible(true);
            }
        });
    }
    
    public JLabel getUsuario(){
        return lblUsuario;
    }
    
    public void setUsuario(String usuario){
        lblUsuario.setText(usuario);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenuAulas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuCarreras;
    private javax.swing.JMenu jMenuEdificios;
    private javax.swing.JMenu jMenuFacultad;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemActualizarPerfil;
    private javax.swing.JMenuItem jMenuItemListadoEdificios;
    private javax.swing.JMenuItem jMenuItemListarCarreras;
    private javax.swing.JMenuItem jMenuItemListarFacultad;
    private javax.swing.JMenuItem jMenuItemListarUsuarios;
    private javax.swing.JMenuItem jMenuItemRegistrarCarreras;
    private javax.swing.JMenuItem jMenuItemRegistrarUsuarios;
    private javax.swing.JMenu jMenuUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
