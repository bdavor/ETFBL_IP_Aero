package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.unibl.etf.dto.Poruka;

public class PorukaDao {
	
	//SQL
	private static String SQL_INSERT = "INSERT INTO `etfbl_ip_aero`.`poruka` (`idPoruka`, `email_korisnika`, `naslov`, `poruka`, `procitana_neprocitana`)"
			+ " VALUES (null, ?, ?, ?, ?);";

	public PorukaDao() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean insert(Poruka poruka) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero", "student",
					"student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_INSERT);
			ps.setString(1, poruka.getEmail_korisnika());
			ps.setString(2, poruka.getNaslov());
			ps.setString(3, poruka.getPoruka());
			ps.setString(4, poruka.getProcitana_neprocitana());
			ps.executeUpdate();
			result = true;
			ps.close();
			konekcija.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
