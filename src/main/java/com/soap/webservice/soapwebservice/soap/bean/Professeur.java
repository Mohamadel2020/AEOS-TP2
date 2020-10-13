package com.soap.webservice.soapwebservice.soap.bean;

public class Professeur {
	
	private int id;
	private String nomProf;
	private String prenomProf;
	
	
	
	public Professeur(int id, String nomProf, String prenomProf) {
		super();
		this.id = id;
		this.nomProf = nomProf;
		this.prenomProf = prenomProf;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomProf() {
		return nomProf;
	}
	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}
	public String getPrenomProf() {
		return prenomProf;
	}
	public void setPrenomProf(String prenomProf) {
		this.prenomProf = prenomProf;
	}

	@Override
	public String toString() {
		return String.format("Professeur [id=%s, nomProf=%s, prenomProf=%s]", id, nomProf, prenomProf);
	}
		
}
