package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Especie;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Raza;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.RazaBuilder;

/**
 *
 * @author ecabrerar
 */
public class ServicioRaza extends ServicioPersistenciaBase{

    private static final ServicioRaza INSTANCIA = new ServicioRaza();

    private ServicioRaza() {    }

    public static ServicioRaza getInstancia(){
        return INSTANCIA;
    }

    public List<Raza> getListadoRaza() {
        return  consultarTodas("select * from petcare.raza order by id asc", (rs)->buildRaza(rs));
    }

    public Optional<Raza> getRazaPorId(int id) {
         return consultarPorId("select * from petcare.raza where id=? ", id, (rs)->buildRaza(rs));
    }


    private Raza buildRaza(ResultSet rs){

        Raza raza = null;

        try {

        	Optional<Especie> opEspecie = ServicioEspecie.getInstancia().getEspeciePorId(rs.getInt("especie_id"));

            raza =  new RazaBuilder()
        	.setId(rs.getInt("id"))
        	.setNombre(rs.getString("nombre"))
        	.setEspecie(opEspecie.get())
        	.crearRaza();

        } catch (SQLException ex) {
            Logger.getLogger(RazaBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }

        return raza;
    }

}
