package com.weecover.msparty.adapter.inboud.rest;

/**
 * Excepción personalizada para manejar accesos no autorizados.
 */
public class UnauthorizedAccessException extends RuntimeException {

    /**
     * Constructor por defecto.
     */
    public UnauthorizedAccessException() {
        super("Acceso no autorizado.");
    }

    /**
     * Constructor que acepta un mensaje personalizado.
     *
     * @param message Mensaje personalizado para la excepción.
     */
    public UnauthorizedAccessException(String message) {
        super(message);
    }

    /**
     * Constructor que acepta un mensaje personalizado y una causa.
     *
     * @param message Mensaje personalizado para la excepción.
     * @param cause   Causa original de la excepción.
     */
    public UnauthorizedAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que acepta una causa.
     *
     * @param cause Causa original de la excepción.
     */
    public UnauthorizedAccessException(Throwable cause) {
        super("Acceso no autorizado.", cause);
    }
}
