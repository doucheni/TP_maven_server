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

	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public List<VilleDTO> appelGet(@RequestParam(value = "codePostal", required = false) String codePostal) {
		System.out.println("Appel GET");
		List<VilleDTO> villes = new ArrayList<>();
		
		//TODO Optimisation : Le choix de la méthode devrait se faire dans le BLO
		if(codePostal == null) {
			villes = villeService.getInfoVille();
		}else {
			VilleDTO ville = new VilleDTO();
			ville.setCodePostal(codePostal);
			villes = villeService.trouverVilles(ville);
		}
		
		return villes;
	}
	
	// Méthode POST
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public void appelPost(@RequestBody VilleDTO ville) {
		System.out.println("Appel POST");
		villeService.creerVille(ville);
	
	}
	
}
