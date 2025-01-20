
package bean;

import db.Conexion;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author santoslopeztzoy
 */
public class LlenarComboBox {
    
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LlenarComboBox(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    
    /*necesario para que el combobox muestre esto en vez de caracteres raros al cargar el combobox en el formulario*/
    @Override
    public String toString(){
        return nombre;
    }
    
    public LlenarComboBox(){}
    
    
    private static LlenarComboBox instancia;
    public static LlenarComboBox getInstancia(){
        if(instancia==null){
            instancia=new LlenarComboBox();
        }
        return instancia;
    }
    
    /*
    id: es la clave primaria que deseamos recuperar de la tabla
    nombreColumna: pertenece a la tabla que deseamos mostrar y que aparezca en el combobox
    */
    public void tipoCuenta(JComboBox jcomboBox, String tipo,Object[] params,String id,String nombreColumna){
        try{
            ResultSet consulta = Conexion.getInstancia().hacerConsulta(tipo, params);
            jcomboBox.removeAllItems();
            
            while(consulta.next()){
                LlenarComboBox llenar = new LlenarComboBox(Integer.parseInt(consulta.getString(id)),consulta.getString(nombreColumna));
                jcomboBox.addItem(llenar);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
