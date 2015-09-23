package org.cursofinalgrado.java.petcare.cfg.uapa.utilidades.correo;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ecabrerar
 */
public class ManejadorCorreo {
    private static final ManejadorCorreo INSTANCIA = new ManejadorCorreo();

    private ManejadorCorreo() {   }

    public static ManejadorCorreo getInstancia(){
        return INSTANCIA;
    }

    public void enviarCorreo(String nombre, String from, String mensaje) throws MessagingException{

        new ServicioCorreo()
                .setPropiedadesServidorCorreo(new Credenciales(true, false))
                .setInformacionParaEnviar(nombre, from, mensaje)
                .enviar();
    }

}

class ServicioCorreo{
    Properties mailServerProperties;
    Session getMailSession;
    MimeMessage generateMailMessage;
    Credenciales creds;

    ServicioCorreo setPropiedadesServidorCorreo(Credenciales creds){
        // Step1
	System.out.println("\n 1st ===> setup Mail Server Properties..");

	this.creds = creds;

	 mailServerProperties = System.getProperties();
	mailServerProperties.put("mail.smtp.port", creds.getPuerto());
	mailServerProperties.put("mail.smtp.auth", creds.isAuth());
	mailServerProperties.put("mail.smtp.starttls.enable", creds.isSSL());
	System.out.println("Mail Server Properties have been setup successfully..");


        return this;
    }

   ServicioCorreo setInformacionParaEnviar(String nombre, String from, String mensaje){

        // Step2
	System.out.println("\n\n 2nd ===> get Mail Session..");
	getMailSession = Session.getDefaultInstance(mailServerProperties, null);
	generateMailMessage = new MimeMessage(getMailSession);

        try {


        	generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(creds.getMailID()));
            generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(from));
            generateMailMessage.setSubject(String.join(" ", "Mensaje formulario de contacto petcare from:",nombre));
            generateMailMessage.setContent(mensaje, "text/html");

        } catch (MessagingException ex) {
            Logger.getLogger(ServicioCorreo.class.getName()).log(Level.SEVERE, null, ex);
        }

	System.out.println("Mail Session has been created successfully..");


       return this;
    }


   private  ServicioCorreo setInformacionServidorSMTP() {

    // Step3
    System.out.println("\n\n 3rd ===> Get Session and Send mail");
     // if you have 2FA enabled then provide App Specific Password
    // Enter your correct email UserID and Password
         Transport transport = null;

        try {

             transport = getMailSession.getTransport("smtp");

            transport.connect(creds.getHost(), creds.getMailID(), creds.getPassword());
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());

        } catch (MessagingException ex) {
            Logger.getLogger(ServicioCorreo.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(null !=transport){
                try {
                    transport.close();
                } catch (MessagingException ex) {
                    Logger.getLogger(ServicioCorreo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return this;
    }

    ServicioCorreo enviar() throws MessagingException {
        return setInformacionServidorSMTP();
    }

}