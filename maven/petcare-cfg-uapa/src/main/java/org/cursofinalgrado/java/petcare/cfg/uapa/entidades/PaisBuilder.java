package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;


/**
 *
 * @author ecabrerar
 */
public class PaisBuilder {

    private Integer id;
    private String descripcion;

    public PaisBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public PaisBuilder setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Pais crearPais() {
        return Pais.crearPais(id, descripcion);
    }

}
