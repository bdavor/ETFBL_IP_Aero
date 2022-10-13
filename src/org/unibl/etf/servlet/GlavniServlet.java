package org.unibl.etf.servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.unibl.etf.dao.DolazakDao;
import org.unibl.etf.dao.KorisnikDao;
import org.unibl.etf.dao.LokacijaDao;
import org.unibl.etf.dao.Lokacija_GradDao;
import org.unibl.etf.dao.OdlazakDao;
import org.unibl.etf.dao.PorukaDao;
import org.unibl.etf.dao.PristupDao;
import org.unibl.etf.dao.Rezervacija_LetaDao;
import org.unibl.etf.dto.Dolazak;
import org.unibl.etf.dto.Korisnik;
import org.unibl.etf.dto.Odlazak;
import org.unibl.etf.dto.Poruka;
import org.unibl.etf.dto.Pristup;
import org.unibl.etf.dto.Rezervacija_Leta;

/**
 * Servlet implementation class GlavniServlet
 */
@WebServlet("/GlavniServlet")
public class GlavniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String USER = "prijavljeni korisnik";
	
	private static int NAME_MAX_LEN = 45;
	private static int SURNAME_MAX_LEN = 45;
	private static int USERNAME_MAX_LEN = 45;
	private static int PASSWORD_MAX_LEN = 45;
	private static int EMAIL_MAX_LEN = 45;
	private static int ADDRESS_MAX_LEN = 100;
	private static int COUNTRY_MAX_LEN = 45;
	private static int EMAIL_PORUKA_MAX_LEN = 45;
	private static int NASLOV_PORUKA_MAX_LEN = 45;
	private static int TEXT_PORUKA_MAX_LEN = 2000;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlavniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String adresa = "/WEB-INF/jsp/home.jsp";
		String action = request.getParameter("action");
		HttpSession sesija = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher(adresa);

		if(action == null || "".equals(action)) {
			adresa = "/WEB-INF/jsp/home.jsp";
			sesija.setAttribute("logged", false);
			dispatcher = request.getRequestDispatcher(adresa);
			dispatcher.forward(request, response);
		} else if ("Odjava".equals(action)) {
			sesija.invalidate();
			response.sendRedirect(request.getContextPath() + "/GlavniServlet");
		} else if("pocetna".equals(action)) {
			adresa = "/WEB-INF/jsp/home.jsp";
			dispatcher = request.getRequestDispatcher(adresa);
			dispatcher.forward(request, response);
		} else if ("SviDolasci".equals(action)) {
			
			adresa = "/WEB-INF/jsp/SviDolasci.jsp";
			dispatcher = request.getRequestDispatcher(adresa);
			dispatcher.forward(request, response);
		} else if("SviOdlasci".equals(action)) {
			
			adresa = "/WEB-INF/jsp/SviOdlasci.jsp";
			dispatcher = request.getRequestDispatcher(adresa);
			dispatcher.forward(request, response);
		} else if("sviOdlasciZahtjev".equals(action)) {
			String dan = request.getParameter("dan");
			String date = null;
			if("1".equals(dan)) {
				date = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			} else if("-1".equals(dan)) {
				date = LocalDate.now().plusDays(-1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			} else {
				date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = new Date();
			try {
				date2 = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			new OdlazakDao().updatePoletio();
			new OdlazakDao().updateSletio();
			ArrayList<Odlazak> odlasci = new OdlazakDao().returnAllOdlazak(new java.sql.Date(date2.getTime()));
			JSONObject json = new JSONObject();
			json.put("odlasci", odlasci);
			json.put("redirectUrl", request.getContextPath() + "/GlavniServlet?action=SviOdlasci");
			response.setContentType("application/json");
			try(PrintWriter pw = new PrintWriter(response.getOutputStream(), true)){
				pw.println(json.toString());
			}
		} else if("petSljedecihOdlazakaZahtjev".equals(action)) {
			String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = new Date();
			try {
				date2 = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			new OdlazakDao().updatePoletio();
			new OdlazakDao().updateSletio();
			ArrayList<Odlazak> odlasci = new OdlazakDao().returnAllOdlazak(new java.sql.Date(date2.getTime()));
			JSONObject json = new JSONObject();
			json.put("odlasci", odlasci);
			json.put("redirectUrl", request.getContextPath() + "/GlavniServlet?action=pocetna");
			response.setContentType("application/json");
			try(PrintWriter pw = new PrintWriter(response.getOutputStream(), true)){
				pw.println(json.toString());
			}
		} else if("sviDolasciZahtjev".equals(action)) {
			String dan = request.getParameter("dan");
			String date = null;
			if("1".equals(dan)) {
				date = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			} else if("-1".equals(dan)) {
				date = LocalDate.now().plusDays(-1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			} else {
				date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = new Date();
			try {
				date2 = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			new DolazakDao().updatePoletio();
			new DolazakDao().updateSletio();
			ArrayList<Dolazak> dolasci = new DolazakDao().returnAllDolazak(new java.sql.Date(date2.getTime()));
			JSONObject json = new JSONObject();
			json.put("dolasci", dolasci);
			json.put("redirectUrl", request.getContextPath() + "/GlavniServlet?action=SviDolasci");
			response.setContentType("application/json");
			try(PrintWriter pw = new PrintWriter(response.getOutputStream(), true)){
				pw.println(json.toString());
			}
		} else if("petSljedecihDolazakaZahtjev".equals(action)) {
			String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = new Date();
			try {
				date2 = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			new DolazakDao().updatePoletio();
			new DolazakDao().updateSletio();
			ArrayList<Dolazak> dolasci = new DolazakDao().returnAllDolazak(new java.sql.Date(date2.getTime()));
			JSONObject json = new JSONObject();
			json.put("dolasci", dolasci);
			json.put("redirectUrl", request.getContextPath() + "/GlavniServlet?action=pocetna");
			response.setContentType("application/json");
			try(PrintWriter pw = new PrintWriter(response.getOutputStream(), true)){
				pw.println(json.toString());
			}
		} else if("RezervacijaLeta".equals(action)) {
			
			adresa = "/WEB-INF/jsp/RezervacijaLeta.jsp";
			dispatcher = request.getRequestDispatcher(adresa);
			dispatcher.forward(request, response);
		} else if("provjeraLeta".equals(action)) {
			Korisnik user = (Korisnik)sesija.getAttribute("prijavljeni korisnik");
			String date = request.getParameter("date");
			ArrayList<Odlazak> odlasci = new OdlazakDao().readAllOdlazak(date, user.getPutnicki_teretni());
			JSONObject json = new JSONObject();
			json.put("odlasci", odlasci);
			json.put("redirectUrl", request.getContextPath() + "/GlavniServlet?action=RezervacijaLeta");
			response.setContentType("application/json");
			try(PrintWriter pw = new PrintWriter(response.getOutputStream(), true)){
				pw.println(json.toString());
			}
		} else if("readReservationCB".equals(action)) {
			ArrayList<String> drzaveIZBaze = new LokacijaDao().readAllCounty();
			JSONObject json = new JSONObject();
			json.put("drzaveIZBaze", drzaveIZBaze);
			json.put("redirectUrl", request.getContextPath() + "/GlavniServlet?action=RezervacijaLeta");
			response.setContentType("application/json");
			try(PrintWriter pw = new PrintWriter(response.getOutputStream(), true)){
				pw.println(json.toString());
			}
		} else if("readReservationCBCity".equals(action)) {
			String drzava = request.getParameter("country");
			ArrayList<String> gradoviIzBaze = new Lokacija_GradDao().readAllCity(drzava);
			JSONObject json = new JSONObject();
			json.put("gradoviIzBaze", gradoviIzBaze);
			json.put("redirectUrl", request.getContextPath() + "/GlavniServlet?action=RezervacijaLeta");
			response.setContentType("application/json");
			try(PrintWriter pw = new PrintWriter(response.getOutputStream(), true)){
				pw.println(json.toString());
			}
		} else if("rezervacijaLetaSlanjePodatakaPutnicki".equals(action)) {
			
			String date = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = new Date();
			try {
				date2 = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Korisnik user = (Korisnik)sesija.getAttribute("prijavljeni korisnik");
			String polazna_lokacija = request.getParameter("polazna_lokacija");
			String odrediste = request.getParameter("odrediste");
			String broj_mjesta = request.getParameter("broj_mjesta");
			JSONObject json = new JSONObject();
			Rezervacija_Leta rezervacijaLeta = new Rezervacija_Leta();
			rezervacijaLeta.setDatum_leta(new java.sql.Date(date2.getTime()));
			rezervacijaLeta.setPolazna_lokacija(polazna_lokacija);
			rezervacijaLeta.setOdrediste(odrediste);
			rezervacijaLeta.setBroj_mjesta(new Integer(broj_mjesta));
			rezervacijaLeta.setStatus_rezervacije("nova");
			rezervacijaLeta.setKorisnik_idKorisnik(user.getIdKorisnik());
			if(new Rezervacija_LetaDao().insert(rezervacijaLeta)) {
				json.put("result", true);
				json.put("redirectUrl", request.getContextPath() + "/GlavniServlet?action=pocetna");
			} else {
				json.put("result", false);
			}
			response.setContentType("application/json");
			try(PrintWriter pw = new PrintWriter(response.getOutputStream(), true)){
				pw.println(json.toString());
			}
		} else if("rezervacijaLetaSlanjePodatakaTeretni".equals(action)) {
			String date = request.getParameter("date");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = new Date();
			try {
				date2 = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Korisnik user = (Korisnik)sesija.getAttribute("prijavljeni korisnik");
			String polazna_lokacija = request.getParameter("polazna_lokacija");
			String odrediste = request.getParameter("odrediste");
			String opis_tereta = request.getParameter("opis_tereta");
			String specifikacija_robe = request.getParameter("specifikacija_robe");
			JSONObject json = new JSONObject();
			Rezervacija_Leta rezervacijaLeta = new Rezervacija_Leta();
			rezervacijaLeta.setDatum_leta(new java.sql.Date(date2.getTime()));
			rezervacijaLeta.setPolazna_lokacija(polazna_lokacija);
			rezervacijaLeta.setOdrediste(odrediste);
			rezervacijaLeta.setOpis_tereta(opis_tereta);
			rezervacijaLeta.setSpecifikacija_robe(specifikacija_robe);
			rezervacijaLeta.setStatus_rezervacije("nova");
			rezervacijaLeta.setKorisnik_idKorisnik(user.getIdKorisnik());
			if(new Rezervacija_LetaDao().insertTeretni(rezervacijaLeta)) {
				json.put("result", true);
				json.put("redirectUrl", request.getContextPath() + "/GlavniServlet?action=pocetna");
			} else {
				json.put("result", false);
			}
			response.setContentType("application/json");
			try(PrintWriter pw = new PrintWriter(response.getOutputStream(), true)){
				pw.println(json.toString());
			}
		} else if("SveRezervacije".equals(action)) {
			
			adresa = "/WEB-INF/jsp/SveRezervacije.jsp";
			dispatcher = request.getRequestDispatcher(adresa);
			dispatcher.forward(request, response);
		} else if("PonistiRezervaciju".equals(action)) {
			String idRezervacije = request.getParameter("id");
			new Rezervacija_LetaDao().ponistiRezervaciju(new Integer(idRezervacije), "Vi ste ponistili");
			adresa = "/WEB-INF/jsp/SveRezervacije.jsp";
			dispatcher = request.getRequestDispatcher(adresa);
			dispatcher.forward(request, response);
		} else if("slanjePoruke".equals(action)) {
			String email = request.getParameter("email");
			String naslov = request.getParameter("naslov");
			String text = request.getParameter("text");
			JSONObject json = new JSONObject();
			if(validatePorukaForm(email, naslov, text)) {
				Poruka poruka = new Poruka();
				poruka.setEmail_korisnika(email);
				poruka.setNaslov(naslov);
				poruka.setPoruka(text);
				poruka.setProcitana_neprocitana("neprocitana");
				if(new PorukaDao().insert(poruka)) {
					json.put("result", true);
					json.put("redirectUrl", request.getContextPath() + "/GlavniServlet?action=pocetna");
				} else {
					json.put("result", false);
				}
			} else {
				json.put("result", false);
			}
			response.setContentType("application/json");
			try(PrintWriter pw = new PrintWriter(response.getOutputStream(), true)){
				pw.println(json.toString());
			}
		} else if("Registracija".equals(action)) {
			adresa = "/WEB-INF/jsp/Registracija.jsp";
			dispatcher = request.getRequestDispatcher(adresa);
			dispatcher.forward(request, response);
		} else if("registracijaSlanjePodataka".equals(action)) {
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String country = request.getParameter("country");
			String account = request.getParameter("account");
			
			JSONObject json = new JSONObject();
			if(validateFormData(name, surname, username, password, email, address, country)) {
				Korisnik user = new Korisnik();
				user.setIme(name);
				user.setPrezime(surname);
				user.setKorisnickoIme(username);
				user.setLozinka(password);
				user.setEmail(email);
				user.setAdresa(address);
				user.setDrzava(country);
				user.setPutnicki_teretni(account);
				user.setAdmin_kor_zap("Korisnik");
				
				if(new KorisnikDao().insert(user)) {
					json.put("result", true);
					json.put("redirectUrl", request.getContextPath() + "/GlavniServlet?action=pocetna");
				}else {
					json.put("result", false);
				}
			}else {
				json.put("result", false);
			}
			
			response.setContentType("application/json");
			try(PrintWriter pw = new PrintWriter(response.getOutputStream(), true)){
				pw.println(json.toString());
			}				
			
		} else if("check-username".equals(action)) {
			String username = request.getParameter("username");
			if(null != username && !"".equals("username")) {
				boolean res =  new KorisnikDao().existsUsername(username);
				JSONObject json = new JSONObject();
				json.put("exists", res);
				response.setContentType("application/json");
				try(PrintWriter pw = new PrintWriter(response.getOutputStream(), true)){
					pw.println(json.toString());
				}			
			}
			
		} else if("check-email".equals(action)) {
			String email = request.getParameter("email");
			if(null != email && !"".equals(email)) {
				boolean res = new KorisnikDao().existsEmail(email);
				JSONObject json = new JSONObject();
				json.put("exists", res);
				response.setContentType("application/json");
				try(PrintWriter pw = new PrintWriter(response.getOutputStream(), true)){
					pw.println(json.toString());
				}
			}
			
		} else if ("prijava".equals(action)) {
			 JSONObject responseJson = new JSONObject();
			 JSONObject dataJson = new JSONObject();
			 String username = request.getParameter("username");
			 String password = request.getParameter("password");
			 Korisnik user = new KorisnikDao().returnKorisnik(username, password);
			 if(validateLoginData(username, password) && (user != null)) {
				 		
				sesija = request.getSession(true);
				sesija.setAttribute(USER, user);
				sesija.setAttribute("logged", true);
					
				response.setContentType("application/json");
				response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
				   
				dataJson.put("redirectUrl", request.getContextPath() + "/GlavniServlet?action=pocetna");
				    
				responseJson.put("isLoggedIn", true);
				responseJson.put("data", dataJson);
				login();
			 } else {
				 sesija.setAttribute("logged", false);
				 responseJson.put("reason", "Korisnik ne postoji");
				 responseJson.put("isLoggedIn", false);
			 }
			 
			 try(PrintWriter pw = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8), true)){
				 pw.write(responseJson.toString());
			 }
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean validateLoginData(String username, String password) {
		boolean result = false;
		if(
				(null != username && 0 < username.length() && 45 >= username.length()) &&
				(null != password && 0 < password.length() && 500 >= password.length())
				) {
			result = true;
		}
		return result;
	}
	
	private boolean validateFormData(String name, String surname, String username, String password, String email, String address, String country) {
		return
			null != name && 0 < name.length() && NAME_MAX_LEN >= name.length() &&
			null != surname && 0 < surname.length() && SURNAME_MAX_LEN >= surname.length() &&
			null != username && 0 < username.length() && USERNAME_MAX_LEN >= username.length() && !new KorisnikDao().existsUsername(username) &&
			null != password && 0 < password.length() && PASSWORD_MAX_LEN >= password.length() && 
			null != email && 0 < email.length() && EMAIL_MAX_LEN >= email.length() && !new KorisnikDao().existsEmail(email) &&
			null != address && 0 < address.length() && ADDRESS_MAX_LEN >= address.length() &&
			null != country && 0 < country.length() && COUNTRY_MAX_LEN >= country.length();
	}
	
	private boolean validatePorukaForm(String email, String naslov, String text) {
		return 
			null != email && 0 < email.length() && EMAIL_PORUKA_MAX_LEN >= email.length() &&
			null != naslov && 0 < naslov.length() && NASLOV_PORUKA_MAX_LEN >= naslov.length() &&
			null != text && 0 < text.length() && TEXT_PORUKA_MAX_LEN >= text.length();
	}
	
	private void login() {
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		int update = 0;
		ArrayList<Pristup> pristupi = new PristupDao().readPristup();
		if(pristupi.size() != 0) {	
			int brojPristupa = pristupi.get(0).getBroj_pristupa() + 1;
			pristupi.get(0).setBroj_pristupa(brojPristupa);
			new PristupDao().update(pristupi.get(0));
			update ++;
			if(update == 0) {
				Pristup pr = new Pristup();
				pr.setDatum(sqlDate);
				pr.setBroj_pristupa(1);
				new PristupDao().insert(pr);
			}
		}else {
			Pristup pr = new Pristup();
			pr.setDatum(sqlDate);
			pr.setBroj_pristupa(1);
			new PristupDao().insert(pr);
		}
	}

}
