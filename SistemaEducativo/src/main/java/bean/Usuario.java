package bean;


import java.util.Date;


/**
 *
 * @author santoslopeztzoy
 */
public class Usuario {
    
    private int idUsuario;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String correo;
    private String username;
    private String password;
    private Date fechaRegistro;
    private String carnet;
    private String foto;
    private String estado;
    private int idTipoUsuario;

    public Usuario(){}

    public Usuario(String correo, String username,String password,String estado, int idTipoUsuario) {
        this.correo = correo;
        this.username = username;
        this.password = password;
        this.estado = estado;
        this.idTipoUsuario = idTipoUsuario;
    }
    
    
    public Usuario(int idUsuario, String nombres, String apellidos, Date fechaNacimiento, String correo, String username, String password, Date fechaRegistro, String carnet, String foto, String estado, int idTipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.username = username;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
        this.carnet = carnet;
        this.foto = foto;
        this.estado = estado;
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    /*public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }*/

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
    
    
    
}
