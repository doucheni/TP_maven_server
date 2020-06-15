package com.dao;

import java.util.List;

import com.dto.VilleDTO;

public interface VilleDAO {
	
	/**
	 * Renvoie une liste de toute les villes enregistrées
	 * Dans la BDDD
	 * 
	 * @return villes, la liste de toutes les villes enregistrées dans la BDD
	 */
	
	public List<VilleDTO> listerVilles();
	
	/**
	 * Méthode permettant d'optenir toutes villes enregistrées ayant les mêmes attributs que le bean placé en paramètre
	 * 
	 * @param ville, la ville que l'on souhaite trouvé
	 * @return villes, la liste des villes similaires
	 */
	
	public List<VilleDTO> trouverVilles(VilleDTO ville);
	
	/**
	 * Méthode permettant l'insertion d'une ville dans la BDD
	 * 
	 * @param ville, la ville que l'on souhaite insérer
	 */
	
	public void creerVille(VilleDTO ville);
	
	/**
	 * Méthode permettant de supprimer une ville dans la BDD
	 * 
	 * @param ville, la ville que l'on souhaite supprimer
	 */
	
	public void supprimerVille(VilleDTO ville);
	
	/**
	 * Méthode permettant de modifier une ville de la BDD
	 * 
	 * @param ville, la ville que l'on souhaite modifier
	 */
	
	public void modifierVille(VilleDTO ville);
}
