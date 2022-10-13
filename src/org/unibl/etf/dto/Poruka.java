package org.unibl.etf.dto;

public class Poruka {
	
	protected Integer idPoruka;
	protected String email_korisnika;
	protected String naslov;
	protected String poruka;
	protected String procitana_neprocitana;

	public Poruka() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdPoruka() {
		return idPoruka;
	}

	public void setIdPoruka(Integer idPoruka) {
		this.idPoruka = idPoruka;
	}

	public String getEmail_korisnika() {
		return email_korisnika;
	}

	public void setEmail_korisnika(String email_korisnika) {
		this.email_korisnika = email_korisnika;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getPoruka() {
		return poruka;
	}

	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}

	public String getProcitana_neprocitana() {
		return procitana_neprocitana;
	}

	public void setProcitana_neprocitana(String procitana_neprocitana) {
		this.procitana_neprocitana = procitana_neprocitana;
	}

}
