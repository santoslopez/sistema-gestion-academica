/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejador;

/**
 *
 * @author santoslopeztzoy
 */

import db.Conexion;
import bean.CursosCicloImpartir;
import java.sql.ResultSet;
import java.time.Year;
import java.util.ArrayList;
import java.sql.Date;  
public class ManejadorCursosCicloImpartir {
    
    private ArrayList<CursosCicloImpartir> mostrar;
    private static ManejadorCursosCicloImpartir instancia;
    public static ManejadorCursosCicloImpartir getInstancia(){
        if(instancia==null){
            instancia=new ManejadorCursosCicloImpartir();
        }
        return instancia;
    }
    
    public ManejadorCursosCicloImpartir(){
        mostrar=new ArrayList<CursosCicloImpartir>();
    }
    
    public ArrayList<CursosCicloImpartir> getListarCursosCicloImpartir(){
        return mostrar;
    }
    
    public ArrayList<CursosCicloImpartir> listarCursosCicloImpartirGuardados(){
        CursosCicloImpartir cursosCiclo = null;
        mostrar.removeAll(mostrar);
        
        String query = "CALL sp_detallesCursosCicloImpartir()";
        
        Object[] params={};
        ResultSet consulta = Conexion.getInstancia().hacerConsulta(query, params);
        
        try{
            while(consulta.next()){
                cursosCiclo = new CursosCicloImpartir(
                        consulta.getString("cursos.nombre"),
                        consulta.getString("car.nombre"),
                        //Year.of(consulta.getInt("cursoimp.yearImpartido")),
                        consulta.getString("cursoimp.horarioClaseInicio"),
                        consulta.getString("cursoimp.horarioClaseFin"),
                        consulta.getString("cursoimp.fechaInicioClase"),
                        consulta.getString("cursoimp.fechaFinClase"),
                        consulta.getString("cic.descripcion"),
                        consulta.getString("au.salon")
                );
                mostrar.add(cursosCiclo);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return mostrar;
    }
}
