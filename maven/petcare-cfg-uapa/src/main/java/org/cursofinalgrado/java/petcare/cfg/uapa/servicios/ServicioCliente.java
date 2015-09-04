package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cliente;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.ClienteBuilder;

/**
 *
 * @author ecabrerar
 */
public class ServicioCliente extends ServicioPersistenciaBase{

	private static final ServicioCliente INSTANCIA = new ServicioCliente();

	private ServicioCliente() { 	}

	public static ServicioCliente getInstancia(){
		return INSTANCIA;
	}

	public List<Cliente> getListadoClientes(){
		return consultarTodas("select * from petcare.cliente order by id asc", new ClienteBuilder()::creaCliente);
	}

	public Optional<Cliente> getClientePorId(int id){
	        return  consultarPorId("select * from petcare.cliente where id=?",
	                                id,
	                                new ClienteBuilder()::creaCliente);
	}

	 public Optional<Cliente> validarCliente(String usuario, String pass) {

		 Optional<Cliente> opUsuario = Optional.empty();

	      try(Connection con = getConeccion()){

		        try (PreparedStatement pstmt = con.prepareStatement("select * from petcare.cliente where usuario = ? and clave= ?")) {

		            pstmt.setString(1, usuario);
		            pstmt.setString(2, pass);

		            try (ResultSet rs = pstmt.executeQuery()) {

		                if (rs.next()) {

		                	opUsuario = Optional.ofNullable(new ClienteBuilder().creaCliente(rs));
		                }
		            }
		        }

	        } catch (SQLException e) {
	            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", e.getMessage()));
	            return opUsuario;
	        }

	        return opUsuario;
	    }
}
