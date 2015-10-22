package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;


/**
 *
 * @author ecabrerar
 */
public class RazaBuilder {
    private Integer id;
    private String nombre;
    private Especie especie;

    /**
     * @param id the id to set
     * @return
     */
    public RazaBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * @param nombre the nombre to set
     * @return
     */
    public RazaBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * @param especie the especie to set
     * @return
     */
    public RazaBuilder setEspecie(Especie especie) {
        this.especie = especie;
        return this;
    }

    public Raza crearRaza(){
        return Raza.crearRaza(id, nombre, especie);
    }

}
