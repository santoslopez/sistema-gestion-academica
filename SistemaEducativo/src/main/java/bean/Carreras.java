
package bean;

/**
 *
 * @author santoslopeztzoy
 */
public class Carreras {
    private int idCarrera;
    private String nombre;
    private int idFacultad;

    private String nombreFacultad;
    
    public int getIdCarrera() {
        return idCarrera;
    }

    /*public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }*/

    public String getNombre() {
        return nombre;
    }
    
    public String getNombreFacultad(){
        return nombreFacultad;
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
    
    public Carreras(int idCarrera,String nombre,int idFacultad){
        this.idCarrera=idCarrera;
        this.nombre=nombre;
        this.idFacultad=idFacultad;
    }
    
    public Carreras(int idCarrera,String nombre,String nombreFacultad){
        this.idCarrera=idCarrera;
        this.nombre=nombre;
        this.nombreFacultad=nombreFacultad;
    }
}
