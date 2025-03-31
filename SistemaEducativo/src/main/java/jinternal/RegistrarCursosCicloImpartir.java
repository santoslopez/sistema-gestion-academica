/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package jinternal;

import bean.LlenarComboBox;
import com.toedter.calendar.JDateChooser;
import db.Conexion;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author santoslopeztzoy
 */
public class RegistrarCursosCicloImpartir extends javax.swing.JInternalFrame {

    private JDateChooser dateChooser = new JDateChooser();
    private JDateChooser dateChooserFinCurso = new JDateChooser();
    
    
    // para horas, minutos y segundos
    //private SimpleDateFormat horarioInicioClase = new SimpleDateFormat();
    private JFormattedTextField timeField = new JFormattedTextField();
    
    
    private Calendar calendar= Calendar.getInstance();
    
    
    
    
    public void llenarComboboxCurso(){
        String consulta= "SELECT * From Cursos";
        Object[] params={};
        
        LlenarComboBox.getInstancia().tipoCuenta(cboCurso,consulta,params,"idCurso","nombre");
    }
    
    public void llenarComboboxCarrera(){
        String consulta="SELECT * FROM Carreras";
        Object[] params={};
        
        LlenarComboBox.getInstancia().tipoCuenta(cboCarrera, consulta, params,"idCarrera","nombre");
    }
    
    public void llenarComboboxCiclo(){
        String consulta="SELECT * FROM Ciclos";
        Object[] params={};
        
        LlenarComboBox.getInstancia().tipoCuenta(cboCiclo, consulta, params,"idCiclo","descripcion");
    }
    
