
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
<%@ page import="modele.Spectacle"%>
<%
Spectacle[] spectacles = (Spectacle[])request.getAttribute("spectacles");
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
		<!-- start content -->
		<div id="content">
		        <% for (int i=0; i<spectacles.length;i++){%>
                    <div class="spectacle">
						<p class="date">mar<b>03</b></p>
						<a href="./?action=afficherSpectacle&spectacleid=<%=spectacles[i].getId()%>"><h2 class="title"><%=spectacles[i].getNom()%></h2></a>
				
						<img  class="picture" src=<%=spectacles[i].getImage()%> />
						<div class="entry">
							<%=spectacles[i].getDescription() %>
						</div>
					</div>
                <%}%>
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
