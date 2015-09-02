/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

/**
 *
 * @author ecabrerar
 */
public class ClienteBuilder {

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

    public ClienteBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public ClienteBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClienteBuilder setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public ClienteBuilder setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ClienteBuilder setCalle(String calle) {
        this.calle = calle;
        return this;
    }

    public ClienteBuilder setApartamento(String apartamento) {
        this.apartamento = apartamento;
        return this;
    }

    public ClienteBuilder setCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public ClienteBuilder setPais(Pais pais) {
        this.pais = pais;
        return this;
    }

    public ClienteBuilder setUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public ClienteBuilder setClave(String clave) {
        this.clave = clave;
        return this;
    }

    public Cliente crearCliente() {
        return Cliente.crearCliente(id, nombre, apellido, telefono, calle, apartamento, ciudad, pais, usuario, clave);
    }
}