    public void llenarComboboxAulas(){
        String consulta="SELECT * FROM Aula";
        Object[] params={};
        LlenarComboBox.getInstancia().tipoCuenta(cboSalon, consulta, params, "idAula","salon");
    }
    /**
     * Creates new form RegistrarCursosCicloImpartir
     */
    public RegistrarCursosCicloImpartir() {
        initComponents();
        setClosable(true);
        
        ((JTextField) dateChooser.getDateEditor().getUiComponent()).setEditable(false);
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setBounds(160,140,180, 30);  // Ajusta la posición y el tamaño
        jPanelContenedor.add(dateChooser);
        
        
        ((JTextField) dateChooserFinCurso.getDateEditor().getUiComponent()).setEditable(false);
        dateChooserFinCurso.setDateFormatString("yyyy-MM-dd");
        dateChooserFinCurso.setBounds(160,180,180,30);
        jPanelContenedor.add(dateChooserFinCurso);
        
        
        /* configurando posición de hora, minutos y segundos
        timeField.setValue(new Date());
        timeField.setColumns(8);
        timeField.setBounds(160,220, 180, 30);
        jPanelContenedor.add(timeField);*/
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        
        // Crear el modelo de fecha para el Jpinner
        SpinnerDateModel model = new SpinnerDateModel();
        
        JSpinner spinner = new JSpinner(model);
        
        // configurar el editor del jspinner para mostrar el formato de hh:mm:ss
        JTextField textField =((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
        textField.setEditable(false);
        
        
        //spinner.setEnabled(false);
        //spinner.setEnabled(false);
        //spinner.setEditor(editor);
        spinner.setBounds(160,210,180,30);
        
        jPanelContenedor.add(spinner);
        
                
        
        
        
        llenarComboboxCurso();
        llenarComboboxCarrera();
        llenarComboboxCiclo();
        llenarComboboxAulas();
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
        lblCurso = new javax.swing.JLabel();
        cboCurso = new javax.swing.JComboBox<>();
        lblCarrera = new javax.swing.JLabel();
        cboCarrera = new javax.swing.JComboBox<>();
        lblFechaInicioClase = new javax.swing.JLabel();
        lblFechaFinClase = new javax.swing.JLabel();
        lblCiclo = new javax.swing.JLabel();
        cboCiclo = new javax.swing.JComboBox<>();
        lblSalon = new javax.swing.JLabel();
        cboSalon = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        lblHorarioClase = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtHorarioClaseFin = new javax.swing.JTextField();

        setTitle("Registrar cursos ciclo impartir");

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Registrar");

        lblCurso.setText("Curso");

        cboCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCarrera.setText("Carrera");

        cboCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblFechaInicioClase.setText("Fecha inicio clase");

        lblFechaFinClase.setText("Fecha fin clase");

        lblCiclo.setText("Ciclo");

        cboCiclo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSalon.setText("Salón");

        cboSalon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblHorarioClase.setText("Horario de clase inicio");

        jLabel1.setText("Horario de clase fin");

        javax.swing.GroupLayout jPanelContenedorLayout = new javax.swing.GroupLayout(jPanelContenedor);
        jPanelContenedor.setLayout(jPanelContenedorLayout);
        jPanelContenedorLayout.setHorizontalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelContenedorLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addGap(125, 125, 125))
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblSalon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCiclo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFechaFinClase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFechaInicioClase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addComponent(lblCurso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCarrera, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblHorarioClase)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboCarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboCiclo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboSalon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHorarioClaseFin)))
        );
        jPanelContenedorLayout.setVerticalGroup(
            jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContenedorLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboCurso, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFechaInicioClase, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblFechaFinClase, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHorarioClase)
                .addGap(12, 12, 12)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtHorarioClaseFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        LlenarComboBox curso  = (LlenarComboBox)cboCurso.getSelectedItem();
        LlenarComboBox carrera = (LlenarComboBox)cboCarrera.getSelectedItem();
        
        
        //String fechaInicioClase = txtFechaInicioClase.getText();
        

        Date fechaInicioCurso = dateChooser.getDate();
        String fechaInicioClase = String.valueOf(fechaInicioCurso );
        
        
        //String fechaFinClase = txtFechaFinClase.getText();
        Date fechaFinCurso = dateChooser.getDate();
        String fechaFinClase = String.valueOf(fechaFinCurso);
        
        LlenarComboBox ciclos = (LlenarComboBox)cboCiclo.getSelectedItem();
        LlenarComboBox salon = (LlenarComboBox)cboSalon.getSelectedItem();
        
        //String horarioClaseInicio = txtHorarioClaseInicio.getText();
        
        String horarioClaseFin = txtHorarioClaseFin.getText();
        
        if(curso==null || carrera==null || salon==null || ciclos==null){
        
            JOptionPane.showMessageDialog(null,"Error, debe ingresar un curso, carrera, ciclo y salon","Mensaje",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (fechaInicioClase.length()<=0 || fechaFinClase.length()<=0){
            JOptionPane.showMessageDialog(null,"Error, debe ingresar las fechas de inicio y fin del curso","Mensaje",JOptionPane.ERROR_MESSAGE);

            return;
        }
        
        //String horarioInicioCurso = txtHorarioClaseInicio.getText();
        String horarioFinCurso = txtHorarioClaseFin.getText();
        if ( horarioFinCurso.length()<=0){
               //if (horarioInicioCurso.length()<=0 || horarioFinCurso.length()<=0){
 
            JOptionPane.showMessageDialog(null,"Error, debe ingresar las fechas de inicio y fin del curso","Mensaje",JOptionPane.ERROR_MESSAGE);

            return;
        }
        
        int confirmar = JOptionPane.showConfirmDialog(null,"¿Deseas guardar los datos?","Mensaje",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        
        if (confirmar==JOptionPane.YES_OPTION){
            String consulta = "CALL sp_agregarCursosCicloImpartir(?,?,?,?,?,?,?,?)";
            
            Object[] params = {curso.getId(),carrera.getId(),fechaInicioClase,fechaFinClase,"20:00:00",horarioClaseFin,ciclos.getId(),salon.getId()};
            
            ResultSet ejecutar = Conexion.getInstancia().hacerConsulta(consulta, params);
            
            try{
                if(ejecutar!=null){
                    while(ejecutar.next()){
                        String mensajeObtenido = ejecutar.getString("mensaje");
                        
                        if (mensajeObtenido.equals("registrado")){
                            //txtFechaInicioClase.setText("");
                            //txtFechaFinClase.setText("");
                            //txtHorarioClaseInicio.setText("");
                            txtHorarioClaseFin.setText("");
                            JOptionPane.showMessageDialog(null, "Registro exitoso","Mensaje",JOptionPane.INFORMATION_MESSAGE);   
                            
                            ListadoCursosCicloImpartir.getInstancia().getModelo().actualizarJTable();
                        }else if (mensajeObtenido.equals("yaexiste")){
                            JOptionPane.showMessageDialog(null, "Error los datos ya existen.","Mensaje",JOptionPane.ERROR_MESSAGE);   
                        }else if (mensajeObtenido.equals("errorproducido")){
                            JOptionPane.showMessageDialog(null, "Error controlado","Mensaje",JOptionPane.ERROR_MESSAGE);   

                        }else{
                            JOptionPane.showMessageDialog(null, "Error controlado: "+mensajeObtenido,"Mensaje",JOptionPane.ERROR_MESSAGE);   

                        }
                    }
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboCarrera;
    private javax.swing.JComboBox<String> cboCiclo;
    private javax.swing.JComboBox<String> cboCurso;
    private javax.swing.JComboBox<String> cboSalon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelContenedor;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblCiclo;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblFechaFinClase;
    private javax.swing.JLabel lblFechaInicioClase;
    private javax.swing.JLabel lblHorarioClase;
    private javax.swing.JLabel lblSalon;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtHorarioClaseFin;
    // End of variables declaration//GEN-END:variables
}
