package actions;

import java.lang.reflect.Constructor;
import javax.servlet.http.HttpServletRequest;

/**
 * Die Klasse <code>ActionReflector</code> gibt dem Controller die nötigen
 * Aktionsklassen zurück.
 * 
 * @version 07.12.2010
 * @author Georg Neufeld
 */
public class ActionReflector {

	/**
	 * Mit Hilfe des Requestparameter "site" wird per Reflexion fuer die
	 * dazugehoerige Klasse eine Instanz erzeugt.
	 * 
	 * @param request
	 *            siehe {@link javax.servlet.http.HttpServletRequest
	 *            <code>HttpServletRequest</code>}
	 * @param backToSource
	 *            wenn gesetzt wird zurueck zum Aufrufer gesprungen
	 * @return Instanz einer Aktionsklasse
	 */
	public static Action getAktionFromRequest(HttpServletRequest request, boolean backToSource) {

		String actionName = request.getParameter("site");
		if (actionName == null)
			return getAktionFromName("Rechner1");

		Action a = getAktionFromName(actionName);
		a.setRequest(request);
		if (!a.checkSession()) {
			System.out.println("testset");
			return getAktionFromName("Login");
		}
		return a;
	}

	/**
	 * Hier wird per Reflexion die Instanz erzeugt.
	 * 
	 * @param actionsName
	 *            wirs aus dem Requestparameter "site" ausgelesen und dann als
	 *            Klassenname verwandt
	 * @return Instanz einer Aktionsklasse
	 */
	public static Action getAktionFromName(String actionsName) {

		Action action = null;

		try {
			Class<?> c;
			System.out.println("site=" + actionsName);
			c = Class.forName("actions." + actionsName);
			Constructor<?> con = c.getConstructor();
			action = (Action) con.newInstance();
			return action;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Rechner1();
	}
}
