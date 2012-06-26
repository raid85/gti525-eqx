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
			<h1>Paiement</h1>
			<ul>
				<li> Nom <input type='text' name='qte' value='Smith' /> </li>
				<li> Prénom <input type='text' name='qte' value='John' /> </li>
				<li> Courriel <input type='text' name='qte' value='john.smith@etsmtl.ca' /> </li>
				<li> Adresse <input type='text' name='qte' value='1110 Notre-Dame' /> </li>
				<li> Ville <input type='text' name='qte' value='Montréal' /> </li>
				<li> Province <input type='text' name='qte' value='Québec' /> </li>
				<li> Pays <input type='text' name='qte' value='Canada' /> </li>
				<li> Carte de crédit <input type='text' name='qte' value='1111 2222 3333 4444 5555' /> </li>
				<li> Expiration (MM-YY) <input type='text' name='qte' value='12-12' /> </li>

			</ul>
			<p> <input type='button' name='update' value='Payer' ONCLICK="window.location.href='confPaie.jsp'"/> <input type='button' name='update' value='Annuler' ONCLICK="window.location.href='panier.jsp'"/> </p>
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
