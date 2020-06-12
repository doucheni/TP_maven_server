package com.dao;

import java.util.List;

import com.dto.VilleDTO;

public interface VilleDAO {
	
	public List<VilleDTO> listerVilles();
	
	public List<VilleDTO> trouverVilles(VilleDTO ville);
	
	public void creerVille(VilleDTO ville);
}
