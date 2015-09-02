package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

/**
 *
 * @author ecabrerar
 */
public class Cliente {

    private Integer id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String calle;
    private String apartamento;
    private String ciudad;
    private Pais pais;
    private String usuario;
    private String clave;

    private Cliente(Integer id, String nombre, String apellido, String telefono, String calle, String apartamento, String ciudad, Pais pais, String usuario, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.calle = calle;
        this.apartamento = apartamento;
        this.ciudad = ciudad;
        this.pais = pais;
        this.usuario = usuario;
        this.clave = clave;
    }
    
    static Cliente crearCliente(Integer id, String nombre, String apellido, String telefono, String calle, String apartamento, String ciudad, Pais pais, String usuario, String clave){
        return new Cliente(id, nombre, apellido, telefono, calle, apartamento, ciudad, pais, usuario, clave);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
