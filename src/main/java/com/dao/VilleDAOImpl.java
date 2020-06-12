package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	private static final String SQL_SELECT_CP = "SELECT * FROM ville_france WHERE code_postal LIKE '";
	private static final String SQL_INSERT = "INSERT INTO ville_france VALUES(";
	
	/**
	 * Renvoie une liste de toute les villes enregistrées
	 * Dans la BDDD
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
	
	public List<VilleDTO> trouverVilles(VilleDTO ville){
		List<VilleDTO> villes = new ArrayList<>();
		Connection con = DaoConfig.getConnection();
		Statement stmt = null;
		ResultSet rset = null;
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(SQL_SELECT_CP + ville.getCodePostal() + "%'");
			while(rset.next()) {
				villes.add(recupererVille(rset));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return villes;
	}
	
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
