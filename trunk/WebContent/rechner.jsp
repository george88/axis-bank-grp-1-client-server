<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="java.text.DecimalFormat"%>
<%@page import="axisKlassen.KreditWunsch"%>
<%@page import="axisKlassen.Tilgungsplan"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">

<!--  Version: Multiflex-3 Update-7 / Layout-2             -->
<!--  Date:    January 15, 2007                            -->
<!--  Author:  Wolfgang                                    -->
<!--  License: Fully open source without restrictions.     -->
<!--           Please keep footer credits with a link to   -->
<!--           Wolfgang (www.1-2-3-4.info). Thank you!     -->

<head>
<%@ page pageEncoding="UTF-8" %>
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <meta http-equiv="cache-control" content="no-cache" />
  <meta http-equiv="expires" content="3600" />
  <meta name="revisit-after" content="2 days" />
  <meta name="robots" content="index,follow" />
  <meta name="publisher" content="Your publisher infos here ..." />
  <meta name="copyright" content="Your copyright infos here ..." />
  <meta name="author" content="Design: Wolfgang (www.1-2-3-4.info) / Modified: Your Name" />
  <meta name="distribution" content="global" />
  <meta name="description" content="Your page description here ..." />
  <meta name="keywords" content="Your keywords, keywords, keywords, here ..." />
  <link rel="stylesheet" type="text/css" media="screen,projection,print" href="./css/layout2_setup.css" />
  <link rel="stylesheet" type="text/css" media="screen,projection,print" href="./css/layout2_text.css" />
  <link rel="icon" type="image/x-icon" href="./img/favicon.ico" />
  <title>Axis Bank</title>
</head>

<!-- Global IE fix to avoid layout crash when single word size wider than column width -->
<!--[if IE]><style type="text/css"> body {word-wrap: break-word;}</style><![endif]-->

