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
                .setPropiedadesServidorCorreo(new Propiedades("25", true, false),
                        new ServidorSMTP("mail.gruposwat.com", "petcare@gruposwat.com", "pcdemo.2015"))
                .setInformacionParaEnviar(nombre, from, mensaje)
                .enviar();
    }

}

class ServicioCorreo{
    Properties mailServerProperties;
    Session getMailSession;
    MimeMessage generateMailMessage;
   ServidorSMTP smtp;

    ServicioCorreo setPropiedadesServidorCorreo(Propiedades prop, ServidorSMTP smtp){
        // Step1
	System.out.println("\n 1st ===> setup Mail Server Properties..");
	 mailServerProperties = System.getProperties();
	mailServerProperties.put("mail.smtp.port", prop.getPuerto());
	mailServerProperties.put("mail.smtp.auth", prop.isIsAuth());
	mailServerProperties.put("mail.smtp.starttls.enable", prop.isIsSSL());
	System.out.println("Mail Server Properties have been setup successfully..");

        this.smtp = smtp;

        return this;
    }

   ServicioCorreo setInformacionParaEnviar(String nombre, String from, String mensaje){

        // Step2
	System.out.println("\n\n 2nd ===> get Mail Session..");
	getMailSession = Session.getDefaultInstance(mailServerProperties, null);
	generateMailMessage = new MimeMessage(getMailSession);

        try {


        	generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(smtp.getMailID()));
            generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(from));
            generateMailMessage.setSubject(String.join(" ", "Mensaje formulario de contacto petcame from:",nombre));
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

            transport.connect(smtp.getHost(), smtp.getMailID(), smtp.getPassword());
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


class Propiedades {
    private final String puerto;
    private final boolean isAuth;
    private final boolean isSSL;

    public Propiedades(String puerto, boolean isAuth, boolean isSSL) {
        this.puerto = puerto;
        this.isAuth = isAuth;
        this.isSSL = isSSL;
    }

    public String getPuerto() {
        return puerto;
    }

    public boolean isIsAuth() {
        return isAuth;
    }

    public boolean isIsSSL() {
        return isSSL;
    }
}


class ServidorSMTP {
    private final String host;
    private final String mailID;
    private final String password;

    public ServidorSMTP(String host, String mailID, String password) {
        this.host = host;
        this.mailID = mailID;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public String getMailID() {
        return mailID;
    }

    public String getPassword() {
        return password;
    }

}