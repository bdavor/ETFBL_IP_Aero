package org.unibl.etf.dto;

public class Korisnik {
	
	protected Integer idKorisnik;
	protected String ime;
	protected String prezime;
	protected String korisnickoIme;
	protected String lozinka;
	protected String email;
	protected String adresa;
	protected String drzava;
	protected String putnicki_teretni;
	protected String admin_kor_zap;

	public Korisnik() {
		// TODO Auto-generated constructor stub
	}
	
	public Korisnik(Integer idKorisnik, String ime, String prezime, String korisnickoIme, String lozinka, String email, String adresa, String drzava, String putnicki_teretni, String admin_kor_zap) {
		this.idKorisnik = idKorisnik;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.adresa = adresa;
		this.drzava = drzava;
		this.putnicki_teretni = putnicki_teretni;
		this.admin_kor_zap = admin_kor_zap;
	}

	public Integer getIdKorisnik() {
		return idKorisnik;
	}

	public void setIdKorisnik(Integer idKorisnik) {
		this.idKorisnik = idKorisnik;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getPutnicki_teretni() {
		return putnicki_teretni;
	}

	public void setPutnicki_teretni(String putnicki_teretni) {
		this.putnicki_teretni = putnicki_teretni;
	}

	public String getAdmin_kor_zap() {
		return admin_kor_zap;
	}

	public void setAdmin_kor_zap(String admin_kor_zap) {
		this.admin_kor_zap = admin_kor_zap;
	}

	@Override
	public String toString() {
		return "Korisnik [idKorisnik=" + idKorisnik + ", ime=" + ime + ", prezime=" + prezime + ", korisnickoIme="
				+ korisnickoIme + ", lozinka=" + lozinka + ", email=" + email + ", adresa=" + adresa + ", drzava="
				+ drzava + ", putnicki_teretni=" + putnicki_teretni + ", admin_kor_zap=" + admin_kor_zap + "]";
	}

}
