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
		<%@ include file="frame/banner.jsp"%>
		<%@ include file="frame/menu.jsp"%>
	</div>
	<hr />
	<!-- end header -->
	<!-- start page -->
	<div id="wrapper">
		<div id="page">
			<script language="Javascript">
				function checkEmail() {
					if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
							.test(form.CourrielClient.value)) {
						return true;
					}
					return false;
				}
				function checkName(str) {
					var re = /[^a-zA-Z]/g
					if (re.test(str))
						return false;
					return true;
				}
				function checkNumber(str) {
					if (str.isInteger)
						return false;
					return true;
				}
				function isInteger(c) {
					return ((c >= "0") && (c <= "9"))
				}
				

				function validate() {

					var NomClient = document.form.NomClient;
					var PreClient = document.form.PreClient;
					var CourrielClient = document.form.CourrielClient;
					var AddrClient = document.form.AddrClient;
					var VilleClient = document.form.VilleClient;
					var ProvinceClient = document.form.ProvinceClient;
					var PaysClient = document.form.PaysClient;
					var CCClient = document.form.CCClient;
					var ExpMClient = document.form.ExpMClient;
					var ExpAClient = document.form.ExpAClient;
					var SecClient = document.form.SecClient;

					if ((NomClient.value == null) || (NomClient.value == "")) {
						alert("Veuillez inscrire votre nom")
						NomClient.focus();
						return false
					}
					if (checkName(NomClient.value) == false) {
						NomClient.value = "";
						alert("Format de nom invalide");
						NomClient.focus();
						return false;
					}
					if ((PreClient.value == null) || (PreClient.value == "")) {
						alert("Veuillez inscrire votre nom");
						PreClient.focus();
						return false;
					}
					if (checkName(PreClient.value) == false) {
						PreClient.value = "";
						alert("Format de nom invalide");
						PreClient.focus();
						return false;
					}
					if ((CourrielClient.value == null)
							|| (CourrielClient.value == "")) {
						alert("Veuillez inscrire un courriel");
						CourrielClient.focus();
						return false;
					}
					if (checkEmail(CourrielClient.value) == false) {
						CourrielClient.value = "";
						alert("Format de courriel Invalide");
						CourrielClient.focus();
						return false;
					}

					if ((AddrClient.value == null) || (AddrClient.value == "")) {
						alert("Veuillez inscrire une adresse");
						AddrClient.focus();
						return false;
					}

					if ((VilleClient.value == null)
							|| (VilleClient.value == "")) {
						alert("Veuillez inscrire une ville");
						VilleClient.focus();
						return false;
					}
					if (checkName(VilleClient.value) == false) {
						VilleClient.value = "";
						alert("Format de nom de ville invalide");
						VilleClient.focus();
						return false;
					}

					if ((ProvinceClient.value == null)
							|| (ProvinceClient.value == "")) {
						alert("Veuillez inscrire une province");
						ProvinceClient.focus();
						return false;
					}
					if (checkName(ProvinceClient.value) == false) {
						ProvinceClient.value = "";
						alert("Format de nom de Province invalide");
						ProvinceClient.focus();
						return false
					}

					if ((PaysClient.value == null) || (PaysClient.value == "")||(PaysClient.value != "Canada")) {
						alert("Vous devez etre au Canada");
						PaysClient.focus();
						return false;
					}
					if (checkName(PaysClient.value) == false) {
						PaysClient.value = "";
						alert("Format de nom de Pays invalide");
						PaysClient.focus();
						return false;
					}
					if ((CCClient.value == null) || (CCClient.value == "") || !/^[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]$/.test(CCClient.value)) {
						alert("Veuillez un numéro de carte de crédit de 16 chiffres dans le format suivant XXXX-XXXX-XXXX-XXXX");
						CCClient.focus();
						return false;
					}

					if ((ExpMClient.value == null) || (ExpMClient.value == "" || parseInt(ExpMClient.value)<0 || parseInt(ExpMClient.value)>12)) {
						alert("Veuillez un mois d'expiration");
						ExpMClient.focus();
						return false;
					}
					if (isInteger(ExpMClient.value) == false) {
						ExpMClient.value = "";
						alert("Format du mois d'expiration invalide");
						ExpMClient.focus();
						return false;
					}
					if ((ExpAClient.value == null) || (ExpAClient.value == ""|| parseInt(ExpAClient.value)<2012 || parseInt(ExpAClient.value)>3000)) {
						alert("Veuillez une année d'expiration");
						ExpAClient.focus();
						return false;
					}
					if (isInteger(ExpAClient.value) == false) {
						ExpAClient.value = "";
						alert("Format de l'année d'expiration invalide");
						ExpAClient.focus();
						return false;
					}
					if (!/^[0-9][0-9][0-9]$/.test(SecClient.value)) {
						alert("Le code de sécurité est 3 chiffres");
						SecClient.focus();
						return false;
					}

					return true

				}
			</script>

			<!-- start content -->
			<div id="content">
				<h1>Paiement</h1>
				<form name="form" method="post" action="./"
					onSubmit="return validate()">
					<ul align='left'>
						<li>Nom : <input type="text" name="NomClient" value='Smith'></li>
						<li>Prénom : <input type="text" name="PreClient" value='John' /></li>
						<li>Courriel :<input type="text" name="CourrielClient"
							value='john.smith@etsmtl.ca' /></li>
						<li>Adresse :<input type="text" name="AddrClient"
							value='1110 Notre-Dame' /></li>
						<li>Ville :<input type="text" name="VilleClient"
							value='Montreal' /></li>
						<li>Province :<input type="text" name="ProvinceClient"
							value='Quebec' /></li>
						<li>Pays :<input type="text" name="PaysClient" value='Canada' /></li>
						<li>Carte de crédit :<input type="text" name="CCClient"
							value='1324-1234-1234-1234' /></li>
						<li>Mois Expiration :<input type="text" name="ExpMClient"
							value='12' /></li>
						<li>Année Expiration :<input type="text" name="ExpAClient"
							value='2014' /></li>
						<li>Code de sécurité :<input type="text" name="SecClient"
							value='123' /></li>
						<input type="hidden" name="action" id="action"
							value="preparePaiement" />
						<p>
							<input type="submit" value="Payer" /> <input type='button'
								name='update' value='Annuler'
								ONCLICK="window.location.href='panier.jsp'" />
						</p>

					</ul>
				</form>


			</div>
			<!-- end content -->
			<!-- start sidebar -->
			<%@ include file="frame/sidebar.jsp"%>
			<!-- end sidebar -->
			<br style="clear: both;" />
		</div>
	</div>
	<!-- end page -->
	<!-- start footer -->
	<%@ include file="frame/footer.jsp"%>
	<!-- end footer -->
	</div>
</body>
</html>
