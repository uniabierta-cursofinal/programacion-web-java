/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.uapa.java.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cursofinalgrado.uapa.java.entidades.Categoria;

/**
 *
 * @author ecabrerar
 */
public class ModeloCategoria {

    private static final ModeloCategoria INSTANCIA = new ModeloCategoria();

    public static ModeloCategoria getInstancia() {
        return INSTANCIA;
    }

    private ModeloCategoria() {
    }

    public boolean crearCategoria(Categoria categoria) {

        boolean estado;

        String sql = "insert into categorias(descripcion) values(?)";

        try (Connection con = Coneccion.getInstancia().getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement(sql)) {

                stmt.setString(1, categoria.getDescripcion());

                stmt.executeUpdate();

                estado = true;
            }

        } catch (SQLException e) {
            estado = false;
            Logger.getLogger(ModeloCategoria.class.getName()).log(Level.SEVERE, null, e);
        }

        return estado;

    }

    public boolean actualizarCategoria(Categoria categoria) {
        boolean estado;

        String sql = "update categorias set descripcion=? where codigo_categoria=?";

        try (Connection con = Coneccion.getInstancia().getConeccion()) {

            try (PreparedStatement stmt = con.prepareStatement(sql)) {

                stmt.setString(1, categoria.getDescripcion());
                stmt.setInt(2, categoria.getId());

                stmt.executeUpdate();

                estado = true;
            }

        } catch (SQLException e) {
            estado = false;
            Logger.getLogger(ModeloCategoria.class.getName()).log(Level.SEVERE, null, e);
        }

        return estado;

    }

    public List<Categoria> getListadoCategorias() {

        List<Categoria> lista = new ArrayList<>();

        String sql = "select * from categorias";

        try (Connection con = Coneccion.getInstancia().getConeccion()) {

            try (Statement stmt = con.createStatement()) {

                try (ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {
                        Categoria categoria = new Categoria();
                        categoria.setId(rs.getInt("codigo_categoria"));
                        categoria.setDescripcion(rs.getString("descripcion"));

                        lista.add(categoria);
                    }
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(ModeloCategoria.class.getName()).log(Level.SEVERE, null, e);
        }

        return lista;
    }

    public Categoria getCategoriaPorId(int idCategoria) {

        String sql = "select * from categorias where codigo_categoria=?";

        Categoria categoria = null;
        
        try (Connection con = Coneccion.getInstancia().getConeccion()) {

            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, idCategoria);

                try (ResultSet rs = pstmt.executeQuery()) {

                    rs.next();
                    categoria = new Categoria();
                    categoria.setId(rs.getInt("codigo_categoria"));
                    categoria.setDescripcion(rs.getString("descripcion"));

                }
            }
        } catch (SQLException e) {
            Logger.getLogger(ModeloCategoria.class.getName()).log(Level.SEVERE, null, e);
        }

        return categoria;
    }

}
