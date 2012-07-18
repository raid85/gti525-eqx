<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

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
				<h3>Erreur !</h>
				<h2>La quantité  de billets doit être un nombre et le total de billets dans le panier est 6 billets</h2>
				<br />		
				<br />	
				<input type='button' name='acheter' value='Page daccueil' ONCLICK="window.location.href='./'"/>
				
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