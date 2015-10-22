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
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Pais;
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
		return consultarTodas("select * from petcare.cliente order by id asc", (rs)->buildCliente(rs));
	}

	public Optional<Cliente> getClientePorId(int id){
	        return  consultarPorId("select * from petcare.cliente where id=?",
	                                id,
	                                (rs)->buildCliente(rs));
	}

	 public Optional<Cliente> validarCliente(String usuario, String pass) {

		 Optional<Cliente> opUsuario = Optional.empty();

	      try(Connection con = getConeccion()){

		        try (PreparedStatement pstmt = con.prepareStatement("select * from petcare.cliente where usuario = ? and clave= ?")) {

		                pstmt.setString(1, usuario);
						pstmt.setString(2, Util.toMD5(pass));


		            try (ResultSet rs = pstmt.executeQuery()) {

		                if (rs.next()) {

		                	opUsuario = Optional.ofNullable(buildCliente(rs));
		                }
		            }
		        }

	        } catch (SQLException | NoSuchAlgorithmException | PetCareException e) {
	            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", e.getMessage()));
	            return opUsuario;
	        }

	        return opUsuario;
	    }

	 public boolean registrarCliente(Cliente cliente){
			String sql= "insert into petcare.cliente (nombre,apellido,telefono,calle,apartamento,ciudad,pais_id,usuario,clave) values (?,?,?,?,?,?,?,?,?)";

			boolean estado;

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

	            	estado = true;

	            }
	        } catch (SQLException | NoSuchAlgorithmException | PetCareException ex) {
	        	estado = false;
	            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
	        }

			return estado;
	 }

    public boolean editarCliente(Cliente cliente){

                 String sql = new StringBuilder(65)
                        .append(" UPDATE petcare.cliente ")
                        .append(" SET ")
                        .append(" nombre = ?, apellido = ?,telefono = ?, calle = ?, ")
                        .append(" apartamento = ?, ciudad = ?, pais_id = ?")
                        .append(" WHERE id = ?")
                        .toString();

           boolean estado;

            try (Connection con = getConeccion()) {
	            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            	pstmt.setString(1, cliente.getNombre());
	            	pstmt.setString(2, cliente.getApellido());
	            	pstmt.setString(3, cliente.getTelefono());
	            	pstmt.setString(4, cliente.getCalle());
	            	pstmt.setString(5, cliente.getApartamento());
	            	pstmt.setString(6, cliente.getCiudad());
	            	pstmt.setInt(7, cliente.getPais().getId());
	            	pstmt.setInt(8, cliente.getId());

	            	pstmt.execute();
	            	estado = true;

	            }
	        } catch (SQLException | PetCareException ex) {
	        	estado = false;
	            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
	        }

		return estado;
	 }

     public boolean cambiarContrasena(Cliente cliente){

                 String sql = new StringBuilder(65)
                        .append(" UPDATE petcare.cliente ")
                        .append(" SET ")
                        .append(" clave = ? ")
                        .append(" WHERE id = ?")
                        .toString();

           boolean estado;

            try (Connection con = getConeccion()) {
	            try (PreparedStatement pstmt = con.prepareStatement(sql)) {

                        pstmt.setString(1, Util.toMD5(cliente.getClave()));
	            	pstmt.setInt(2, cliente.getId());

	            	pstmt.execute();
	            	estado = true;

	            }
	        } catch (SQLException | NoSuchAlgorithmException| PetCareException ex) {
	        	estado = false;
	            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
	        }

		return estado;
	 }

     private Cliente buildCliente(ResultSet rs){

     	Cliente cliente = null;

 		try {
 				Optional<Pais> opPais = ServicioPais.getInstancia().getPaisPorId(rs.getInt("pais_id"));


 				cliente =	new ClienteBuilder()
			 				.setId(rs.getInt("id"))
			 				.setNombre(rs.getString("nombre"))
			 				.setApellido(rs.getString("apellido"))
			 				.setTelefono(rs.getString("telefono"))
			 				.setCalle(rs.getString("calle"))
			 				.setApartamento(rs.getString("apartamento"))
			 				.setCiudad(rs.getString("ciudad"))
			 				.setPais(opPais.get())
			 				.setUsuario(rs.getString("usuario"))
			 				.setClave(rs.getString("clave"))
			 				.crearCliente();


 		} catch (SQLException ex) {
 		    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
 		}

     	return cliente;
     }
}
