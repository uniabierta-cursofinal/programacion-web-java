
package org.cursofinalgrado.java.petcare.cfg.uapa.utilidades;

/**
 * @author ecabrerar
 * @date   Sep 8, 2015
 */
public class PetCareException extends Exception {
	private static final long serialVersionUID = 1L;

	public PetCareException() {
		super();
	}

	public PetCareException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PetCareException(String message, Throwable cause) {
		super(message, cause);
	}

	public PetCareException(String message) {
		super(message);
	}

	public PetCareException(Throwable cause) {
		super(cause);
	}


}
