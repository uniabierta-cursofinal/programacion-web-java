/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.util.List;
import java.util.Optional;

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
        return  consultarTodas("select * from petcare.raza order by id asc", new RazaBuilder()::crearRaza);
    }

    public Optional<Raza> getRazaPorId(int id) {
         return consultarPorId("select * from petcare.raza where id=?", id, new RazaBuilder()::crearRaza);
    }

}
