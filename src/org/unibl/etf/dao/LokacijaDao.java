package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.unibl.etf.dto.Korisnik;


public class LokacijaDao {
	
	//SQL
	private static String SQL_READ = "select drzava from etfbl_ip_aero.lokacija";
	private static String SQL_RETURN_ID = "select idLokacija from etfbl_ip_aero.lokacija l where l.drzava = ?;";


	public LokacijaDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<String> readAllCounty(){
		ArrayList<String> countries = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero",
					"student", "student");
			java.sql.Statement s = konekcija.createStatement();
			ResultSet rezultat = ((java.sql.Statement) s).executeQuery(SQL_READ);
			while(rezultat.next()) {
				String drzava = rezultat.getString(1);
				countries.add(drzava);
			}
			rezultat.close();
			konekcija.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return countries;
	}
	
	public int readIdForCountry(String name) {
		int id = 0;
		try {
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero",
					"student", "student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_RETURN_ID);
			ps.setString(1, name);
			ResultSet rezultat = ps.executeQuery();
			while (rezultat.next()) {
				id = rezultat.getInt(1);
				
			}
			rezultat.close();
			ps.close();
			konekcija.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
