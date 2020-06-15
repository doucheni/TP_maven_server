package com.blo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.VilleDTO;

@Service
public class VilleBLOImpl implements VilleBLO{

	@Autowired
	private VilleDAO villeDAO;
		
	public void creerVille(VilleDTO ville) {
		villeDAO.creerVille(ville);
	}
	
	public List<VilleDTO> listerVilles(VilleDTO ville){
		if(villeIsNull(ville)) {
			return villeDAO.listerVilles();
		}else {
			return villeDAO.trouverVilles(ville);
		}
	}
	
	public void supprimerVille(VilleDTO ville) {
		villeDAO.supprimerVille(ville);
	}
	
	public void modifierVille(VilleDTO ville) {
		villeDAO.modifierVille(ville);
	}
	
	private boolean villeIsNull(VilleDTO ville) {
		return ville.getCodeCommune() == null 
				&& ville.getNomCommune() == null 
				&& ville.getCodePostal() == null 
				&& ville.getLibelleAche() == null 
				&& ville.getLigne_5() == null 
				&& ville.getLatitude() == null 
				&& ville.getLongitude() == null;
	}
}
