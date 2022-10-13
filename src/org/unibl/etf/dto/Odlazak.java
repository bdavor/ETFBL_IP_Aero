package org.unibl.etf.dto;

import java.sql.Date;

public class Odlazak {
	
	protected Integer idOdlazak;
	protected String polazna_lokacija;
	protected String odrediste;
	protected Date vrijeme_odlaska;
	protected String status;
	protected String vrsta_leta;

	public Odlazak() {
		// TODO Auto-generated constructor stub
	}
	
	public Odlazak (Integer idOdlazak, String polazna_lokacija, String odrediste, Date vrijeme_odlaska, String status, String vrsta_leta) {
		this.idOdlazak = idOdlazak;
		this.polazna_lokacija = polazna_lokacija;
		this.odrediste = odrediste;
		this.vrijeme_odlaska = vrijeme_odlaska;
		this.status = status;
		this.vrsta_leta = vrsta_leta;
	}

	public Integer getIdOdlazak() {
		return idOdlazak;
	}

	public void setIdOdlazak(Integer idOdlazak) {
		this.idOdlazak = idOdlazak;
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

	public Date getVrijeme_odlaska() {
		return vrijeme_odlaska;
	}

	public void setVrijeme_odlaska(Date vrijeme_odlaska) {
		this.vrijeme_odlaska = vrijeme_odlaska;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVrsta_leta() {
		return vrsta_leta;
	}

	public void setVrsta_leta(String vrsta_leta) {
		this.vrsta_leta = vrsta_leta;
	}

}
