/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ecabrerar
 */
public abstract class ServicioPersistenciaBase {

    protected Connection getConeccion() {

        Context ctx;

        try {

            ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/PetCare");

            try (Connection con = ds.getConnection()) {
                Logger.getLogger(getClass().getName()).info(String.format("Connection established !!!"));
                return con;
            }

        } catch (NamingException | SQLException ex) {
            Logger.getLogger(ServicioPersistenciaBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public <T> List<T> consultarTodas(String sql, Function<ResultSet,T> function) {

        final List<T> list = new ArrayList<>();
        try (Connection con = getConeccion()) {
            try (Statement stmt = con.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {

                        list.add(function.apply(rs));
                    }
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public <T> Optional<T> consultarPorId(String sql, Integer idEntidad, Function<ResultSet, T> function) {

        T entidad = null ;
        try (Connection con = getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, idEntidad);

                try (ResultSet rs = stmt.executeQuery(sql)) {

                      rs.next();
                      entidad =  function.apply(rs);
                }
            }
        } catch (SQLException ex) {           
            Logger.getLogger(ServicioPersistenciaBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Optional.of(entidad);

    }
}
