
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
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="modele.TORepresentations"%>
<%@ page import="modele.Representation"%>
<%
TORepresentations monTO = (TORepresentations)request.getAttribute("spectacle");
Representation[] representations = monTO.getRepresentations(); 
%>
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
		<div id="content">
			<!-- start spectacle -->
			<div class="spectacle">
					<p class="date">mar<b>03</b></p>
					<h2 class="title"><%=monTO.getSpectacle().getNom()%></h2>
					
					<img  class="picture" src=<%=monTO.getSpectacle().getImage()%> />
					<div class="entry">
						<%=monTO.getSpectacle().getDescription()%>
					</div>
					<% for (int i=0; i<representations.length;i++){%>
						<div class="representation">
							<p class = "date"> <%=representations[i].getDate().toString() %> </p>
							<h3 class="salle"><%=representations[i].getSalle().getNom()%> </h3>
							<form method="post" action="./">
								<input type="hidden" name="action" id="action" value="reserverBillets" />
								<input type="hidden" name="repId" id="repId" value="<%=representations[i].getId() %>" />
								<!--  <input type="hidden" name="spectacle" id="spectacle" value="spectacle.getId()" /> -->
								Quantité: <input type="text" name="qte" id="qte" size="20" maxlength="140">	
								<input type="submit" value="Confirmer">
							</form>
							
							<h3 class="prix"> Prix : <%=Double.toString(representations[i].getPrix())%> </h3>
							<h4 class="places"> Nb de places restantes : <%=representations[i].getBilletsDispo() %> </h4>
						</div>
					<%}%>
			</div>
			<!-- end spectacle -->
		</div>
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
