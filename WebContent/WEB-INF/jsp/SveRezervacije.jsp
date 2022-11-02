<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.unibl.etf.dto.Korisnik" %>
<%@ page import="org.unibl.etf.dto.Rezervacija_Leta" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="org.unibl.etf.dao.Rezervacija_LetaDao" %>
<jsp:useBean id="rezervacijaBean" class="org.unibl.etf.dao.Rezervacija_LetaDao" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<title>Sve rezervacije</title>
</head>
<body>
	<h3>Sve Vaše rezervacije</h3>
	<!-- Home link -->
	<div class="row">
		<div
			class="offset-xs-4 offset-sm-4 offset-md-4 col-xs-6 col-sm-6 col-md-6">
			<a href="<%=request.getContextPath()%>/GlavniServlet?action=pocetna"
				class="text-center" style="width: 100%">Pocetna stranica</a>
		</div>
	</div>
	<%Korisnik user = (Korisnik)session.getAttribute("prijavljeni korisnik"); %>
	<table>
		<tr>
		<td>ID rezervacije</td>
		<td>Datum leta</td>
		<td>Polazna lokacija</td>
		<td>Odredište</td>
		<%if("putnicki".equals(user.getPutnicki_teretni())){ %>
		<td>Broj mjesta</td>
		<%} %>
		<%if("teretni".equals(user.getPutnicki_teretni())){  %>
		<td>Opis tereta</td>
		<td>Specifikacija robe</td>
		<%} %>
		<td>Status rezervacije</td>
		<td>Razlog poništavanja</td>
		<td>Poništavanje</td>
		</tr>
		<%ArrayList<Rezervacija_Leta> rezervacije = rezervacijaBean.returnRezervacijaById(user.getIdKorisnik());
		for(int i = 0; i < rezervacije.size(); i++){ %>
		<tr>
		<td><%=rezervacije.get(i).getIdRezervacija_leta() %></td>
		<td><%=rezervacije.get(i).getDatum_leta() %></td>
		<td><%=rezervacije.get(i).getPolazna_lokacija() %></td>
		<td><%=rezervacije.get(i).getOdrediste() %></td>
		<%if("putnicki".equals(user.getPutnicki_teretni())){ %>
		<td><%=rezervacije.get(i).getBroj_mjesta() %></td>
		<%} %>
		<%if("teretni".equals(user.getPutnicki_teretni())){  %>
		<td><%=rezervacije.get(i).getOpis_tereta() %></td>
		<td><%=rezervacije.get(i).getSpecifikacija_robe() %></td>
		<%} %>
		<td><%=rezervacije.get(i).getStatus_rezervacije() %></td>
		<td><%=rezervacije.get(i).getRazlog_ponistavanja() %></td>
		<%if("nova".equals(rezervacije.get(i).getStatus_rezervacije())){ %>
		<td> <a href="<%=request.getContextPath()%>/GlavniServlet?action=PonistiRezervaciju&id=<%=rezervacije.get(i).getIdRezervacija_leta() %>">Poništi</a></td>
		<%} %>
		</tr>
		<%} %>
	</table><br>
</body>
</html>