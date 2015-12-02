package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cita;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.CitaBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Doctor;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente;
import org.cursofinalgrado.java.petcare.cfg.uapa.utilidades.PetCareException;

/**
 *
 * @author ecabrerar
 */
public class ServicioCita extends ServicioPersistenciaBase {

    private static final ServicioCita INSTANCIA = new ServicioCita();

    private ServicioCita() {
    }

    public static ServicioCita getInstancia() {
        return INSTANCIA;
    }

    public List<Cita> getListadoCitas() {
        return consultarTodas("select * from petcare.cita order by id asc", (rs)->BuildCita(rs));
    }

    public Optional<Cita> getCitaPorId(int id) {
        return consultarPorId("select * from petcare.cita where id=?",
                id,
                (rs)->BuildCita(rs));
    }

    public boolean registrarCita(Cita cita) {

        String sql = "INSERT INTO petcare.cita(fecha,paciente_id,doctor_id,razon) VALUES (?,?,?,?)";

        boolean estado;

        try (Connection con = getConeccion()) {
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setTimestamp(1, Timestamp.valueOf(cita.getFecha()));
                pstmt.setInt(2, cita.getPaciente().getId());
                pstmt.setInt(3, cita.getDoctor().getId());
                pstmt.setString(4, cita.getRazon());

                pstmt.execute();
                estado = true;

            }
        } catch (SQLException | PetCareException ex) {
        	 estado = false;
            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
        }

        return estado;
    }

    public void editarCita(Cita cita) {
        String sql = "UPDATE petcare.cita SET fecha = ?,paciente_id = ?,doctor_id = ?,razon = ? WHERE id = ?";

        try (Connection con = getConeccion()) {
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setTimestamp(1, Timestamp.valueOf(cita.getFecha()));
                pstmt.setInt(2, cita.getPaciente().getId());
                pstmt.setInt(3, cita.getDoctor().getId());
                pstmt.setString(4, cita.getRazon());
                pstmt.setInt(5, cita.getId());

                pstmt.execute();

            }
        } catch (SQLException | PetCareException ex) {
            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
        }

    }

    private Cita BuildCita(ResultSet rs) {

    	Cita cita = null;

    	try {

    		Optional<Paciente> paciente = ServicioPaciente.getInstancia().getPacientePorId(rs.getInt("paciente_id"));
    		Optional<Doctor> doctor = ServicioDoctor.getInstancia().getDoctorPorId(rs.getInt("doctor_id"));

                LocalDateTime fechaCita = rs.getTimestamp("fecha").toLocalDateTime();

            	cita =  new CitaBuilder()
	                .setId(rs.getInt("id"))
	                .setFecha(fechaCita)
	                .setPaciente(paciente.get())
	                .setDoctor(doctor.get())
	                .setRazon(rs.getString("razon"))
	                .crearCita();

		} catch (SQLException ex) {
			 Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		}

        return cita;
    }


}
