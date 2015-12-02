package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;


/**
 *
 * @author ecabrerar
 */
public class DoctorBuilder {

    private Integer id;
    private String nombre;
    private String apellido;

    public DoctorBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public DoctorBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DoctorBuilder setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Doctor crearDoctor() {
        return Doctor.crearDoctor(id, nombre, apellido);
    }


}
