<%@ page import="modele.Panier"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--

Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Title      : Simpleton 
Version    : 1.0
Released   : 20110315
Description: A two-column web design, best for your personal and business blogging.

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Billets En File</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- start header -->
<div id="header">
	<%@ include file="frame/banner.jsp" %>
	<%@ include file="frame/menu.jsp" %>
</div>
<hr />
<!-- end header -->
<!-- start page -->
<div id="wrapper">
	<div id="page">
		<!-- start content -->
		<div id="content">
			<h1> Panier </h1>
				<ul>
					<%
					Panier monPanier = (Panier)session.getAttribute("panier");
					if (monPanier.getPanier().length > 0)%>
					<%{%> 
					<%for (int i = 0; i < monPanier.getPanier().length; i++){%>
					<form method="post" action="./">
						<input type="hidden" name="action" id="action" value="changerQte" />
						<input type="hidden" name="repId" id="repId" value="<%=monPanier.getPanier()[i].getRep().getId() %>" />
						<li><a href="./?action=afficherSpectacle&spectacleId=<%=monPanier.getPanier()[i].getRep().getSpectacle()%>">IdSpectacle : <%=monPanier.getPanier()[i].getRep().getSpectacle() %> [Prix Unitaire : <%=monPanier.getPanier()[i].getRep().getPrix()%>$]</a> <input type="submit" value="ChangerQuantité"> <input type='text' name='qte' value='<%=monPanier.getPanier()[i].getNbBillets() %>' /> Sous-Total Ligne : <%=monPanier.getPanier()[i].getPrixTot()%>$</li>
					</form>
					<%}%>
					Total Panier: <%= monPanier.getTotal() %>$
					<%}%>
				</ul>
			
			<p> <input type='button' name='update' value='Paiement' ONCLICK="window.location.href='achat.jsp'"/> </p>
		</div>
		<!-- end content -->
		<!-- start sidebar -->
		<!-- end sidebar -->
		<br style="clear: both;" />
	</div>
</div>
<!-- end page -->
<!-- start footer -->
	<%@ include file="frame/footer.jsp" %>
<!-- end footer -->
</div>
</body>
</html>
