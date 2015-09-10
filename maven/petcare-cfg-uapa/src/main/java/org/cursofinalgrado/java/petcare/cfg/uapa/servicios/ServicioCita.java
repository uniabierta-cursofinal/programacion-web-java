package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cita;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.CitaBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.utilidades.PetCareException;

/**
 *
 * @author ecabrerar
 */
public class ServicioCita extends ServicioPersistenciaBase{

    private static final ServicioCita INSTANCIA = new ServicioCita();

    private ServicioCita() {   }

    public static ServicioCita getInstancia(){
        return INSTANCIA;
    }

    public List<Cita> getListadoCitas(){
    	return consultarTodas("select * from petcare.cita order by id asc", new CitaBuilder()::crearCita);
    }

    public Optional<Cita> getCitaPorId(int id){
        return  consultarPorId("select * from petcare.cita where id=?",
                                id,
                                new CitaBuilder()::crearCita);
    }

    public List<Cita> getCitasPorPacienteId(int idPaciente){
		return consultarTodasPorId("select * from petcare.cita where paciente_id=?",
									idPaciente,
									new CitaBuilder()::crearCita);

    }

    public List<Cita> getCitasPorDoctorId(int idDoctor){
		return consultarTodasPorId("select * from petcare.cita where doctor_id=?",
									idDoctor,
									new CitaBuilder()::crearCita);
    }

    public boolean registrarCita(Cita cita) {

    	String sql= "";

    	boolean estado;

		try (Connection con = getConeccion()) {
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {

	            	pstmt.setDate(1, (Date) cita.getFecha());
	            	pstmt.setInt(2, cita.getPaciente().getId());
	            	pstmt.setInt(3, cita.getDoctor().getId());
	            	pstmt.setString(4, cita.getRazon());

            	pstmt.execute();

            	estado = true;

            }
        } catch (SQLException | PetCareException ex) {
        	estado = false;
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

		return estado;
	}

}
