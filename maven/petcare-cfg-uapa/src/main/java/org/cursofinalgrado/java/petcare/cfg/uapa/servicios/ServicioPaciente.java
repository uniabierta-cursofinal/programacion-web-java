/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.util.List;
import java.util.Optional;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Paciente;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.PacienteBuilder;

/**
 *
 * @author ecabrerar
 */
public class ServicioPaciente extends ServicioPersistenciaBase{

	private static final ServicioPaciente INSTANCIA = new ServicioPaciente();

	private ServicioPaciente() { }

	public static ServicioPaciente getInstancia(){
		return INSTANCIA;
	}

	public List<Paciente> getListadoPacientes(){
		return consultarTodas("select * from petcare.paciente order by id asc", new PacienteBuilder()::crearPaciente);
	}

	public Optional<Paciente> getPacientePorId(int id){
        return  consultarPorId("select * from petcare.paciente where id=?",
                                id,
                                new PacienteBuilder()::crearPaciente);
	}

}
