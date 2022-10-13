package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.unibl.etf.dto.Korisnik;

public class KorisnikDao {
	
	//SQL
	private static String SQL_EXISTS_USERNAME = "select exists(select * from korisnik as k where k.korisnickoIme = ?)";
	private static String SQL_EXISTS_EMAIL = "select exists(select * from korisnik as k where k.email = ?)";
	private static String SQL_INSERT = "INSERT INTO `etfbl_ip_aero`.`korisnik` (`IdKorisnik`, `korisnickoIme`, `lozinka`, `email`, `ime`, `prezime`, `adresa`, `drzava`, `putnicki_teretni`, `admin_kor_zap`)"
			+ " VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static String SQL_RETURN_USER = "select IdKorisnik, korisnickoIme, lozinka, email, ime, prezime, adresa, drzava, putnicki_teretni, admin_kor_zap  from etfbl_ip_aero.korisnik k where k.korisnickoIme = ? and k.lozinka = ? and k.admin_kor_zap = 'Korisnik';";

	public KorisnikDao() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean existsUsername(String korisnickoIme) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero", "student",
					"student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_EXISTS_USERNAME);
			ps.setString(1, korisnickoIme);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getBoolean(1);
			}
			ps.close();
			konekcija.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean existsEmail(String email) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero", "student",
					"student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_EXISTS_EMAIL);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getBoolean(1);
			}
			ps.close();
			konekcija.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean insert(Korisnik korisnik) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero", "student",
					"student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_INSERT);
			ps.setString(1, korisnik.getKorisnickoIme());
			ps.setString(2, korisnik.getLozinka());
			ps.setString(3, korisnik.getEmail());
			ps.setString(4, korisnik.getIme());
			ps.setString(5, korisnik.getPrezime());
			ps.setString(6, korisnik.getAdresa());
			ps.setString(7, korisnik.getDrzava());
			ps.setString(8, korisnik.getPutnicki_teretni());
			ps.setString(9, korisnik.getAdmin_kor_zap());
			ps.executeUpdate();
			result = true;
			ps.close();
			konekcija.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Korisnik returnKorisnik(String username, String password) {
		Korisnik user = null;
		try {
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero",
					"student", "student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_RETURN_USER);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rezultat = ps.executeQuery();
			while (rezultat.next()) {
				Integer idKorisnik = rezultat.getInt(1);
				String korisnickoIme =  rezultat.getString(2);
				String lozinka =  rezultat.getString(3);
				String email =  rezultat.getString(4);
				String ime =  rezultat.getString(5);
				String prezime =  rezultat.getString(6);
				String adresa =  rezultat.getString(7);
				String drzava =  rezultat.getString(8);
				String putnicki_teretni =  rezultat.getString(9);
				String admin_kor_zap =  rezultat.getString(10);
				
				user = new Korisnik(idKorisnik, ime, prezime, korisnickoIme, lozinka, email, adresa, drzava, putnicki_teretni, admin_kor_zap);
				
			}
			rezultat.close();
			ps.close();
			konekcija.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
