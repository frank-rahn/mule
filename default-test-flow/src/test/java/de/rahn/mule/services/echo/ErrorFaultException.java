package de.rahn.mule.services.echo;

import de.frank_rahn.xmlns.types.error._1.ErrorFault;

/**
 * Die {@link Exception} für den SOAP-Client.
 * 
 * @author Frank Rahn
 */
public class ErrorFaultException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorFault errorFault;

	/**
	 * Konstruktor.
	 * 
	 * @param message
	 *            die SOAP-Fault-Message
	 * @param errorFault
	 *            die Message von SOAP-Provider
	 */
	public ErrorFaultException(String message, ErrorFault errorFault) {
		super(message);

		this.errorFault = errorFault;
	}

	/**
	 * @return die Fault-Details
	 */
	public ErrorFault getFaultInfo() {
		return errorFault;
	}

}