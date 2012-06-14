
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
<%
String titre = (String)request.getAttribute("titre");
String description = (String)request.getAttribute("description");
String image = (String)request.getAttribute("image");
String[] salles = (String[])request.getAttribute("salles");
int[] places = (int[])request.getAttribute("places");
int[] jours = (int[])request.getAttribute("jours");
int[] mois = (int[])request.getAttribute("mois");
int[] annees = (int[])request.getAttribute("annee");
int[] heures = (int[])request.getAttribute("heure");
int[] minutes = (int[])request.getAttribute("minutes");
double[] prix = (double[])request.getAttribute("prix");
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
	<div id="logo">
		<h1><a href="#">Billets En File</a></h1>
		<p><a href="http://www.freecsstemplates.org/">Design by Free CSS Templates</a></p>
	</div>
	<div id="menu">
		<ul>
			<li><a href="index.jsp">Maison</a></li>
			<li><a href="http://www.google.com">Èvènements</a></li>
			<li><a href="http://www.cyberpresse.ca">Mon Panier</a></li>
			<li><a href="http://www.rds.ca">Contact </a></li>
		</ul>
	</div>
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
					<h2 class="title"><%=titre%></h2>
					
					<img  class="picture" src=<%=image%> />
					<div class="entry">
						<%=description%>
					</div>
					<% for (int i=0; i<salles.length;i++){%>
						<div class="representation">
							<p class = "date"> <%=jours[i] %> <%=mois[i] %> <%=annees[i] %> - <%=heures[i] %>:<%=minutes[i] %> </p>
							<h3 class="salle"><%=salles[i]%> </h3>
							<form class="acheter">
								Quantité: <input type="text" name="qte" class="qte"/> <input type='button' name='acheter' value='Réserver' ONCLICK="window.location.href='reserver.jsp'"/>
							</form>
							<h3 class="prix"> Prix : <%=Double.toString(prix[i])%> </h3>
							<h4 class="places"> Nb de places restantes : <%=places[i] %> </h4>
						</div>
					<%}%>
			</div>
			<!-- end spectacle -->
		</div>
		<!-- start sidebar -->
		<div id="sidebar">
				<li id="calendar">
					<h2>Calendar</h2>
					<div id="calendar_wrap">
						<table id="wp-calendar" summary="Calendar">
							<caption>
							September 2008
							</caption>
							<thead>
								<tr>
									<th abbr="Monday" scope="col" title="Monday">M</th>
									<th abbr="Tuesday" scope="col" title="Tuesday">T</th>
									<th abbr="Wednesday" scope="col" title="Wednesday">W</th>
									<th abbr="Thursday" scope="col" title="Thursday">T</th>
									<th abbr="Friday" scope="col" title="Friday">F</th>
									<th abbr="Saturday" scope="col" title="Saturday">S</th>
									<th abbr="Sunday" scope="col" title="Sunday">S</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<td abbr="July" colspan="3" id="prev"><a href="#">&laquo; Jul</a></td>
									<td class="pad">&nbsp;</td>
									<td abbr="September" colspan="3" id="next" class="pad"><a href="#">Sep &raquo;</a></td>
								</tr>
							</tfoot>
							<tbody>
								<tr>
									<td colspan="2" class="pad">&nbsp;</td>
									<td>1</td>
									<td>2</td>
									<td>3</td>
									<td>4</td>
									<td>5</td>
								</tr>
								<tr>
									<td>6</td>
									<td>7</td>
									<td>8</td>
									<td>9</td>
									<td>10</td>
									<td>11</td>
									<td>12</td>
								</tr>
								<tr>
									<td>13</td>
									<td>14</td>
									<td>15</td>
									<td>16</td>
									<td>17</td>
									<td>18</td>
									<td>19</td>
								</tr>
								<tr>
									<td>20</td>
									<td id="today">21</td>
									<td>22</td>
									<td>23</td>
									<td>24</td>
									<td>25</td>
									<td>26</td>
								</tr>
								<tr>
									<td>27</td>
									<td>28</td>
									<td>29</td>
									<td>30</td>
									<td>31</td>
									<td class="pad" colspan="2">&nbsp;</td>
								</tr>
							</tbody>
						</table>
					</div>
				</li>
				<li>
					<h2>Mon Panier</h2>
					<ul>
						<li><a href="#">Item 1</a></li>
						<li><a href="#">Item 2</a></li>
					</ul>
				</li>
			</ul>
		</div>
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
