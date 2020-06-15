package com.blo;

import java.util.List;

import com.dto.VilleDTO;

public interface VilleBLO {

	/**
	 * Insère dans la table une nouvelle ville 
	 * @param ville, la ville que l'on veut enregistré
	 */
	
	public void creerVille(VilleDTO ville);
	
	/**
	 * Liste toutes les villes de la BDD en fonctione de la ville placée en paramètre.
	 * Si cette dernière est nulle, ou ne contient aucun paramètre définit, alors la méthode renvoie toutes les villes enregistrées dans la BDD
	 * @param ville
	 * @return
	 */
	
	public List<VilleDTO> listerVilles(VilleDTO ville);
	
	public void supprimerVille(VilleDTO ville);
	
	public void modifierVille(VilleDTO ville);
}
