package com.config;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {
	
	private static final String ATT_URL = "URL";
	private static final String ATT_USER = "USER";
	private static final String ATT_MDP = "MDP";

	
	@Bean
	public static Connection getConnection() {
		Properties resource = load("Application.properties");
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection((String)resource.get(ATT_URL),(String)resource.get(ATT_USER),(String)resource.get(ATT_MDP));
			System.out.println("Connecter");
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}

		return con;
	}
	
	public static Properties load(String propsName) {
        Properties props = new Properties();
        URL url = ClassLoader.getSystemResource(propsName);
        try {
			props.load(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
        return props;
    }
	
	
	
	
	
	
}
