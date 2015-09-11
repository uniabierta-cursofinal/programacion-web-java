package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioCliente;
import org.cursofinalgrado.java.petcare.cfg.uapa.servicios.ServicioRaza;

/**
 *
 * @author ecabrerar
 */
public class PacienteBuilder {

    private Integer id;
    private Cliente cliente;
    private String nombre;
    private String genero;
    private Raza raza;
    private LocalDate fechaNacimiento;
    private Integer peso;

    public PacienteBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public PacienteBuilder setCliente(Cliente cliente) {
        this.cliente = cliente;
         return this;
    }

    public PacienteBuilder setNombre(String nombre) {
        this.nombre = nombre;
         return this;
    }

    public PacienteBuilder setGenero(String genero) {
        this.genero = genero;
         return this;
    }

    public PacienteBuilder setRaza(Raza raza) {
        this.raza = raza;
         return this;
    }

    public PacienteBuilder setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
         return this;
    }

    public PacienteBuilder setPeso(Integer peso) {
        this.peso = peso;
         return this;
    }

    public Paciente crearPaciente(){
        return Paciente.crearPaciente(id, cliente, nombre, genero, raza, fechaNacimiento, peso);
    }

    public Paciente crearPaciente(ResultSet rs){

    	Paciente paciente = null;

    	try {

    		Optional<Raza> raza = ServicioRaza.getInstancia().getRazaPorId(rs.getInt("raza_id"));
    		Optional<Cliente> cliente = ServicioCliente.getInstancia().getClientePorId(rs.getInt("cliente_id"));

                  LocalDate fechaNac = rs.getDate("fecha_nacimiento").toLocalDate();
			paciente = Paciente.crearPaciente(rs.getInt("id"), cliente.get(), rs.getString("nombre"), rs.getString("genero"), raza.get(), fechaNac, rs.getInt("peso"));

		} catch (SQLException ex) {
			 Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
		}

        return paciente;
    }

}
