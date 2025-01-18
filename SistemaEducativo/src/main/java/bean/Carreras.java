
package bean;

/**
 *
 * @author santoslopeztzoy
 */
public class Carreras {
    private int idCarrera;
    private String nombre;
    private int idFacultad;

    public int getIdCarrera() {
        return idCarrera;
    }

    /*public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public Carreras(String nombre, int idFacultad) {
        this.nombre = nombre;
        this.idFacultad = idFacultad;
    }
    
    public Carreras(){
    
    }
}
