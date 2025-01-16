package bean;

//package bean;

/*
Clase que representa el tipo de roles que existen: estudiante, profesor, director, etc.
*/


public class TipoCuenta {
    
    
    private int idTipoCuenta;
    private String nombreCuenta;
    
    public int getIdTipoCuenta(){
        return idTipoCuenta;
    }
    
    public String getNombreCuenta(){
        return nombreCuenta;
    }
    
    public void setNombreCuenta(String nombreCuenta){
        this.nombreCuenta=nombreCuenta;
    }
    
    public TipoCuenta(String nombreCuenta){
        this.nombreCuenta=nombreCuenta;
    }
    
}
