
package bean;

/**
 *
 * @author santoslopeztzoy
 */
public class Facultad {
    private int idFacultad;
    
    private String nombre;

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public Facultad(int idFacultad, String nombre) {
        this.idFacultad = idFacultad;
        this.nombre = nombre;
    }
    
    public Facultad(String nombre) {
        this.nombre = nombre;
    }
    
    public Facultad(){
        
    }
}
