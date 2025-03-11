/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author santoslopeztzoy
 */
public class HorarioClaseProfesor {
   
    private int idUsuario;
    private String profesor;
    private String facultad;
    private String carrera;
    private String fechaInicioClase;
    private String fechaFinClase;
    private String nombreCurso;
    private String ciclo;
    private String salon;
    private String nombreEdificio;
    private String horarioClaseInicio;
    private String horarioClaseFin;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFechaInicioClase() {
        return fechaInicioClase;
    }

    public void setFechaInicioClase(String fechaInicioClase) {
        this.fechaInicioClase = fechaInicioClase;
    }

    public String getFechaFinClase() {
        return fechaFinClase;
    }

    public void setFechaFinClase(String fechaFinClase) {
        this.fechaFinClase = fechaFinClase;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public String getHorarioClaseInicio() {
        return horarioClaseInicio;
    }

    public void setHorarioClaseInicio(String horarioClaseInicio) {
        this.horarioClaseInicio = horarioClaseInicio;
    }

    public String getHorarioClaseFin() {
        return horarioClaseFin;
    }

    public void setHorarioClaseFin(String horarioClaseFin) {
        this.horarioClaseFin = horarioClaseFin;
    }

    public HorarioClaseProfesor(String profesor, String facultad, String carrera, String fechaInicioClase, String fechaFinClase, String nombreCurso, String ciclo, String salon, String nombreEdificio, String horarioClaseInicio, String horarioClaseFin) {
        this.profesor = profesor;
        this.facultad = facultad;
        this.carrera = carrera;
        this.fechaInicioClase = fechaInicioClase;
        this.fechaFinClase = fechaFinClase;
        this.nombreCurso = nombreCurso;
        this.ciclo = ciclo;
        this.salon = salon;
        this.nombreEdificio = nombreEdificio;
        this.horarioClaseInicio = horarioClaseInicio;
        this.horarioClaseFin = horarioClaseFin;
    }
    
    
    public HorarioClaseProfesor(int idUsuario,String profesor, String facultad, String carrera, String fechaInicioClase, String fechaFinClase, String ciclo, String nombreEdificio) {
        this.idUsuario=idUsuario;
        this.profesor = profesor;
        this.facultad = facultad;
        this.carrera = carrera;
        this.fechaInicioClase = fechaInicioClase;
        this.fechaFinClase = fechaFinClase;
        this.ciclo = ciclo;
        this.nombreEdificio = nombreEdificio;

    }
    
}
