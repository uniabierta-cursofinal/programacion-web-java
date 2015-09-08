package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.util.List;
import java.util.Optional;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Doctor;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.DoctorBuilder;

/**
 *
 * @author ecabrerar
 */
public class ServicioDoctor extends ServicioPersistenciaBase{

	private static ServicioDoctor INSTANCIA = new ServicioDoctor();

	private ServicioDoctor() { 	}

	public static ServicioDoctor getInstancia(){
		return INSTANCIA;
	}

	public List<Doctor> getListadoDoctores(){
		return consultarTodas("select * from petcare.doctor order by id asc", new DoctorBuilder()::crearDoctor);

	}

	public Optional<Doctor> getDoctorPorId(int id){
        return  consultarPorId("select * from petcare.doctor where id=?",
                                id,
                                new DoctorBuilder()::crearDoctor);
	}


}
