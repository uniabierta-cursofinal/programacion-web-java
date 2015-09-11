package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.PacienteBuilder;
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
        return consultarTodas("select * from petcare.paciente order by id asc", new PacienteBuilder()::crearPaciente);
    }

    public Optional<Paciente> getPacientePorId(int id) {
        return consultarPorId("select * from petcare.paciente where id=?",
                id,
                new PacienteBuilder()::crearPaciente);
    }

    public void crearPaciente(Paciente paciente) {

        String sql = "INSERT INTO petcare.paciente (cliente_id,nombre,genero,raza_id,fecha_nacimiento,peso,doctor_id) VALUES(?,?,?,?,?,?,?)";

        try (Connection con = getConeccion()) {
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setInt(1, paciente.getCliente().getId());
                pstmt.setString(2, paciente.getNombre());
                pstmt.setString(3, paciente.getGenero());
                pstmt.setInt(4, paciente.getRaza().getId());
                pstmt.setDate(5, (Date) paciente.getFecha_nacimiento());
                pstmt.setInt(6, paciente.getPeso());

                pstmt.execute();

            }
        } catch (SQLException | PetCareException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

    }
    
   public void editarPaciente(Paciente paciente) {

        String sql = "UPDATE petcare.paciente SET cliente_id =?, nombre=?, genero=?, raza_id=?, fecha_nacimiento=?, peso=?, doctor_id=? WHERE id=?";

        try (Connection con = getConeccion()) {
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {

                pstmt.setInt(1, paciente.getCliente().getId());
                pstmt.setString(2, paciente.getNombre());
                pstmt.setString(3, paciente.getGenero());
                pstmt.setInt(4, paciente.getRaza().getId());
                pstmt.setDate(5, (Date) paciente.getFecha_nacimiento());
                pstmt.setInt(6, paciente.getPeso());
                pstmt.setInt(7, paciente.getId());

                pstmt.execute();

            }
        } catch (SQLException | PetCareException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

    }

}
