package actions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

/**
 * Die Klasse <code>ActionReflector</code> gibt dem Controller die n�tigen
 * Aktionsklassen zur�ck.
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
	public static Action getAktionFromRequest(HttpServletRequest request,
			boolean backToSource) {

		int role = 3;
		String actionName = "null";
		Object roleObj = null;
		if (request.getSession(false) != null) {
			roleObj = request.getSession(false).getAttribute("role");
			try {
				role = Integer.parseInt(roleObj.toString());
			} catch (Exception e) {
				role = 3;
			}
		}

		actionName = request.getParameter("site");

		Action action = getAktionFromName(actionName);

		if (role <= action.getBerechtigung())
			return action;
		else
			return getAktionFromName("Home");
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
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		} catch (SecurityException e) {
			// e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// e.printStackTrace();
		} catch (InstantiationException e) {
			// e.printStackTrace();
		} catch (IllegalAccessException e) {
			// e.printStackTrace();
		} catch (InvocationTargetException e) {
			// e.printStackTrace();
		}

		return new Home();
	}
}
