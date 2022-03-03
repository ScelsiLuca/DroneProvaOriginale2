<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="DAO.StazioniDAO"%>
<%@page import="Model.*"%>
<%@page import="java.util.*"%>

<%
	StazioniDAO stdao = new StazioniDAO();
	List<Stazioni> numStazioni = stdao.selectAllStazioni() ; 
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Mappa </title>

    <link rel="stylesheet" href="home.css">
    <link rel="stylesheet" href="map.css">
</head>
<body>

    <!--Header-->
    <header>
        <a href="#" class="logo"><img src="img/icon.png" alt=""></a>

        <div class="bx bx-menu" id="menu-icon"> </div>
        <ul class="navbar">
            <li><a href="#home">Torna al sito</a></li>
        </ul>
        <div class="header-btn">
            <label class="sign-in">Il mio profilo</label>
            <label class="sign-out">Log-out</label>
        </div>
    </header>

    <!-- MAPPA -->
    <div id="map"></div>
    
    <h2 id="scegli">Scegli una stazione</h2>

    <!-- CARDS -->
 
    <div class="row">
    <%
	if (!numStazioni.isEmpty()) {
		for (Stazioni s : numStazioni) {
			int quantita = stdao.quantityDroni(s.getNome()) ; 
			
			String link = "prenotazioni.html" ; 
			String style = "" ; 
			if (quantita <= 0) {
				link = "#" ;
				style = "style='background-color: gray;'" ; 
			}
	%>
        <div class="column">       
        <a href=<%=link%>>
            <div class="card" <%=style%>>
                <h3><%=s.getNome() %></h3>
                <p>Droni disponibili: <%=quantita%></p>
            </div>
            </a>
        </div>
      <%
		}
	} else {
		out.println("There is no station");
	}
	%>  
    </div>
 
    <!-- END OF CARDS -->

    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCKNYTwiTiyiOM85MQaWLjv6XNoKO3uIvc&callback=initMap&sensor=true">
    </script>

    <script src="map.js"></script>
    <script src="script.js"></script>
</body>
</html>