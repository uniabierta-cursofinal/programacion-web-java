package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

/**
 *
 * @author ecabrerar
 */
public class Pais {
    private Integer id;
    private String descripcion;

    private Pais(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    static Pais crearPais(Integer id, String descripcion){
        return new Pais(id, descripcion);
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
