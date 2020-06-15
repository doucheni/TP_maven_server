package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.config.DaoConfig;
import com.dto.VilleDTO;

@Repository
public class VilleDAOImpl implements VilleDAO{
	
	private static final String ATT_CODE_COMMUNE = "Code_commune_INSEE";
	private static final String ATT_NOM_COMMUNE = "Nom_commune";
	private static final String ATT_CODE_POSTAL = "Code_postal";
	private static final String ATT_LIBELLE_ACH = "Libelle_acheminement";
	private static final String ATT_LIGNE_5 = "Ligne_5";
	private static final String ATT_LATITUDE = "Latitude";
	private static final String ATT_LONGITUDE = "Longitude";
	
	private static final String[] ATT = {ATT_CODE_COMMUNE, ATT_NOM_COMMUNE, ATT_CODE_POSTAL, ATT_LIBELLE_ACH, ATT_LIGNE_5, ATT_LATITUDE, ATT_LONGITUDE};   
	
	private static final String SQL_SELECT_ALL = "SELECT * FROM ville_france";
	private static final String SQL_INSERT = "INSERT INTO ville_france VALUES(";
	private static final String SQL_DELETE = "DELETE FROM ville_france WHERE Code_commune_INSEE = ";
	
	/**
	 * Renvoie une liste de toute les villes enregistrées
	 * Dans la BDDD
	 * 
	 * @return villes, la liste de toutes les villes enregistrées dans la BDD
	 */
	public List<VilleDTO> listerVilles() {
		List<VilleDTO> villes = new ArrayList<>();
		Connection con = DaoConfig.getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(SQL_SELECT_ALL);
			while(rset.next()) {
				villes.add(recupererVille(rset));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return villes;
	}
	
	/**
	 * Méthode permettant d'optenir toutes villes enregistrées ayant les mêmes attributs que le bean placé en paramètre
	 * 
	 * @param ville, la ville que l'on souhaite trouvé
	 * @return villes, la liste des villes similaires
	 */
	
	public List<VilleDTO> trouverVilles(VilleDTO ville){
		List<VilleDTO> villes = new ArrayList<>();
		Connection con = DaoConfig.getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		String requete = buildRequeteSelect(recupererAttributs(ville));
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(requete);
			while(rset.next()) {
				villes.add(recupererVille(rset));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return villes;
	}
	
	/**
	 * Méthode permettant l'insertion d'une ville dans la BDD
	 * 
	 * @param ville, la ville que l'on souhaite insérer
	 */
	
	public void creerVille(VilleDTO ville) {
		Connection con = DaoConfig.getConnection();
		Statement stmt = null;
		String requete = SQL_INSERT + ville.getCodeCommune() + "," + ville.getNomCommune() + "," + ville.getCodePostal() + "," + ville.getLibelleAche() + "," + ville.getLigne_5() + "," + ville.getLatitude() + "," + ville.getLongitude() + ")";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(requete);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode permettant de supprimer une ville dans la BDD
	 * 
	 * @param ville, la ville que l'on souhaite supprimer
	 */
	
	public void supprimerVille(VilleDTO ville) {
		Connection con = DaoConfig.getConnection();
		Statement stmt = null;
		String requete = SQL_DELETE + ville.getCodeCommune();
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(requete);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode permettant de modifier une ville de la BDD
	 * 
	 * @param ville, la ville que l'on souhaite modifier
	 */
	
	public void modifierVille(VilleDTO ville) {
		Connection con = DaoConfig.getConnection();
		Statement stmt = null;
		String requete = buildRequeteUpdate(recupererAttributs(ville));
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(requete);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode permettant d'obtenir les noms et les valeurs des attributs définis (= non null) dans un bean ville
	 * 
	 * @param ville, la ville qui nous intéresse
	 * @return mapAttributs, Map contenant le nom de l'attribut en clé et sa valeur
	 */
	
	private static HashMap<String,String> recupererAttributs(VilleDTO ville){
		HashMap<String,String> mapAttribut = new HashMap<>();
		if(ville.getCodeCommune() != null) {
			mapAttribut.put(ATT_CODE_COMMUNE, ville.getCodeCommune());
		}
		if(ville.getNomCommune() != null) {
			mapAttribut.put(ATT_NOM_COMMUNE, ville.getNomCommune());
		}
		if(ville.getCodePostal() != null) {
			mapAttribut.put(ATT_CODE_POSTAL, ville.getCodePostal());
		}
		if(ville.getLibelleAche() != null) {
			mapAttribut.put(ATT_LIBELLE_ACH, ville.getLibelleAche());
		}
		if(ville.getLigne_5() != null) {
			mapAttribut.put(ATT_LIGNE_5, ville.getLigne_5());
		}
		if(ville.getLatitude() != null) {
			mapAttribut.put(ATT_LATITUDE, ville.getLatitude());
		}
		if(ville.getLongitude() != null) {
			mapAttribut.put(ATT_LONGITUDE, ville.getLongitude());
		}
		return mapAttribut;
	}
	
	/**
	 * Méthode permettant de construire un requête SELECT de la forme SELECT * FROM ville_france WHERE ...=... AND ...........
	 * Méthode utile pour la méthode trouverVille(VilleDTO ville) où l'on ne connait pas à l'avance le nombre d'attributs spécifié
	 * 
	 * @param mapAttribut, Map des attributs définits d'un bean VilleDTO
	 * @return requete, la requete SELECT correspondant à cette Map
	 */
	private static String buildRequeteSelect(HashMap<String,String> mapAttribut) {
		String requete = "SELECT * FROM ville_france WHERE ";
		int length = mapAttribut.keySet().size();
		int count = 0;
		for(String key : mapAttribut.keySet()) {
			if(count < length - 1) {
				requete += key + " LIKE '" + mapAttribut.get(key) + "%' AND ";
			}else {
				requete += key + " LIKE '" + mapAttribut.get(key) + "%'";
			}
			count ++;
		}
		return requete;
	}
	
	private static String buildRequeteUpdate(HashMap<String,String> mapAttribut) {
		String requete = "UPDATE ville_france SET ";
		int length = mapAttribut.keySet().size();
		int count = 0;
		for(String key : mapAttribut.keySet()) {
			if(!key.equals(ATT_CODE_COMMUNE)) {
				if(count < length - 1) {
					requete += key + " = '" + mapAttribut.get(key) + "', ";
				}else {
					requete += key + " = '" + mapAttribut.get(key) + "'";
				}
			}
			count ++;
		}
		requete += " WHERE " + ATT_CODE_COMMUNE + " = " + mapAttribut.get(ATT_CODE_COMMUNE);
		return requete;
	}
	
	/**
	 * Méthode permettant d'obtenir un bean VilleDTO à partir d'un ResultSet
	 * 
	 * @param rset, le ResultSet d'une requête
	 * @return ville, la ville associée
	 */
	private static VilleDTO recupererVille(ResultSet rset) {
		VilleDTO ville = new VilleDTO();
		try {
			ville.setCodeCommune(rset.getString(ATT_CODE_COMMUNE));
			ville.setNomCommune(rset.getString(ATT_NOM_COMMUNE));
			ville.setCodePostal(rset.getString(ATT_CODE_POSTAL));
			ville.setLibelleAche(rset.getString(ATT_LIBELLE_ACH));
			ville.setLigne_5(rset.getString(ATT_LIGNE_5));
			ville.setLongitude(rset.getString(ATT_LONGITUDE));
			ville.setLatitude(rset.getString(ATT_LATITUDE));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ville;
	}
}
