package com.dto;

public class VilleDTO {
	
	private String codeCommune;
	private String nomCommune;
	private String codePostal;
	private String libelleAche;
	private String ligne_5;
	private String latitude;
	private String longitude;
	
	/**
	 * Constructeur par défaut du bean VilleDTO
	 */
	
	public VilleDTO() {
		super();
	}
	
	/**
	 * Constructeur avec tous les attributs du bean VilleDTO
	 * 
	 * @param codeCommune
	 * @param nomCommune
	 * @param codePostal
	 * @param libelleAche
	 * @param ligne_5
	 * @param latitude
	 * @param longitude
	 */
	public VilleDTO(String codeCommune, String nomCommune, String codePostal, String libelleAche, String ligne_5,
			String latitude, String longitude) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
		this.libelleAche = libelleAche;
		this.ligne_5 = ligne_5;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Accesseur de l'attribut codeCommune 
	 * @return codeCommune, la valeur de l'attribut codeCommune de l'objet
	 */
	
	public String getCodeCommune() {
		return codeCommune;
	}

	/**
	 * Mutateur de l'attribut codeCommune 
	 * @param codeCommune, la nouvelle valeur de l'attribut codeCommune
	 */
	
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}

	/**
	 * Accesseur de l'attribut nomCommune 
	 * @return nomCommune, la valeur de l'attribut nomCommune de l'objet
	 */
	
	public String getNomCommune() {
		return nomCommune;
	}

	/**
	 * Mutateur de l'attribut nomCommune 
	 * @param nomCommune, la nouvelle valeur de l'attribut nomCommune
	 */
	
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	/**
	 * Accesseur de l'attribut codePostal 
	 * @return codePostal, la valeur de l'attribut codePostal de l'objet
	 */
	
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Mutateur de l'attribut codePostal 
	 * @param codePostal, la nouvelle valeur de l'attribut codePostal
	 */
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Accesseur de l'attribut libelleAche 
	 * @return libelleAche, la valeur de l'attribut libelleAche de l'objet
	 */
	
	public String getLibelleAche() {
		return libelleAche;
	}

	/**
	 * Mutateur de l'attribut libelleAche 
	 * @param libelleAche, la nouvelle valeur de l'attribut libelleAche
	 */
	
	public void setLibelleAche(String libelleAche) {
		this.libelleAche = libelleAche;
	}

	/**
	 * Accesseur de l'attribut ligne_5 
	 * @return ligne_5, la valeur de l'attribut ligne_5 de l'objet
	 */
	
	public String getLigne_5() {
		return ligne_5;
	}

	/**
	 * Mutateur de l'attribut ligne_5 
	 * @param ligne_5, la nouvelle valeur de l'attribut ligne_5
	 */
	
	public void setLigne_5(String ligne_5) {
		this.ligne_5 = ligne_5;
	}
	
	/**
	 * Accesseur de l'attribut latitude 
	 * @return latitude, la valeur de l'attribut latitude de l'objet
	 */
	
	public String getLatitude() {
		return latitude;
	}

	/**
	 * Mutateur de l'attribut latitude 
	 * @param latitude, la nouvelle valeur de l'attribut latitude
	 */
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * Accesseur de l'attribut longitude 
	 * @return longitude, la valeur de l'attribut longitude de l'objet
	 */
	
	public String getLongitude() {
		return longitude;
	}

	/**
	 * Mutateur de l'attribut longitude 
	 * @param longitude, la nouvelle valeur de l'attribut longitude
	 */
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * Méthode toString() du bean VilleDTO
	 * Renvoie une VilleDTO sous la forme d'une chaîne de caractère
	 */
	
	@Override
	public String toString() {
		return "VilleDTO [codeCommune=" + codeCommune + ", nomCommune=" + nomCommune + ", codePostal=" + codePostal
				+ ", libelleAche=" + libelleAche + ", ligne_5=" + ligne_5 + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
	
	
}
