package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cliente;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.ClienteBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.utilidades.PetCareException;
import org.cursofinalgrado.java.petcare.cfg.uapa.utilidades.Util;

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

	        } catch (SQLException | PetCareException e) {
	            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", e.getMessage()));
	            return opUsuario;
	        }

	        return opUsuario;
	    }

	 public void registrarCliente(Cliente cliente){
			String sql= "";

			try (Connection con = getConeccion()) {
	            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            	pstmt.setString(1, cliente.getNombre());
	            	pstmt.setString(2, cliente.getApellido());
	            	pstmt.setString(3, cliente.getTelefono());
	            	pstmt.setString(4, cliente.getCalle());
	            	pstmt.setString(5, cliente.getApartamento());
	            	pstmt.setString(6, cliente.getCiudad());
	            	pstmt.setInt(7, cliente.getPais().getId());
	            	pstmt.setString(8, cliente.getUsuario());

					pstmt.setString(9, Util.toMD5(cliente.getClave()));

	            	pstmt.execute();

	            }
	        } catch (SQLException | NoSuchAlgorithmException | PetCareException ex) {
	            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
	        }
	 }
         
         public void editarCliente(Cliente cliente){
			
                 String sql = new StringBuilder(65)
                        .append(" UPDATE petcare.cliente ")
                        .append(" SET ")
                        .append(" nombre = ?,apellido = ?,telefono = ?,calle = ?, ")
                        .append(" apartamento = ?,ciudad = ?,pais_id = ?,usuario = ?,")
                        .append(" clave = ? ")
                        .append(" WHERE id = ?")
                        .toString();
            
            try (Connection con = getConeccion()) {
	            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            	pstmt.setString(1, cliente.getNombre());
	            	pstmt.setString(2, cliente.getApellido());
	            	pstmt.setString(3, cliente.getTelefono());
	            	pstmt.setString(4, cliente.getCalle());
	            	pstmt.setString(5, cliente.getApartamento());
	            	pstmt.setString(6, cliente.getCiudad());
	            	pstmt.setInt(7, cliente.getPais().getId());
	            	pstmt.setString(8, cliente.getUsuario());
                        pstmt.setInt(9, cliente.getId());

	            	pstmt.execute();

	            }
	        } catch (SQLException | PetCareException ex) {
	            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
	        }
	 }
}
