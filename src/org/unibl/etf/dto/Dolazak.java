package org.unibl.etf.dto;

import java.sql.Date;

public class Dolazak {
	
	protected Integer idDolazak;
	protected String polazna_lokacija;
	protected String odrediste;
	protected Date vrijeme_polaska;
	protected String status;
	protected String vrsta_leta;

	public Dolazak() {
		// TODO Auto-generated constructor stub
	}
	
	public Dolazak(Integer idDolazak, String polazna_lokacija, String odrediste, Date vrijeme_polaska, String status, String vrsta_leta) {
		this.idDolazak = idDolazak;
		this.polazna_lokacija = polazna_lokacija;
		this.odrediste = odrediste;
		this.vrijeme_polaska = vrijeme_polaska;
		this.status = status;
		this.vrsta_leta = vrsta_leta;
	}

	public Integer getIdDolazak() {
		return idDolazak;
	}

	public void setIdDolazak(Integer idDolazak) {
		this.idDolazak = idDolazak;
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

	public Date getVrijeme_polaska() {
		return vrijeme_polaska;
	}

	public void setVrijeme_polaska(Date vrijeme_polaska) {
		this.vrijeme_polaska = vrijeme_polaska;
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
