package org.cursofinalgrado.java.petcare.cfg.uapa.entidades;

import java.util.Date;

/**
 *
 * @author ecabrerar
 */
public class Cita {
   private Integer id;
   private Date fecha;
   private Paciente paciente;
   private Doctor doctor;
   private String razon;

    private Cita(Integer id, Date fecha, Paciente paciente, Doctor doctor, String razon) {
        this.id = id;
        this.fecha = fecha;
        this.paciente = paciente;
        this.doctor = doctor;
        this.razon = razon;
    }
   
   static Cita crearCita(Integer id, Date fecha, Paciente paciente, Doctor doctor, String razon){
       return new Cita(id, fecha, paciente, doctor, razon);
   }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
   
   
}
