package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cliente;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.PacienteBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Raza;
import org.cursofinalgrado.java.petcare.cfg.uapa.utilidades.PetCareException;

/**
 *
 * @author ecabrerar
 */
public class ServicioPaciente extends ServicioPersistenciaBase {

    private static final ServicioPaciente INSTANCIA = new ServicioPaciente();

    private ServicioPaciente() {
    }

    public static ServicioPaciente getInstancia() {
        return INSTANCIA;
    }

    public List<Paciente> getListadoPacientes() {
        return consultarTodas("select * from petcare.paciente order by id asc", (rs)->buildPaciente(rs));
    }

    public Optional<Paciente> getPacientePorId(int id) {
        return consultarPorId("select * from petcare.paciente where id=?",
                id,
                (rs)->buildPaciente(rs));
    }

	public boolean crearPaciente(Paciente paciente){

	       String sql = "INSERT INTO petcare.paciente (cliente_id,nombre,genero,raza_id,fecha_nacimiento,peso) VALUES(?,?,?,?,?,?)";
			boolean estado;

	        try (Connection con = getConeccion()) {
	            try (PreparedStatement pstmt = con.prepareStatement(sql)) {

	                pstmt.setInt(1, paciente.getCliente().getId());
	                pstmt.setString(2, paciente.getNombre());
	                pstmt.setString(3, paciente.getGenero());
	                pstmt.setInt(4, paciente.getRaza().getId());
	                pstmt.setDate(5, Date.valueOf(paciente.getFechaNacimiento()));
	                pstmt.setInt(6, paciente.getPeso());


	                pstmt.execute();
	            	estado = true;

	            }
	        } catch (SQLException | PetCareException ex) {
	        	estado = false;
	            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
	        }

			return estado;
	 }

	public List<Paciente> getPacientesPorClienteId(int idCliente){
		return consultarTodasPorId("select * from petcare.paciente where cliente_id=? order by id asc",
				 idCliente,
				 (rs)->buildPaciente(rs));
	}



    public void editarPaciente(Paciente paciente) {

        String sql = "UPDATE petcare.paciente SET cliente_id =?, nombre=?, genero=?, raza_id=?, fecha_nacimiento=?, peso=? WHERE id=?";

        try (Connection con = getConeccion()) {
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setInt(1, paciente.getCliente().getId());
                pstmt.setString(2, paciente.getNombre());
                pstmt.setString(3, paciente.getGenero());
                pstmt.setInt(4, paciente.getRaza().getId());
                pstmt.setDate(5, Date.valueOf(paciente.getFechaNacimiento()));
                pstmt.setInt(6, paciente.getPeso());
                pstmt.setInt(7, paciente.getId());

                pstmt.execute();

            }
        } catch (SQLException | PetCareException ex) {
            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
        }

    }

    private Paciente buildPaciente(ResultSet rs) throws SQLException{

    		Optional<Raza> raza = ServicioRaza.getInstancia().getRazaPorId(rs.getInt("raza_id"));
    		Optional<Cliente> cliente = ServicioCliente.getInstancia().getClientePorId(rs.getInt("cliente_id"));

             LocalDate fechaNac = rs.getDate("fecha_nacimiento").toLocalDate();

             return new PacienteBuilder()
			                  .setId(rs.getInt("id"))
			                  .setCliente(cliente.get())
			                  .setNombre(rs.getString("nombre"))
			                  .setGenero(rs.getString("genero"))
			                  .setRaza(raza.get())
			                  .setFechaNacimiento(fechaNac)
			                  .setPeso(rs.getInt("peso"))
			                  .crearPaciente();


    }

}
