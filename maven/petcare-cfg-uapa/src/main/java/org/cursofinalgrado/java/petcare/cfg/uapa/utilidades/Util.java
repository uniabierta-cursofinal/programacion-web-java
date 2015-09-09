
package org.cursofinalgrado.java.petcare.cfg.uapa.utilidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

/**
 * @author ecabrerar
 * @date   Sep 9, 2015
 */
public class Util {

     private Util() {  }

     public static String toMD5(String mensaje) throws NoSuchAlgorithmException{

    	 MessageDigest md5  = MessageDigest.getInstance("MD5");

		 return (new HexBinaryAdapter()).marshal(md5.digest(mensaje.getBytes()));

     }
}
