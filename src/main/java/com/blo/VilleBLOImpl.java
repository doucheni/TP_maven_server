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
	
	public List<VilleDTO> getInfoVille() {
		List<VilleDTO> ville = villeDAO.listerVilles();
		return ville;
	}
	
	public List<VilleDTO> trouverVilles(VilleDTO ville){
		return villeDAO.trouverVilles(ville);
	}
	
	public void creerVille(VilleDTO ville) {
		villeDAO.creerVille(ville);
	}
}
