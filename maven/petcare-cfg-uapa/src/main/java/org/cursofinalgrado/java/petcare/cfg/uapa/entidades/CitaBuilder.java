package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioDoctor;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioPaciente;

/**
 *
 * @author ecabrerar
 */
public class CitaBuilder {

    private Integer id;
    private LocalDateTime fecha;
    private Paciente paciente;
    private Doctor doctor;
    private String razon;

    public CitaBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public CitaBuilder setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public CitaBuilder setPaciente(Paciente paciente) {
        this.paciente = paciente;
        return this;
    }

    public CitaBuilder setDoctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    public CitaBuilder setRazon(String razon) {
        this.razon = razon;
        return this;
    }

    public Cita crearCita() {
        return Cita.crearCita(id, fecha, paciente, doctor, razon);
    }

    public Cita crearCita(ResultSet rs) {

    	Cita cita = null;

    	try {

    		Optional<Paciente> paciente = ServicioPaciente.getInstancia().getPacientePorId(rs.getInt("paciente_id"));
    		Optional<Doctor> doctor = ServicioDoctor.getInstancia().getDoctorPorId(rs.getInt("doctor_id"));

                LocalDateTime fechaCita = rs.getTimestamp("fecha").toLocalDateTime();

			cita = Cita.crearCita(rs.getInt("id"), fechaCita, paciente.get(), doctor.get(), rs.getString("razon"));
		} catch (SQLException ex) {
			 Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		}

        return cita;
    }


}
