package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.unibl.etf.dto.Pristup;

public class PristupDao {
	
	//SQL
	private static String SQL_READ = "SELECT * FROM etfbl_ip_aero.pristup where datum = CURDATE()";
	private static String SQL_INSERT = "INSERT INTO `etfbl_ip_aero`.`pristup` (`idPristup`, `datum`, `broj_pristupa`)"
			+ " VALUES (null, ?, ?);";
	private static String SQL_UPDATE = 
			"update pristup\r\n" + 
			"set\r\n" + 
			"datum = ?, broj_pristupa = ?\r\n" + 
			"where \r\n" + 
			"idPristup = ?";

	public PristupDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Pristup> readPristup(){
		ArrayList<Pristup> pristupi = new ArrayList<Pristup>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero",
					"student", "student");
			java.sql.Statement s = konekcija.createStatement();
			ResultSet rezultat = ((java.sql.Statement) s).executeQuery(SQL_READ);
			while(rezultat.next()) {
				int idPristup = rezultat.getInt(1);
				Date datum = rezultat.getDate(2);
				int brojPristupa = rezultat.getInt(3);
				Pristup p = new Pristup(idPristup, datum, brojPristupa);
				pristupi.add(p);
			}
			rezultat.close();
			konekcija.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return pristupi;
	}
	
	public void insert(Pristup pristup) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero", "student",
					"student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_INSERT);
			ps.setDate(1, pristup.getDatum());
			ps.setInt(2, pristup.getBroj_pristupa());
			ps.executeUpdate();
			ps.close();
			konekcija.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Pristup pristup) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero", "student",
					"student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_UPDATE);
			ps.setDate(1, pristup.getDatum());
			ps.setInt(2, pristup.getBroj_pristupa());
			ps.setInt(3, pristup.getIdPristup());
			ps.executeUpdate();
			ps.close();
			konekcija.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
