
package bean;

/**
 *
 * @author santoslopeztzoy
 */
public class Cursos {
    private int idCurso;
    private String codigo;
    private String nombre;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cursos(int idCurso, String codigo, String nombre) {
        this.idCurso = idCurso;
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    
    public Cursos(){
        
    }
    
    
}
