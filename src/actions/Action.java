package actions;

import javax.servlet.http.HttpServletRequest;

import de.axisbank.services.web.WebAxisBankSkeleton;

/**
 * Die abstrakt Klasse <code>Aktion</code> definiert das Konstrukt einer jeden
 * Aktionsklasse. Ausserdem verlangt sie die Implementierung der
 * doAktion-Methode.
 * 
 * @version 07.12.2010
 * @author Georg Neufeld
 */
public abstract class Action extends WebAxisBankSkeleton {

	private String name;
	private String zielJSP;
	private int berechtigung = 3;
	private HttpServletRequest request;
	private Object contentObject;

	/**
	 * @return ein Objekt der do Aktion()
	 */
	public abstract Object doAktion();

	/**
	 * @param name
	 *            Zielklasse
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Aufrufklasse
	 */
	public String getName() {
		return name;
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
	 * @param contentObject
	 *            Objekt des Inhalts
	 */
	public void setContentObject(Object contentObject) {
		this.contentObject = contentObject;
	}

	/**
	 * @return Objekt des Inhalts
	 */
	public Object getContentObject() {
		return contentObject;
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

	/**
	 * @param berechtigung
	 *            Rolle des Nutzers
	 */
	public void setBerechtigung(int berechtigung) {
		this.berechtigung = berechtigung;
	}

	/**
	 * @return Rolle des Nutzers
	 */
	public int getBerechtigung() {
		return berechtigung;
	}
}
