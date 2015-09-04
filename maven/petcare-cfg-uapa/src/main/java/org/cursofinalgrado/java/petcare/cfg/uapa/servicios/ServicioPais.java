/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.util.List;
import java.util.Optional;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.Pais;
import org.cursofinalgrado.java.petcare.cfg.uapa.entidades.PaisBuilder;

/**
 *
 * @author ecabrerar
 */
public class ServicioPais extends ServicioPersistenciaBase {

    private final static ServicioPais INSTANCIA = new ServicioPais();

    private ServicioPais() {    }

    public static ServicioPais getInstancia() {
        return INSTANCIA;
    }

    public List<Pais> getListadoPais() {

        return consultarTodas("select * from petcare.pais order by id asc", new PaisBuilder()::crearPais);
    }

    public Optional<Pais> getPaisPorId(int id) {

        return consultarPorId("select * from pais where codigo_pais=?",
                id,
                new PaisBuilder()::crearPais);

    }
}
