package org.cursofinalgrado.java.petcare.cfg.uapa.utilidades.correo;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ecabrerar
 */
public class Credenciales {

	private String host;
	private String puerto;
	private final boolean isAuth;
	private final boolean isSSL;
	private String mailID;
	private String password;

	private void setCredenciales() {
		try {

			final Properties creds = new Properties();

			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			creds.load(classLoader.getResourceAsStream("config/mailsettings.properties"));

			host = creds.getProperty("host");
			puerto = creds.getProperty("puerto");
			mailID = creds.getProperty("mailID");
			password = creds.getProperty("password");
		} catch (IOException ex) {
			Logger.getLogger(Credenciales.class.getName()).log(Level.SEVERE, null, ex);
		}
	}



	public Credenciales(boolean isAuth, boolean isSSL) {

		this.isAuth = isAuth;
		this.isSSL = isSSL;
		setCredenciales();
	}


	public String getHost() {
		return host;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public boolean isAuth() {
		return isAuth;
	}

	public boolean isSSL() {
		return isSSL;
	}

	public String getMailID() {
		return mailID;
	}

	public String getPassword() {
		return password;
	}

}
