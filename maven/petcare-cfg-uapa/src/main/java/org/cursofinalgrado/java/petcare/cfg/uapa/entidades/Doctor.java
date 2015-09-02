package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

/**
 *
 * @author ecabrerar
 */
public class Doctor {
    private Integer id;
    private String nombre;
    private String apellido;

    private Doctor(Integer id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
    static Doctor crearDoctor(Integer id, String nombre, String apellido){
        return new Doctor(id, nombre, apellido);
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
}
