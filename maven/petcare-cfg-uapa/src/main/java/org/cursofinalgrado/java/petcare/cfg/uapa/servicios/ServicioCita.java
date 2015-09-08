package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.util.List;
import java.util.Optional;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Cita;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.CitaBuilder;

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


}