<body>
  <!-- Main Page Container -->
  <div class="page-container">

    <!-- For alternative headers START PASTE here -->

    <!-- A. HEADER -->      
    <div class="header">
      
      <!-- A.1 HEADER TOP -->
      <div class="header-top">
        
        <!-- Sitelogo and sitename -->
        <a class="sitelogo" href="#" title="Go to Start page"></a>
        <div class="sitename">
          <h1><a href="#" title="Go to Start page">Axis Bank<span style="font-weight:normal;font-size:50%;">&nbsp;</span></a></h1>
          <h2>new generation banking</h2>
        </div>
    
        <!-- Navigation Level 0 -->
        <div class="nav0">
          <ul>
            <li><a href="#" title="Pagina home in Italiano"><img src="./img/flag_italy.gif" alt="Image description" /></a></li>
            <li><a href="#" title="Homepage auf Deutsch"><img src="./img/flag_germany.gif" alt="Image description" /></a></li>
            <li><a href="#" title="Hemsidan p&aring; svenska"><img src="./img/flag_sweden.gif" alt="Image description" /></a></li>
          </ul>
        </div>			

        <!-- Navigation Level 1 -->
        <div class="nav1">
          <ul>
            <li><a href="#" title="Go to Start page">Kontakt</a></li>
            <li><a href="#" title="Get to know who we are">Hilfe</a></li>
          </ul>
        </div>              
      </div>
        
      <!-- A.3 HEADER BOTTOM -->
      <div class="header-bottom">
      
        <!-- Navigation Level 2 (Drop-down menus) -->
        <div class="nav2">
	
          <!-- Navigation item -->
          <ul>
            <li><a href="#">Ihre Vorteile<!--[if IE 7]><!--></a><!--<![endif]-->
              <!--[if lte IE 6]><table><tr><td><![endif]-->
                <ul>
                  <li><a href="#">Ihre Vorteile</a></li>
                  <li><a href="#">Ãber uns</a></li>
                  <li><a href="#">Unsere Verantwortung</a></li>                                  
                </ul>
              <!--[if lte IE 6]></td></tr></table></a><![endif]-->
            </li>
          </ul> 
          
          <!-- Navigation item -->
          <ul>
            <li><a href="#">Girokonto<!--[if IE 7]><!--></a><!--<![endif]--></li>
          </ul> 

		  <!-- Navigation item -->
          <ul>
            <li><a href="#">Sparen<!--[if IE 7]><!--></a><!--<![endif]-->
              <!--[if lte IE 6]><table><tr><td><![endif]-->
                <ul>
                  <li><a href="#">Tagesgeldkonto</a></li>
                  <li><a href="#">Festgeld</a></li>
                  <li><a href="#">Zinswachstum</a></li>
                  <li><a href="#">Sparbrief</a></li>
                  <li><a href="#">VL-Sparen</a></li>                                    
                </ul>
              <!--[if lte IE 6]></td></tr></table></a><![endif]-->
            </li>
          </ul>  

			<!-- Navigation item -->
          <ul>
            <li><a href="#">Wertpapiere<!--[if IE 7]><!--></a><!--<![endif]-->
              <!--[if lte IE 6]><table><tr><td><![endif]-->
                <ul>
                  <li><a href="#">Debot</a></li>
                  <li><a href="#">B&oumlrse</a></li>
                  <li><a href="#">Aktien</a></li>
                  <li><a href="#">Fonds</a></li>
                  <li><a href="#">Zertifikate</a></li>                                    
                </ul>
              <!--[if lte IE 6]></td></tr></table></a><![endif]-->
            </li>
          </ul>    

			<!-- Navigation item -->
          <ul>
            <li><a href="#">Baufinanzierung<!--[if IE 7]><!--></a><!--<![endif]-->
              <!--[if lte IE 6]><table><tr><td><![endif]-->
                <ul>
                  <li><a href="#">Neufinanzierung</a></li>
                  <li><a href="#">Anschlussfinanzierung</a></li>
                  <li><a href="#">Forward-Darlehen</a></li>
                  <li><a href="#">Rechner</a></li>
                  <li><a href="#">Angebot anfordern</a></li>                                    
                </ul>
              <!--[if lte IE 6]></td></tr></table></a><![endif]-->
            </li>
          </ul>  
			
			<!-- Navigation item -->
          <ul>
            <li class="active"><a href="#">Kredite<!--[if IE 7]><!--></a><!--<![endif]-->
              <!--[if lte IE 6]><table><tr><td><![endif]-->
                <ul>
                  <li><a href="#">Ratenkredit</a></li>
                  <li><a href="#">Autokredit</a></li>
                  <li><a href="#">Wohnkredit</a></li>                                  
                </ul>
              <!--[if lte IE 6]></td></tr></table></a><![endif]-->
            </li>
          </ul>   

			<!-- Navigation item -->
          <ul>
            <li><a href="#">Altersvorsorge<!--[if IE 7]><!--></a><!--<![endif]--></li>
          </ul>     

          <!-- Navigation item -->
          <ul>
            <li><a href="#">Kundenservice<!--[if IE 7]><!--></a><!--<![endif]--></li>
          </ul>          
        </div>
	  </div>

      <!-- A.4 HEADER BREADCRUMBS -->

      <!-- Breadcrumbs -->
      <div class="header-breadcrumbs">
        <ul>
          <li><a href="#">Home</a></li>
          <li><a href="#">Kredite</a></li>
          <li>Ratenkreditrechner</li>
        </ul>
      </div>
    </div>

    <!-- For alternative headers END PASTE here -->

    <!-- B. MAIN -->
    <div class="main">
 
      <!-- B.1 MAIN NAVIGATION -->
      <div class="main-navigation">

        <!-- Navigation Level 3 -->
        <div class="round-border-topright"></div>
        <h1 class="first">Kredite</h1>

        <!-- Navigation with grid style -->
        <dl class="nav3-grid">
          <dt><a href="#">Ratenkredit</a></dt>
            <dd><a href="#">Konditionen</a></dd>
            <dd><a href="#">Beispielrechnung</a></dd>
            <dd ><a href="?site=Home">Rechner</a></dd>	
			<dd class="active"><a href="#">Was kann ich mir leisten?</a></dd>
          <dt><a href="#">Autokredit</a></dt>
          <dt><a href="#">Wohnkredit</a></dt>
        </dl>                        

       
        <!-- Login -->
        <h1>Onlinebanking</h1>
        <div class="loginform">
          <form method="post" action="index.html"> 
            <p><input type="hidden" name="rememberme" value="0" /></p>
            <fieldset>
              <p><label for="username_1" class="top">Kontonummer:</label><br />
                <input type="text" name="username_1" id="username_1" tabindex="1" class="field" onkeypress="return webLoginEnter(document.loginfrm.password);" value="" /></p>
    	      <p><label for="password_1" class="top">Passwort:</label><br />
                <input type="password" name="password_1" id="password_1" tabindex="2" class="field" onkeypress="return webLoginEnter(document.loginfrm.cmdweblogin);" value="" /></p>
    	      <p><input type="submit" name="cmdweblogin" class="button" value="LOGIN"  /></p>
	          <p><a href="#" onclick="webLoginShowForm(2);return false;" id="forgotpsswd_1">Passwort vergessen?</a></p>
	        </fieldset>
          </form>
        </div>

        <!-- Search form -->                  
        <h1>Suche</h1>
        <div class="searchform">
          <form action="index.html" method="get">
            <fieldset>
              <input name="field" class="field"  value=" Suche..." />
              <input type="submit" name="button" class="button" value="Los!" />
            </fieldset>
          </form>
        </div>
      </div>
 
      <!-- B.1 MAIN CONTENT -->
      <div class="main-content">
        
        <!-- Pagetitle -->
        <h1 class="pagetitle">Ratenkreditrechner</h1>
	      
        <!-- Content unit - One column -->
        <div class="column1-unit">
			<form action="AxisBank?site=Rechner" method="post" name="rechner" id="rechner" onsubmit="">
			<input type="hidden" name="site" value="BerechnungUeberschuss"></input>
				<table cellpadding="0" cellspacing="0" class="formbody" border="0">
					<tbody>
						<tr>
							<td colspan="5" style="background:url(/main/img/check_calc.gif) no-repeat 0px 2px; padding-left: 25px; padding-top: 5px; padding-bottom: 5px;background-color:#7281B1" align="left"><span style="color:#ffffff; font-size:13px; font-weight:bold;">Wie viel Ratenkredit kann ich mir leisten?</span></td>
						</tr>
						<tr class="fieldset" id="mntlRate" style="background:#D6DDED">
							<th colspan="3" >
								<label>Monatlicher <b>Haushaltsüberschuss</b> als monatliche Rate frei verfügbar<br></label>
							</th>
							<th colspan="2">
								<input style="width: 121px;" class="currency" id="gewrate" maxlength="27" name="gewrate"  type="text" value=""  tabindex="1">&nbsp;&nbsp;<b>Euro</b>
								<div id="mntlRateError" class="error" style="visibility:hidden"></div>
							</th>
						</tr>
						<tr class="fieldset">
							<td colspan="5" style="background:#D6DDED; font: 12px Arial, Helvetica, sans-serif; text-align: right; padding: 2px 10px 0px 0;">
							<input type='image' src='./img/berechnen_b.gif' alt="berechnen">
								
							</td>
						</tr>
						<tr>
							<td colspan="5" style="background:url(/main/img/check_calc.gif) no-repeat 0px 2px; padding-left: 25px; padding-top: 5px; padding-bottom: 5px;background-color:#7281B1" align="left"><span style="color:#ffffff; font-size:13px; font-weight:bold;">Unser Angebot für Sie</span></td>
						</tr>
						<tr class="fieldset" style="background:#f3f5fa">
							<tr>
										<td style="font: 11px Arial; border-top: 0px">Kreditwunsch <br />(EUR)</td>
										<td style="font: 11px Arial; border-top: 0px">Laufzeit <br />(Mon. Rate)</td>
										<td style="font: 11px Arial; border-top: 0px">Mon. Rate <br />(EUR)</td>
										<td style="font: 11px Arial; border-top: 0px">Letzte Rate <br />(EUR)</td>
										<td style="font: 11px Arial; border-top: 0px">Gesamtbetrag <br />(EUR)</td>
									</tr>

							</th>
						</tr>
						<tr class="fieldset" >
								<%
								DecimalFormat df=new DecimalFormat("#,####0.00");
								KreditWunsch[] kws=(KreditWunsch[])request.getAttribute("kreditWuensche");
								if(kws!=null && kws.length>0)
								for(KreditWunsch kw:kws){
									out.println("<tr><td>"+df.format(kw.getKreditHoehe())+"</td>");								
									out.println("<td>"+kw.getLaufzeit()+"</td>");								
									out.println("<td>"+df.format(kw.getMonRate())+"</td>");								
									out.println("<td>"+df.format(kw.getLetzteRate())+"</td>");								
									out.println("<td>"+df.format(kw.getGesamtBetrag())+"</td></tr>");	
								}							
								%>
								
								<br>
						</tr>
						<tr><td colspan="5"><br></td></tr>
					</tbody>
				</table>
			</form>
        </div>          
        <hr class="clear-contentunit" />        
      </div>
    </div>
      
    <!-- C. FOOTER AREA -->      

    <div class="footer">
      <p>Copyright &copy; 2011 Axis Bank AG | All Rights Reserved</p>
      <p class="credits">Robert Beese | Daniel Schmitz | Georg Neufeld</p>
    </div>      
  </div> 
  
</body>
</html>



