/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cursofinalgrado.java.petcare.cfg.uapa.servicios;

/**
 *
 * @author ecabrerar
 */
public class ServicioCita extends ServicioPersistenciaBase{
    
    private static final ServicioCita INSTANCIA = new ServicioCita();

    private ServicioCita() {   }
    
    public static ServicioCita getInstancia(){
        return INSTANCIA;
    }
    
    
    
}
