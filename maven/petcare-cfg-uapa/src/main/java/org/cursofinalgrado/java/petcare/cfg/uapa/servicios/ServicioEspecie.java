package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.util.List;
import java.util.Optional;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Especie;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.EspecieBuilder;

/**
 *
 * @author ecabrerar
 */
public class ServicioEspecie extends ServicioPersistenciaBase{

    private final static ServicioEspecie INSTANCIA = new ServicioEspecie();

    private ServicioEspecie() {   }

    public static ServicioEspecie getInstancia(){
        return INSTANCIA;
    }

    public List<Especie> getListadoEspecie() {
       return consultarTodas("select * from petcare.especie order by id asc", new EspecieBuilder()::crearEspecie);
    }

    public Optional<Especie> getEspeciePorId(int id){
      return  consultarPorId("select * from petcare.especie where id=?",
                              id,
                              new EspecieBuilder()::crearEspecie);
    }

}
