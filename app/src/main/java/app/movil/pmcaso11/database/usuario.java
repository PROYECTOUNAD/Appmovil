package app.movil.pmcaso11.database;

public class usuario {

    private int idDocumento;
    private int tipoDocumento;
    private String nombreUsuario;
    private String apellidoUsuario;
    private int idCiudad;
    private int idPais;
    private int idRol;
    private String direcUsuario;
    private String emailUsuario;
    private String telefonoUsuario;
    private String passUsuario;


    public usuario(int idDocumento, int tipoDocumento, String nombreUsuario, String apellidoUsuario, int idCiudad, int idPais, int idRol, String direcUsuario, String emailUsuario, String telefonoUsuario, String passUsuario) {
        this.idDocumento = idDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.idCiudad = idCiudad;
        this.idPais = idPais;
        this.idRol = idRol;
        this.direcUsuario = direcUsuario;
        this.emailUsuario = emailUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.passUsuario = passUsuario;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public int getIdPais() {
        return idPais;
    }

    public int getIdRol() {
        return idRol;
    }

    public String getDirecUsuario() {
        return direcUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public void setDirecUsuario(String direcUsuario) {
        this.direcUsuario = direcUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }
}
