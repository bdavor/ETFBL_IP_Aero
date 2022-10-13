package org.unibl.etf.dto;

import java.sql.Date;

public class Rezervacija_Leta {
	
	protected Integer idRezervacija_leta;
	protected Date datum_leta;
	protected String polazna_lokacija;
	protected String odrediste;
	protected Integer broj_mjesta;
	protected String opis_tereta;
	protected String specifikacija_robe;
	protected String status_rezervacije;
	protected String razlog_ponistavanja;
	protected Integer Korisnik_idKorisnik;

	public Rezervacija_Leta() {
		// TODO Auto-generated constructor stub
	}
	
	public Rezervacija_Leta(Integer idRezervacija_leta, Date datum_leta, String polazna_lokacija, String odrediste, Integer broj_mjesta, String opis_tereta, String specifikacija_robe, String status_rezervacije, String razlog_ponistavanja, Integer Korisnik_idKorisnik) {
		this.idRezervacija_leta = idRezervacija_leta;
		this.datum_leta = datum_leta;
		this.polazna_lokacija = polazna_lokacija;
		this.odrediste = odrediste;
		this.broj_mjesta = broj_mjesta;
		this.opis_tereta = opis_tereta;
		this.specifikacija_robe = specifikacija_robe;
		this.status_rezervacije = status_rezervacije;
		this.razlog_ponistavanja = razlog_ponistavanja;
		this.Korisnik_idKorisnik= Korisnik_idKorisnik;
	}

	public Integer getIdRezervacija_leta() {
		return idRezervacija_leta;
	}

	public void setIdRezervacija_leta(Integer idRezervacija_leta) {
		this.idRezervacija_leta = idRezervacija_leta;
	}

	public Date getDatum_leta() {
		return datum_leta;
	}

	public void setDatum_leta(Date datum_leta) {
		this.datum_leta = datum_leta;
	}

	public String getPolazna_lokacija() {
		return polazna_lokacija;
	}

	public void setPolazna_lokacija(String polazna_lokacija) {
		this.polazna_lokacija = polazna_lokacija;
	}

	public String getOdrediste() {
		return odrediste;
	}

	public void setOdrediste(String odrediste) {
		this.odrediste = odrediste;
	}

	public Integer getBroj_mjesta() {
		return broj_mjesta;
	}

	public void setBroj_mjesta(Integer broj_mjesta) {
		this.broj_mjesta = broj_mjesta;
	}

	public String getOpis_tereta() {
		return opis_tereta;
	}

	public void setOpis_tereta(String opis_tereta) {
		this.opis_tereta = opis_tereta;
	}

	public String getSpecifikacija_robe() {
		return specifikacija_robe;
	}

	public void setSpecifikacija_robe(String specifikacija_robe) {
		this.specifikacija_robe = specifikacija_robe;
	}

	public String getStatus_rezervacije() {
		return status_rezervacije;
	}

	public void setStatus_rezervacije(String status_rezervacije) {
		this.status_rezervacije = status_rezervacije;
	}

	public String getRazlog_ponistavanja() {
		return razlog_ponistavanja;
	}

	public void setRazlog_ponistavanja(String razlog_ponistavanja) {
		this.razlog_ponistavanja = razlog_ponistavanja;
	}

	public Integer getKorisnik_idKorisnik() {
		return Korisnik_idKorisnik;
	}

	public void setKorisnik_idKorisnik(Integer korisnik_idKorisnik) {
		Korisnik_idKorisnik = korisnik_idKorisnik;
	}

}
