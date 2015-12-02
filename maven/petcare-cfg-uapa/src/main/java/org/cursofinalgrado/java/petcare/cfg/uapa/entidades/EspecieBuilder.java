package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;


/**
 *
 * @author ecabrerar
 */
public class EspecieBuilder {

    private Integer id;
    private String nombre;

    public EspecieBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public EspecieBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Especie crearEspecie() {
        return Especie.crearEspecie(id, nombre);
    }

}
