package com.blo;

import java.util.List;

import com.dto.VilleDTO;

public interface VilleBLO {

	public List<VilleDTO> getInfoVille();
	
	public List<VilleDTO> trouverVilles(VilleDTO ville);

	public void creerVille(VilleDTO ville);
}
