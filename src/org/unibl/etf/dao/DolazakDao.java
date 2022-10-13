package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.unibl.etf.dto.Dolazak;

public class DolazakDao {
	
	//SQL
	public static String SQL_RETURN_ALL_DOLAZAK = "select idDolazak, polazna_lokacija, odrediste, vrijeme_polaska, status, vrsta_leta from etfbl_ip_aero.dolazak d where d.vrijeme_polaska = ? order by vrijeme_polaska;";
	private static String SQL_DOLAZAK_POLETIO = 
			"update etfbl_ip_aero.dolazak\r\n" + 
			"set\r\n" + 
			"status = ?\r\n" + 
			"where \r\n" + 
			"vrijeme_polaska <= NOW()";
	private static String SQL_DOLAZAK_SLETIO = 
			"update etfbl_ip_aero.dolazak\r\n" + 
			"set\r\n" + 
			"status = ?\r\n" + 
			"where \r\n" + 
			"DATE_ADD(vrijeme_polaska, INTERVAL 2 HOUR) <= NOW()";

	public DolazakDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Dolazak> returnAllDolazak(Date date) {
		ArrayList<Dolazak> dolasci = new ArrayList<Dolazak>();
		Dolazak dolazak = null;
		try {
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero",
					"student", "student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_RETURN_ALL_DOLAZAK);
			ps.setDate(1, date);
			ResultSet rezultat = ps.executeQuery();
			while (rezultat.next()) {
				Integer idDolazak = rezultat.getInt(1);
				String polazna_lokacija =  rezultat.getString(2);
				String odrediste =  rezultat.getString(3);
				Date vrijeme_polaska =  rezultat.getDate(4);
				String status =  rezultat.getString(5);
				String vrsta_leta =  rezultat.getString(6);
				
				dolazak = new Dolazak(idDolazak, polazna_lokacija, odrediste, vrijeme_polaska, status, vrsta_leta);
				dolasci.add(dolazak);
			}
			rezultat.close();
			ps.close();
			konekcija.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dolasci;
	}
	
	public void updatePoletio() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero", "student",
					"student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_DOLAZAK_POLETIO);
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
			PreparedStatement ps = konekcija.prepareStatement(SQL_DOLAZAK_SLETIO);
			ps.setString(1, "sletio");
			ps.executeUpdate();
			
			ps.close();
			konekcija.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
