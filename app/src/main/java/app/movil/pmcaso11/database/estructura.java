package app.movil.pmcaso11.database;




public class estructura {


    public static final String TABLA_USUARIO="usuario";
    public static final String ID_DOCUMENTO="IdDocumento";
    public static final String TIPO_DOCUMENTO="tipoDocumento";
    public static final String NOMBRE_USUARIO="nombreUsuario";
    public static final String APELLIDO_USUARIO="apellidoUsuario";
    public static final String CIUDAD="ciudadUsuario";
    public static final String PAIS="paisUsuario";
    public static final String IDROL="rolUsuario";
    public static final String DIRECCION_USUARIO="direcUsuario";
    public static final String EMAIL_USUARIO="emailUsuario";
    public static final String TELEFONO_USUARIO="telefonoUsuario";
    public static final String PASS_USUARIO="passUsuario";




    public static final String CREAR_TABLA_USUARIO="create table"+TABLA_USUARIO+"("+ID_DOCUMENTO+"integer primary key,"+TIPO_DOCUMENTO+" text,"+NOMBRE_USUARIO+" text," +
            ""+APELLIDO_USUARIO+" text,"+CIUDAD+" text,"+PAIS+" text,"+IDROL+" integer,"+DIRECCION_USUARIO+" text,"+EMAIL_USUARIO+" text,"+TELEFONO_USUARIO+" integer, "+PASS_USUARIO+" text)";



        /*
            "foreign key (idRol) references rol (idRol),"
            "foreign key(tipoDocumento)references documento(idDocumento)," +
            "foreign key (idCiudad) references ciudad(idCiudad)," +
            "foreign key (idPais) references pais(idPais))"*/





}
