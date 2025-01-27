
package bean;

/**
 *
 * @author santoslopeztzoy
 * Ciclos.java: representa el ciclo del curso que se va a impartir, ejemplo: trimestre 1, trimestre 2,
 * trimestre 3, etc., semestre 1, etc.
 */
public class Ciclos {
    private int idCiclo;
    private String descripcion;
    
    public int getIDCiclo(){
        return idCiclo;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    
    public Ciclos(int idCiclo,String descripcion){
        this.idCiclo=idCiclo;
        this.descripcion=descripcion;
    }
    
    
    public Ciclos(String descripcion){
        this.descripcion=descripcion;
    }
    
    public Ciclos(){
    }
    
}
