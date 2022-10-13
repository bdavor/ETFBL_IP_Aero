package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.unibl.etf.dto.Rezervacija_Leta;

public class Rezervacija_LetaDao {
	
	//SQL
	private static String SQL_INSERT = "INSERT INTO `etfbl_ip_aero`.`rezervacija_leta` (`idRezervacija_leta`, `datum_leta`, `polazna_lokacija`, `odrediste`, `broj_mjesta`, `status_rezervacije`, `Korisnik_idKorisnik`)"
			+ " VALUES (null, ?, ?, ?, ?, ?, ?);";
	private static String SQL_INSERT_TERETNI = "INSERT INTO `etfbl_ip_aero`.`rezervacija_leta` (`idRezervacija_leta`, `datum_leta`, `polazna_lokacija`, `odrediste`, `opis_tereta`, `specifikacija_robe`, `status_rezervacije`, `Korisnik_idKorisnik`)"
			+ " VALUES (null, ?, ?, ?, ?, ?, ?, ?);";
	private static String SQL_RETURN_REZERVACIJA_BY_ID = "select idRezervacija_leta, datum_leta, polazna_lokacija, odrediste, broj_mjesta, opis_tereta, specifikacija_robe, status_rezervacije, razlog_ponistavanja, Korisnik_idKorisnik  from etfbl_ip_aero.rezervacija_leta rl where rl.Korisnik_idKorisnik = ? order by datum_leta;";
	private static String SQL_UPDATE_REZERVACIJA =  
			"update etfbl_ip_aero.rezervacija_leta\r\n" + 
			"set\r\n" + 
			"status_rezervacije = ?, razlog_ponistavanja = ?\r\n" + 
			"where \r\n" + 
			"idRezervacija_leta = ?";

	public Rezervacija_LetaDao() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean insert(Rezervacija_Leta rezervacijaLeta) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero", "student",
					"student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_INSERT);
			ps.setDate(1, rezervacijaLeta.getDatum_leta());
			ps.setString(2, rezervacijaLeta.getPolazna_lokacija());
			ps.setString(3, rezervacijaLeta.getOdrediste());
			ps.setInt(4, rezervacijaLeta.getBroj_mjesta());
			ps.setString(5, rezervacijaLeta.getStatus_rezervacije());
			ps.setInt(6, rezervacijaLeta.getKorisnik_idKorisnik());
			
			ps.executeUpdate();
			result = true;
			ps.close();
			konekcija.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean insertTeretni(Rezervacija_Leta rezervacijaLeta) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero", "student",
					"student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_INSERT_TERETNI);
			ps.setDate(1, rezervacijaLeta.getDatum_leta());
			ps.setString(2, rezervacijaLeta.getPolazna_lokacija());
			ps.setString(3, rezervacijaLeta.getOdrediste());
			ps.setString(4, rezervacijaLeta.getOpis_tereta());
			ps.setString(5, rezervacijaLeta.getSpecifikacija_robe());
			ps.setString(6, rezervacijaLeta.getStatus_rezervacije());
			ps.setInt(7, rezervacijaLeta.getKorisnik_idKorisnik());
			
			ps.executeUpdate();
			result = true;
			ps.close();
			konekcija.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Rezervacija_Leta> returnRezervacijaById(int Korisnik_idKorisnik){
		ArrayList<Rezervacija_Leta> rezervacije = new ArrayList<Rezervacija_Leta>();
		Rezervacija_Leta rezervacija = null;
		try {
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero",
					"student", "student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_RETURN_REZERVACIJA_BY_ID);
			ps.setInt(1, Korisnik_idKorisnik);
			ResultSet rezultat = ps.executeQuery();
			while (rezultat.next()) {
				Integer idRezervacija_leta = rezultat.getInt(1);
				Date datum_leta =  rezultat.getDate(2);
				String polazna_lokacija =  rezultat.getString(3);
				String odrediste =  rezultat.getString(4);
				Integer broj_mjesta =  rezultat.getInt(5);
				String opis_tereta =  rezultat.getString(6);
				String specifikacija_robe =  rezultat.getString(7);
				String status_rezervacije =  rezultat.getString(8);
				String razlog_ponistavanja =  rezultat.getString(9);
				Integer Korisnik_idKorisnikBaza =  rezultat.getInt(10);
				
				rezervacija = new Rezervacija_Leta(idRezervacija_leta, datum_leta, polazna_lokacija, odrediste, broj_mjesta, opis_tereta, specifikacija_robe, status_rezervacije, razlog_ponistavanja, Korisnik_idKorisnikBaza);
				rezervacije.add(rezervacija);
			}
			rezultat.close();
			ps.close();
			konekcija.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rezervacije;
	}
	
	public void ponistiRezervaciju(int idrezervacije, String razlogPonistavanja) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/etfbl_ip_aero", "student",
					"student");
			PreparedStatement ps = konekcija.prepareStatement(SQL_UPDATE_REZERVACIJA);
			ps.setString(1, "ponistena");
			ps.setString(2, razlogPonistavanja);
			ps.setInt(3, idrezervacije);
			ps.executeUpdate();
			ps.close();
			konekcija.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
