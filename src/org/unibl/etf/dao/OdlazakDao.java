package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.unibl.etf.dto.Odlazak;

public class OdlazakDao {
	
	//SQL
	public static String SQL_RETURN_ODLAZAK = "select idOdlazak, polazna_lokacija, odrediste, vrijeme_odlaska, status, vrsta_leta from etfbl_ip_aero.odlazak o where o.vrijeme_odlaska = ? and o.vrsta_leta = ? and o.status = 'ceka';";
	public static String SQL_RETURN_ALL_ODLAZAK = "select idOdlazak, polazna_lokacija, odrediste, vrijeme_odlaska, status, vrsta_leta from etfbl_ip_aero.odlazak o where o.vrijeme_odlaska = ? order by vrijeme_odlaska;";
	private static String SQL_ODLAZAK_POLETIO = 
			"update etfbl_ip_aero.odlazak\r\n" + 
			"set\r\n" + 
			"status = ?\r\n" + 
			"where \r\n" + 
			"vrijeme_odlaska <= NOW()";
	private static String SQL_ODLAZAK_SLETIO = 
			"update etfbl_ip_aero.odlazak\r\n" + 
			"set\r\n" + 
			"status = ?\r\n" + 
			"where \r\n" + 
			"DATE_ADD(vrijeme_odlaska, INTERVAL 2 HOUR) <= NOW()";

	public OdlazakDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Odlazak> readAllOdlazak (String date, String putnicki_teretni) {
		ArrayList<Odlazak> odlasci = new ArrayList<Odlazak>();
		Odlazak odlazak = null;
		try {
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero",
					"student", "student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_RETURN_ODLAZAK);
			ps.setString(1, date);
			ps.setString(2, putnicki_teretni);
			ResultSet rezultat = ps.executeQuery();
			while (rezultat.next()) {
				Integer idOdlazak = rezultat.getInt(1);
				String polazna_lokacija =  rezultat.getString(2);
				String odrediste =  rezultat.getString(3);
				Date vrijeme_odlaska =  rezultat.getDate(4);
				String status =  rezultat.getString(5);
				String vrsta_leta =  rezultat.getString(6);
				
				odlazak = new Odlazak(idOdlazak, polazna_lokacija, odrediste, vrijeme_odlaska, status, vrsta_leta);
				odlasci.add(odlazak);
			}
			rezultat.close();
			ps.close();
			konekcija.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return odlasci;
	}
	
	public ArrayList<Odlazak> returnAllOdlazak (Date date) {
		ArrayList<Odlazak> odlasci = new ArrayList<Odlazak>();
		Odlazak odlazak = null;
		try {
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero",
					"student", "student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_RETURN_ALL_ODLAZAK);
			ps.setDate(1, date);
			ResultSet rezultat = ps.executeQuery();
			while (rezultat.next()) {
				Integer idOdlazak = rezultat.getInt(1);
				String polazna_lokacija =  rezultat.getString(2);
				String odrediste =  rezultat.getString(3);
				Date vrijeme_odlaska =  rezultat.getDate(4);
				String status =  rezultat.getString(5);
				String vrsta_leta =  rezultat.getString(6);
				
				odlazak = new Odlazak(idOdlazak, polazna_lokacija, odrediste, vrijeme_odlaska, status, vrsta_leta);
				odlasci.add(odlazak);
			}
			rezultat.close();
			ps.close();
			konekcija.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return odlasci;
	}
	
	public void updatePoletio() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero", "student",
					"student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_ODLAZAK_POLETIO);
			ps.setString(1, "poletio");
			ps.executeUpdate();
			
			ps.close();
			konekcija.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateSletio() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero", "student",
					"student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_ODLAZAK_SLETIO);
			ps.setString(1, "sletio");
			ps.executeUpdate();
			
			ps.close();
			konekcija.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
