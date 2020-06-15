package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.VilleDTO;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBLO villeService;

	/**
	 * Requête GET pour obtenir les informations des villes enregistrées dans la base de données.
	 * Possibilité de filtrer les résultats en fonction des paramètres de la requêtes.
	 * 
	 * @param codeCommune
	 * @param nomCommune
	 * @param codePostal
	 * @param libelleAche
	 * @param ligne_5
	 * @param latitude
	 * @param longitude
	 * @return villes, la liste des villes correspondant à la demande.
	 */
	
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public List<VilleDTO> appelGet(
			@RequestParam(value = "codeCommune", required = false) String codeCommune, 
			@RequestParam(value = "nomCommune", required = false) String nomCommune,
			@RequestParam(value = "codePostal", required = false) String codePostal,
			@RequestParam(value = "libelleAche", required = false) String libelleAche,
			@RequestParam(value = "ligne_5", required = false) String ligne_5,
			@RequestParam(value = "latitude", required = false) String latitude,
			@RequestParam(value = "longitude", required = false) String longitude
			){
		// Création de la liste qui contiendra la réponse de la requête.
		List<VilleDTO> villes = new ArrayList<>();
		
		// Création d'un bean VilleDTO correspondant à la demande faite.
		VilleDTO ville = new VilleDTO(codeCommune, nomCommune, codePostal, libelleAche, ligne_5, latitude, longitude);
		
		// Recherche dans la BDD les villes ressemblants à la demande faite.
		villes = villeService.listerVilles(ville);
		
		return villes;
	}
	
	/**
	 * Requête POST pour insérer une nouvelle ville dans la base de données à partir du body de la requête.
	 * 
	 * @param ville
	 */
	
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public void appelPost(@RequestBody VilleDTO ville) {
		// Insertion dans la base de donneés de la ville correspondant au body de la requête
		villeService.creerVille(ville);
	}
	
	/**
	 * Requete DELETE permettant la suppression de villes dans la BDD à partir de la clé primaire.
	 * @param codeCommune
	 */
	
	@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
	@ResponseBody
	public void appelDelete( @RequestParam(value = "codeCommune", required = true) String codeCommune) {
		VilleDTO ville = new VilleDTO();
		ville.setCodeCommune(codeCommune);
		villeService.supprimerVille(ville);
	}
	
	/**
	 * Requete PUT permettant la mise à jour d'une ville dans la BDD à partir de la clé primaire
	 * 
	 * @param codeCommune
	 * @param nomCommune
	 * @param codePostal
	 * @param libelleAche
	 * @param ligne_5
	 * @param latitude
	 * @param longitude
	 */
	
	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	@ResponseBody
	public void appelPut(
			@RequestParam(value = "codeCommune", required = true) String codeCommune, 
			@RequestParam(value = "nomCommune", required = false) String nomCommune,
			@RequestParam(value = "codePostal", required = false) String codePostal,
			@RequestParam(value = "libelleAche", required = false) String libelleAche,
			@RequestParam(value = "ligne_5", required = false) String ligne_5,
			@RequestParam(value = "latitude", required = false) String latitude,
			@RequestParam(value = "longitude", required = false) String longitude
			) {
		VilleDTO ville = new VilleDTO(codeCommune, nomCommune, codePostal, libelleAche, ligne_5, latitude, longitude);
		villeService.modifierVille(ville);
	}
	
}
