package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Lokacija_GradDao {
	
	//SQL
	private static String SQL_READ = "select grad from etfbl_ip_aero.lokacija_grad g where g.Lokacija_idLokacija = ?";

	public Lokacija_GradDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<String> readAllCity(String name){
		ArrayList<String> cities = new ArrayList<String>();
		int id = new LokacijaDao().readIdForCountry(name); 
		try {
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero",
					"student", "student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_READ);
			ps.setInt(1, id);
			ResultSet rezultat = ps.executeQuery();
			while (rezultat.next()) {
				String grad = rezultat.getString(1);
				cities.add(grad);
			}
			rezultat.close();
			ps.close();
			konekcija.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cities;
	}

}
