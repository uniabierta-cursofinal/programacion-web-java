package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

/**
 *
 * @author ecabrerar
 */
public class Especie {
    private Integer id;
    private String nombre;

    private Especie(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    static Especie crearEspecie(Integer id, String nombre){
        return new Especie(id, nombre);
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
