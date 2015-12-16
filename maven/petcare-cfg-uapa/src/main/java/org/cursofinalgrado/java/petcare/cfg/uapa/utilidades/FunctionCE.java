package org.cursofinalgrado.java.petcare.cfg.uapa.utilidades;

/**
 *
 * @author ecabrerar
 * @date   Dec 16, 2015
 */
@FunctionalInterface
public interface FunctionCE<T, R ,X extends Exception> {

	 R apply(T t) throws X;
}
