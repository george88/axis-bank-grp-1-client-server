package actions;

import javax.servlet.http.HttpServletRequest;

import tools.KonfigFiles;

/**
 * Die abstrakt Klasse <code>Aktion</code> definiert das Konstrukt einer jeden
 * Aktionsklasse. Ausserdem verlangt sie die Implementierung der
 * doAktion-Methode.
 * 
 * @version 07.12.2010
 * @author Georg Neufeld
 */
public abstract class Action {

	private String zielJSP;
	private HttpServletRequest request;

	/**
	 * @return ein Objekt der do Aktion()
	 */
	public abstract Object doAktion();

	public boolean checkSession() {

		if (getRequest() != null) {
			if (getRequest().getSession(false) != null) {
				if (getRequest().getSession(false).getAttribute("benutzername") != null) {
					if (getRequest().getSession(false).getAttribute("benutzername").toString().equals(KonfigFiles.getString(KonfigFiles.Login_USER))) {
						System.out.println("trueSession");
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * @param zielJSP
	 *            Pfad der Ziel-JSP
	 */
	public void setDestinationJSP(String zielJSP) {
		this.zielJSP = zielJSP;
	}

	/**
	 * @return Pfad der JSP von der gekommen wurde
	 */
	public String getZielJSP() {
		return zielJSP;
	}

	/**
	 * @param request
	 *            POST-Varialen von der JSP
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return POST-Variablen von Servlet
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
}
