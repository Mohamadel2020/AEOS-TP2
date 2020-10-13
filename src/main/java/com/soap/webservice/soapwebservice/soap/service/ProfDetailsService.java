package com.soap.webservice.soapwebservice.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.soap.webservice.soapwebservice.soap.bean.Professeur;

@Component
public class ProfDetailsService {
	
	public enum Status{
		SUCCESS, FAILLURE;
	}

	private static List<Professeur> professeurs = new ArrayList<>();
	
	static {
		
		Professeur professeur1 = new Professeur(1, "Thiongane", "Baidy");
		professeurs.add(professeur1);
		
		Professeur professeur2 = new Professeur(2, "Faye", "Mamadou Djidiack");
		professeurs.add(professeur2);
		
		Professeur professeur3 = new Professeur(3, "Ndiade", "Mohamadel ElHabibou");
		professeurs.add(professeur3);
	}
	
	public Professeur findById(int id) {
		for(Professeur professeur:professeurs) {
			if(professeur.getId()==id)
				return professeur;
			}
			return null;
	}
	
	public List<Professeur> findAll(){
		return professeurs;
	}
	
	public Status deleteById(int id) {
		Iterator<Professeur> iterator = professeurs.iterator();
		while(iterator.hasNext()) {
		Professeur professeur = iterator.next();
			if(professeur.getId()==id) {
				iterator.remove();
				return Status.SUCCESS;
			}
			
		}
			return Status.FAILLURE;
	}
}