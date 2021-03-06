package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.cursofinalgrado.java.petcare.cfg.uapa.utilidades.FunctionCE;
import org.cursofinalgrado.java.petcare.cfg.uapa.utilidades.PetCareException;

/**
 *
 * @author ecabrerar
 */
public abstract class ServicioPersistenciaBase {

    protected Connection getConeccion() throws PetCareException {

    	Connection con = null;
        try {

	        	  Context ctx = new InitialContext();
	              DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/PetCare");

	              con = ds.getConnection();

	              if(con==null){
	            	  throw new PetCareException("No pudo establecer conexion con la base de datos");
	              }

	              Logger.getLogger(getClass().getName()).info(String.format("Connection established !!!"));


        } catch (NamingException | SQLException ex) {
            Logger.getLogger(ServicioPersistenciaBase.class.getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
        }

        return con;
    }

    protected <T, X extends Exception> List<T> consultarTodas(String sql, FunctionCE<ResultSet,T, X> function) {

        final List<T> list = new ArrayList<>();
        try (Connection con = getConeccion()) {
            try (Statement stmt = con.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {

                        list.add(function.apply(rs));
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
        }

        return list;
    }

    protected <T, X extends Exception> List<T> consultarTodasPaginacion(String sql, int offset, int noOfRecords,  FunctionCE<ResultSet,T, X> function) {

        final List<T> list = new ArrayList<>();
        try (Connection con = getConeccion()) {
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, offset);
                pstmt.setInt(2, noOfRecords);

                try (ResultSet rs = pstmt.executeQuery(sql)) {

                    while (rs.next()) {

                        list.add(function.apply(rs));
                    }
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
        }

        return list;
    }

    protected <T, X extends Exception> List<T> consultarTodasPorId(String sql, Integer idEntidad,  FunctionCE<ResultSet,T, X> function) {

    	 final List<T> list = new ArrayList<>();

    	 try (Connection con = getConeccion()) {

             try (PreparedStatement stmt = con.prepareStatement(sql)) {
            	 	stmt.setInt(1, idEntidad);

                 try (ResultSet rs = stmt.executeQuery()) {

                     while (rs.next()) {

                         list.add(function.apply(rs));
                     }
                 }
             }
         } catch (Exception ex) {
        	 Logger.getLogger(ServicioPersistenciaBase.class.getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
         }

        return list;
    }

    protected <T, X extends Exception> Optional<T> consultarPorId(String sql, Integer idEntidad,  FunctionCE<ResultSet,T, X> function) {

       Optional<T> opEntidad = Optional.empty();

        try (Connection con = getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, idEntidad);

                try (ResultSet rs = stmt.executeQuery()) {

                      rs.next();
                      opEntidad  =  Optional.of(function.apply(rs));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ServicioPersistenciaBase.class.getName()).info(MessageFormat.format("Error en el SQl{0}", ex.getMessage()));
            return opEntidad;
        }

        return opEntidad;

    }
}
