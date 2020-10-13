package com.soap.webservice.soapwebservice.soap.exception;

import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;
import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;


@SoapFault(faultCode=FaultCode.CUSTOM,
customFaultCode="{sn.uvs.formation.professeur}001_Professeur_NOT_FOUND")
public class ProfesseurNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6339956495214277465L;

	public ProfesseurNotFoundException(String message) {
		super(message);
	}
	
}
