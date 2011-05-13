<%@page import="axisKlassen.KreditWunsch"%>
<%@page import="java.text.DecimalFormat"%>
<% 
/*******************************************************************************************
*Inhalt: Diese Jsp stellt den Ratenkreditrechner 1 dar und kommuniziert mit dem Webservice
*
*Autor: Robert Beese
*
*Version: 1.2
*
********************************************************************************************/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="de">

<head>
<%@ page pageEncoding="UTF-8" %>
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <meta http-equiv="cache-control" content="no-cache" />
  <meta http-equiv="expires" content="3600" />
  <meta name="revisit-after" content="2 days" />
  <meta name="robots" content="index,follow" />
  <meta name="publisher" content="Axis Bank" />
  <meta name="copyright" content="Axis Bank" />
  <meta name="distribution" content="global" />
  <meta name="description" content="New generation banking" />
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
          <h1><a href="index.html" title="Go to Start page">Axis Bank<span style="font-weight:normal;font-size:50%;">&nbsp;</span></a></h1>
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
            <dd class="active"><a href="#">Rechner</a></dd>	
			<dd><a href="?site=Rechner">Was kann ich mir leisten?</a></dd>
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
        <h1 class="pagetitle">Individueller Ratenkreditrechner</h1>
		<p>Mit * gekennzeichnete Felder sind Pflichtangaben und zwingend auszufüllen.</p>

    
          
        <!-- Content unit - One column -->
        <div class="column1-unit">
			<table cellpadding="0" cellspacing="0" class="formbody">
				<thead>
					<tr>
						<td colspan="2" style="text-align:left; background-color: #7281B1; background-image:url(/main/img/check_calc.gif);background-repeat: no-repeat; border-top: 2px solid #FFF; padding-left: 25px; padding-top: 5px;border-bottom: 2px solid #FFF; padding-bottom: 5px;">
							<span style="text-align:left;color:#ffffff; font-size:13px; font-weight:bold;">Ihr individueller Ratenkredit</span>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr class="h2">
						<th colspan="2" style="background:#D6DDED;">Kreditwunsch</th>
					</tr>
				<%
								DecimalFormat df=new DecimalFormat("##,##0.00");
								KreditWunsch kw=(KreditWunsch)request.getAttribute("kreditWuensche");
								int laufz=0;
								double mrate=0;
								double lrate=0;
								double gesamt = 0;
								int kreditHoehe = 0;
								
								if(kw!=null)
								{
									laufz=kw.getLaufzeit();
									mrate=kw.getMonRate();
									lrate=kw.getLetzteRate();
									gesamt=kw.getGesamtBetrag();
									kreditHoehe = (int)kw.getKreditHoehe();
								}
								%>
					<tr class="fieldset">
						<td colspan="2"><p>Bitte geben Sie Ihren gewünschten Auszahlungsbetrag (Kreditwunsch) und die gewüschte Laufzeit ein.</p></td>
					</tr>
					<form action="AxisBank?site=Home" method="post" name="rechner" id="rechner" onsubmit="">
						<tr class="fieldset inputset first-row" style="background:#f3f5fa">
							<th ><label><strong>Kreditwunsch in Euro</strong>*</label></th>
							<td>
								<input class="text" type="text" name="kwunsch" value="<%=kreditHoehe != 0?kreditHoehe:"" %>"  size="8" maxlength="5" bid="behaviourAutoId_11" tabindex="1">
								
							</td>
						</tr>
						<tr class="fieldset-end inputset" style="background:#f3f5fa">
							<th><label><strong>Gewünschte Laufzeit in Monaten*</strong></label></th>
							<td>
								<input class="text" type="text" id="gew_laufzeit" name="gew_laufzeit" value="<%=laufz != 0?laufz:"" %>" size="8" maxlength="2" tabindex="2">
								
							</td>
						</tr>
						<%
						String fehler = (String)request.getAttribute("fehler");
						
						if(fehler!=null)
						{
							out.println("<tr><td colspan=\"2\">"+fehler+"</tr>");
						}
						%>	
						<tr>
							<td colspan="2" style="background:#D6DDED; font: 12px Arial, Helvetica, sans-serif; text-align: right; padding: 2px 10px 0px 0;">
								<input type='image' src='./img/berechnen_b.gif' alt="berechnen">
							</td>
						</tr>
					</form>

					<tr>
						<td colspan="2" style="text-align:left; background-color: #7281B1; background-image:url(/main/img/check_calc.gif);background-repeat: no-repeat; border-top: 2px solid #FFF; padding-left: 25px; padding-top: 5px;border-bottom: 2px solid #FFF; padding-bottom: 5px;">
							<span style="text-align:left;color:#ffffff; font-size:13px; font-weight:bold;">Unser Angebot für Sie</span>
						</td>
					</tr>
	
					<tr class="fieldset resultset" style="display:none;background:#f3f5fa">
						<th><label>Laufzeit in Monaten</label></th>
						<td><input class="text" type="text" name="laufzeit" value="<%=df.format(laufz)%>" readonly="readonly" size="8" bid="behaviourAutoId_15" tabindex="4"></td>
					</tr>

					<tr class="fieldset resultset" style="background:#f3f5fa">
						<th ><label>Monatliche Rate</label></th>
						<td>
							<input type="text" name="mrate" id="mrate" onchange="colorFeld(this.name)" value="<%=df.format(mrate)%>" size="7" maxlength="7" readonly="readonly" class="currency" style="float:left; width: 84px;background-color:#EBEBE4 !important; border:1px solid #7F9DB9;" bid="behaviourAutoId_16" tabindex="5">
							<label class="text-inputfield">Euro</label>
						</td>
					</tr>

					<tr class="fieldset resultset" style="background:#f3f5fa">
						<th><label>Letzte Rate</label></th>
						<td>
							<input type="text" name="lrate" id="lrate" onchange="colorFeld(this.name)" value="<%=df.format(lrate)%>" size="7" maxlength="7" readonly="readonly" class="currency" style="float:left; width: 84px;background-color:#EBEBE4 !important; border:1px solid #7F9DB9;" bid="behaviourAutoId_17" tabindex="6">
							<label class="text-inputfield">Euro</label>
						</td>
					</tr>

					<tr class="fieldset resultset" style="background:#f3f5fa">
						<th><label>Gesamtbetrag</label></th>
						<td>
							<input type="text" name="jgesamt" id="jgesamt" onchange="colorFeld(this.name)" value="<%=df.format(gesamt) %>" size="8" maxlength="8" readonly="readonly" class="currency" style="float:left; width: 84px;background-color:#EBEBE4 !important; border:1px solid #7F9DB9;" bid="behaviourAutoId_18" tabindex="7">
							<label class="text-inputfield">Euro</label>
						</td>
					</tr>
				</tbody>
			</table>
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



