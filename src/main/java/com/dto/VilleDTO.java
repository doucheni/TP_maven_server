package com.dto;

public class VilleDTO {
	
	private String codeCommune;
	private String nomCommune;
	private String codePostal;
	private String libelleAche;
	private String ligne_5;
	private String latitude;
	private String longitude;
	
	public VilleDTO() {
		super();
	}
	
	public String getCodeCommune() {
		return codeCommune;
	}

	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLibelleAche() {
		return libelleAche;
	}

	public void setLibelleAche(String libelleAche) {
		this.libelleAche = libelleAche;
	}

	public String getLigne_5() {
		return ligne_5;
	}

	public void setLigne_5(String ligne_5) {
		this.ligne_5 = ligne_5;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "VilleDTO [codeCommune=" + codeCommune + ", nomCommune=" + nomCommune + ", codePostal=" + codePostal
				+ ", libelleAche=" + libelleAche + ", ligne_5=" + ligne_5 + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
	
	
}
