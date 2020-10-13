package com.soap.webservice.soapwebservice.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.webservice.soapwebservice.soap.bean.Professeur;
import com.soap.webservice.soapwebservice.soap.exception.ProfesseurNotFoundException;
import com.soap.webservice.soapwebservice.soap.service.ProfDetailsService;
import com.soap.webservice.soapwebservice.soap.service.ProfDetailsService.Status;

import sn.uvs.formation.professeur.DeleteProfDetailsRequest;
import sn.uvs.formation.professeur.DeleteProfDetailsResponse;
import sn.uvs.formation.professeur.GetAllProfDetailsRequest;
import sn.uvs.formation.professeur.GetAllProfDetailsResponse;
import sn.uvs.formation.professeur.GetProfDetailsRequest;
import sn.uvs.formation.professeur.GetProfDetailsResponse;
import sn.uvs.formation.professeur.ProfDetails;

@Endpoint
public class ProfDetailsEndpoint {
	
	@Autowired
	ProfDetailsService service;
	
	
	
	@PayloadRoot(namespace="http://formation.uvs.sn/professeur", localPart="GetProfDetailsRequest")
	@ResponsePayload
	public GetProfDetailsResponse processProfDetailsRequest(@RequestPayload GetProfDetailsRequest request) {
		Professeur professeur = service.findById(request.getId());
		
		if(professeur==null) {
			throw new ProfesseurNotFoundException("Invaid Professeur Id " + request.getId());
		}
		
		return mapProfDetails(professeur);
	}

	private GetProfDetailsResponse mapProfDetails(Professeur professeur) {
		GetProfDetailsResponse response = new GetProfDetailsResponse();
		
		response.setProfDetails(mapProfesseur(professeur));
		return response;
	}
	
	private GetAllProfDetailsResponse mapAllProfDetails(List<Professeur> professeurs) {
		GetAllProfDetailsResponse response = new GetAllProfDetailsResponse();
		for(Professeur professeur:professeurs) {
			ProfDetails mapProfesseur = mapProfesseur(professeur);
			response.getProfDetails().add(mapProfesseur);
		}
		return response;
	}


	private ProfDetails mapProfesseur(Professeur professeur) {
		ProfDetails profDetails = new ProfDetails();
		
		profDetails.setId(professeur.getId());
		profDetails.setNomProf(professeur.getNomProf());
		profDetails.setPrenomProf(professeur.getPrenomProf());
		return profDetails;
	}
	
	@PayloadRoot(namespace="http://formation.uvs.sn/professeur",
			localPart="GetAllProfDetailsRequest")
	@ResponsePayload
	public GetAllProfDetailsResponse processAllProfDetailsRequest(@RequestPayload
			GetAllProfDetailsRequest request) {
		List<Professeur> professeurs = service.findAll();
		
		return mapAllProfDetails(professeurs);
	}	
	
	@PayloadRoot(namespace="http://formation.uvs.sn/professeur",
			localPart="DeleteProfDetailsRequest")
	@ResponsePayload
	public DeleteProfDetailsResponse deleteProfDetailsRequest(@RequestPayload
			DeleteProfDetailsRequest request) {
		Status status = service.deleteById(request.getId());
		
		DeleteProfDetailsResponse response = new DeleteProfDetailsResponse();
		response.setStatus(mapStatus(status));
		
		return response;
	}

	private sn.uvs.formation.professeur.Status mapStatus(Status status) {
		
		if(status==Status.FAILLURE)
			return sn.uvs.formation.professeur.Status.FAILLURE;
			return sn.uvs.formation.professeur.Status.SUCCESS;
	}
}