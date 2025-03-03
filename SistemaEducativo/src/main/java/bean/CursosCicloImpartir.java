/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.time.Year;
import java.util.Date;

/**
 *
 * @author santoslopeztzoy
 */
public class CursosCicloImpartir {
    private int idCursoCiclo;
    
    private int idCurso;
    private int idCarrera;
    //private Year yearImpartido;
    private String fechaInicioClase;
    private String fechaFinClase;
    private String horarioClaseInicio;
    private String horarioClaseFin;
    private int idCiclo;
    private int idAula;

    
    /* necesario para obtener los nombres de los cursos, carrera, etc*/
    private String cursoNombre;
    private String carreraNombre;
    private String cicloDescripcion;
    private String aulaSalon;
    
    public int getIdCursoCiclo(){
        return idCursoCiclo;
    }
    
    public String getCursoNombre(){
        return cursoNombre;
    }
    
    public String getCarreraNombre(){
        return carreraNombre;
    }
    
    public String getCicloDescripcion(){
        return cicloDescripcion;
    }
    
    public String getAulaSalon(){
        return aulaSalon;
    }
    
    public CursosCicloImpartir(int idCurso, int idCarrera, String fechaInicioClase, String fechaFinClase, String horarioClaseInicio,String horarioClaseFin, int idCiclo, int idAula) {
        //this.idCursoCiclo = idCursoCiclo;
        this.idCurso = idCurso;
        this.idCarrera = idCarrera;
        //this.yearImpartido = yearImpartido;
        this.fechaInicioClase = fechaInicioClase;
        this.fechaFinClase = fechaFinClase;
        this.horarioClaseInicio=horarioClaseInicio;
        this.horarioClaseFin=horarioClaseFin;
        this.idCiclo = idCiclo;
        this.idAula = idAula;
    }

    public CursosCicloImpartir(int idCursoCiclo,String cursoNombre,String carreraNombre,String fechaInicioClase,String fechaFinClase,String horarioClaseInicio,String horarioClaseFin,String cicloDescripcion,String aulaSalon) {
        this.idCursoCiclo=idCursoCiclo;
        this.cursoNombre=cursoNombre;
        this.carreraNombre=carreraNombre;
        //this.yearImpartido=yearImpartido;
        this.fechaInicioClase=fechaInicioClase;
        this.fechaFinClase=fechaFinClase;
        this.horarioClaseInicio=horarioClaseInicio;
        this.horarioClaseFin=horarioClaseFin;
        this.cicloDescripcion=cicloDescripcion;
        this.aulaSalon=aulaSalon;
    }
    
    
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    /*public Year getYearImpartido() {
        return yearImpartido;
    }

    public void setYear(Year yearImpartido) {
        this.yearImpartido = yearImpartido;
    }*/

    public String getFechaInicioClase() {
        return fechaInicioClase;
    }

    public void setFechaInicioClase(String fechaInicioClase) {
        this.fechaInicioClase = fechaInicioClase;
    }

    public String getFechaFinClase() {
        return fechaFinClase;
    }
    
    public void setHorarioClaseInicio(String horarioClaseInicio){
        this.horarioClaseInicio=horarioClaseInicio;
    }
    public String getHorarioClaseInicio(){
        return horarioClaseInicio;
    }
    
    public void setHorarioClaseFin(String horarioClaseFin){
        this.horarioClaseFin=horarioClaseFin;
    }
    
    public String getHorarioClaseFin(){
        return horarioClaseFin;
    }
    
    public void setFechaFinClase(String fechaFinClase) {
        this.fechaFinClase = fechaFinClase;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }
    
    
    
    
}
