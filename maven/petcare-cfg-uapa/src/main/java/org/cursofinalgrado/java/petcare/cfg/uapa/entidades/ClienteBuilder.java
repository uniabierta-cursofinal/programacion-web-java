package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPais;

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

    public Cliente creaCliente(ResultSet rs){

    	Cliente cliente = null;

    	Optional<Pais> pais;

		try {
				pais = ServicioPais.getInstancia().getPaisPorId(rs.getInt("pais_id"));
				cliente = Cliente.crearCliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("calle"), rs.getString("apartamento"), rs.getString("ciudad"), pais.get(), rs.getString("usuario"), rs.getString("clave"));

		} catch (SQLException ex) {
			 Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		}


    	return cliente;
    }

}
