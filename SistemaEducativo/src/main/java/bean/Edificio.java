
package bean;

/**
 *
 * @author santoslopeztzoy
 * 
 * Edificio.java: representa el Edificio que sirve para almacenar los datos a la tabla Edificio de la base de datos.
 
 */
public class Edificio {
    private int idEdificio;
    private String nombreEdificio;
    
    public int getIDEdificio(){
        return idEdificio;
    }
    public void setIDEdificio(int idEdificio){
        this.idEdificio=idEdificio;
    }
    
    public String getNombreEdificio(){
        return nombreEdificio;
    }
    
    public void setNombreEdificio(String nombreEdificio){
        this.nombreEdificio=nombreEdificio;
    }
    
    public Edificio(int idEdificio,String nombreEdificio){
        this.idEdificio=idEdificio;
        this.nombreEdificio=nombreEdificio;
    }
    
}
