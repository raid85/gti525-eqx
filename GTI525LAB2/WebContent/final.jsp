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
			<div class="alert">
				<h2>Félicitation !!</h2>
					<p> <h3> Numéro de confirmation : <b>1234567890</b> </h3> </p>
				
					<p><b>3</b> billets pour <b>Lise Dion</b></p>
					<p><b>3</b> billets pour <b>Elvis</b></p>
					<p>360$</p>
				<ul>
					<li> Nom : Smith </li>
					<li> Prénom : John </li>
					<li> Courriel : john.smith@etsmtl.ca </li>
					<li> Adresse : 1110 Notre-Dame </li>
					<li> Ville : Montréal </li>
					<li> Province : Québec </li>
					<li> Pays : Canada </li>
					<li> Carte de crédit : 1111 2222 3333 4444 5555 </li>
					<li> Expiration : 12-12 </li>
				</ul>
				<p> <input type='button' name='update' value='Page daccueil' ONCLICK="window.location.href='index.jsp'"/> </p>
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
<div id="footer">
<p id="legal"> &copy;2011 Simpleton . All Rights Reserved.
	&nbsp;&nbsp;&bull;&nbsp;&nbsp;
	Design by <a href="http://www.freecsstemplates.org/">Free CSS Templates</a> &nbsp;&nbsp;&bull;&nbsp;&nbsp;
	Icons by <a href="http://famfamfam.com/">FAMFAMFAM</a>.	<a href="http://validator.w3.org/check/referer" class="xhtml" title="This page validates as XHTML">Valid <abbr title="eXtensible HyperText Markup Language">XHTML</abbr></a> &nbsp;&nbsp;&bull;&nbsp;&nbsp; <a href="http://jigsaw.w3.org/css-validator/check/referer" class="css" title="This page validates as CSS">Valid <abbr title="Cascading Style Sheets">CSS</abbr></a> </p>
<!-- end footer -->
</div>
</body>
</html>
