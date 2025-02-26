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
    private int idHorarioClaseProfesor;
    private int idCursoCiclo;
    private int idDiasSemana;
    private int idProfesor;

    public HorarioClaseProfesor(int idHorarioClaseProfesor, int idCursoCiclo, int idDiasSemana, int idProfesor) {
        this.idHorarioClaseProfesor = idHorarioClaseProfesor;
        this.idCursoCiclo = idCursoCiclo;
        this.idDiasSemana = idDiasSemana;
        this.idProfesor = idProfesor;
    }

    public int getIdHorarioClaseProfesor() {
        return idHorarioClaseProfesor;
    }

    public void setIdHorarioClaseProfesor(int idHorarioClaseProfesor) {
        this.idHorarioClaseProfesor = idHorarioClaseProfesor;
    }

    public int getIdCursoCiclo() {
        return idCursoCiclo;
    }

    public void setIdCursoCiclo(int idCursoCiclo) {
        this.idCursoCiclo = idCursoCiclo;
    }

    public int getIdDiasSemana() {
        return idDiasSemana;
    }

    public void setIdDiasSemana(int idDiasSemana) {
        this.idDiasSemana = idDiasSemana;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }
    
}
