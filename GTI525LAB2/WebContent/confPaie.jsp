<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="modele.Client"%>
<%@ page import="modele.Panier"%>
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
<% Panier p1 = (Panier)request.getSession().getAttribute("panier"); %>
<% Client client = (Client)request.getAttribute("Client"); %>

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
			<div class="alert">
				<h2>Confirmation</h2>					
				<!-- start content -->
		<div id="content">
		        <% for (int i=0; i<p1.getPanier().length;i++){%>		             
                    <div class="panier">                    			
						<h5  >Nom de la salle : <i><%=p1.getPanier()[i].getRep().getSalle().getNom()%></i></h5>
						<h5  >Date de la représentation : <i><%=p1.getPanier()[i].getRep().getDate()%></i> </h5>
						<h5  >Nombre de billets pour cette représentation : <i><%=p1.getPanier()[i].getNbBillets()%></i> </h5>
						<h5  >Prix total : <i><%=p1.getPanier()[i].getPrixTot() %> $ </i> </h5>
						<h1>--------------------------------------------------------------</h1>  
						
						
					</div>
                <%}%>
		</div>
		<h3>Facturé à : </h3>
                <h5  >Nom  : <i><%=client.getNomClient()%> , <%=client.getPreClient() %> </i></h5>
				<h5  >Carte de credit # XXXX-XXXX-XXXX-<i><%=client.getCCs()%></i> </h5>
		<!-- end content -->
	
				<form method="post" action="./">
								<input type="hidden" name="action" id="action" value="processPaiement" />
								<input type="submit" value="Soumettre">
							</form>
			</div>
		</div>
		<!-- end content -->
		<!-- start sidebar -->
		<%@ include file="frame/sidebar.jsp" %>
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
