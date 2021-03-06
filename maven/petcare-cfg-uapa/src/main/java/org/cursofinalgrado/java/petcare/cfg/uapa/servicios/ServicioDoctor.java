package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Doctor;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.DoctorBuilder;
import org.cursofinalgrado.java.petcare.cfg.uapa.utilidades.PetCareException;

/**
 *
 * @author ecabrerar
 */
public class ServicioDoctor extends ServicioPersistenciaBase {

    private static final ServicioDoctor INSTANCIA = new ServicioDoctor();

    private ServicioDoctor() {
    }

    public static ServicioDoctor getInstancia() {
        return INSTANCIA;
    }

    public List<Doctor> getListadoDoctores() {
        return consultarTodas("select * from petcare.doctor order by id asc", (rs)->BuildDoctor(rs));

    }

    public Optional<Doctor> getDoctorPorId(int id) {
        return consultarPorId("select * from petcare.doctor where id=?",
                id,
                (rs)->BuildDoctor(rs));
    }

    public boolean registrarDoctor(Doctor doctor) {

        String sql = "INSERT INTO petcare.doctor (nombre,apellido) VALUES(?,?)";
        boolean estado;

        try (Connection con = getConeccion()) {
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, doctor.getNombre());
                pstmt.setString(2, doctor.getApellido());
                pstmt.execute();

                estado = true;

            }
        } catch (SQLException | PetCareException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            estado = false;
        }

       	return estado;
     }

    public boolean editarDoctor(Doctor doctor) {

        String sql = "UPDATE petcare.doctor SET nombre = ?,apellido = ? WHERE id = ?";
        boolean estado;

        try (Connection con = getConeccion()) {
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, doctor.getNombre());
                pstmt.setString(2, doctor.getApellido());
                pstmt.setInt(3, doctor.getId());
                pstmt.execute();

            	estado = true;

            }
        } catch (SQLException | PetCareException ex) {
        	estado = false;
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

		return estado;

    }

    private Doctor BuildDoctor(ResultSet rs) throws SQLException {

    	return new DoctorBuilder()
						.setId(rs.getInt("id"))
						.setNombre(rs.getString("nombre"))
						.setApellido(rs.getString("apellido"))
						.crearDoctor();


    }

}
