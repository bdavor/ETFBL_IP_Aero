package org.unibl.etf.dto;

import java.sql.Date;

public class Pristup {
	
	protected Integer idPristup;
	protected Date datum;
	protected Integer broj_pristupa;

	public Pristup() {
		// TODO Auto-generated constructor stub
	}
	
	public Pristup(Integer idPristup, Date datum, Integer broj_pristupa) {
		this.idPristup = idPristup;
		this.datum = datum;
		this.broj_pristupa = broj_pristupa;
	}

	public Integer getIdPristup() {
		return idPristup;
	}

	public void setIdPristup(Integer idPristup) {
		this.idPristup = idPristup;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Integer getBroj_pristupa() {
		return broj_pristupa;
	}

	public void setBroj_pristupa(Integer broj_pristupa) {
		this.broj_pristupa = broj_pristupa;
	}

}
