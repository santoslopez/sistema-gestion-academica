
package bean;

/**
 *
 * @author santoslopeztzoy
 * 
 * Aulas.java: representa la tabla que va almacenar la Aula en la base de datos. Las aulas
 * corresponden en donde se van a impartir las clases, todas las aulas tienen asociado un único edificio
 */
public class Aulas {
    private int idAula;
    private String nombre;
    private int idEdificio;
    private int nivel;
    
    // necesario para recuperar el nombre del edificio
    private String nombreEdificio;

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public String getNombreSalon() {
        return nombre;
    }

    public void setNombreSalon(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(int idEdificio) {
        this.idEdificio = idEdificio;
    }

    public int getNivelAula() {
        return nivel;
    }

    public void setNivelAula(int nivel) {
        this.nivel = nivel;
    }

    
    public String getNombreEdificio(){
        return nombreEdificio;
    }
    
    public Aulas() {
    }

    public Aulas(int idAula, String nombre, int idEdificio, int nivel) {
        this.idAula = idAula;
        this.nombre = nombre;
        this.idEdificio = idEdificio;
        this.nivel = nivel;
    }
    
      public Aulas(int idAula, String nombre, String nombreEdificio, int nivel) {
        this.idAula = idAula;
        this.nombre = nombre;
        this.nombreEdificio = nombreEdificio;
        this.nivel = nivel;
    }
    
   
    
    
}
