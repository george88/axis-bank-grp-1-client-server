package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Action;
import actions.ActionReflector;

/**
 * Servlet implementation class AxisBank Sie nimmt alle Anfragen entgegen und
 * gibt sie, mit Hilfe der <code>Aktion_Definition</code>, in die entsprechende
 * Klasse vom Typ Aktion ab. Dort wird die Anfrage , durch das, hier
 * stattfindende, aufrufen der doAktion()-Methode, weiterverarbeitet und bei
 * Beendigung dieser, der Zielparameter augelesen und die entsprechende Ziel-jsp
 * aufgerufen. Dazu prüft sie, in Threads ausgelagert, den aktuellen Stand der
 * Medien und lädt diese, bei Bedarf, aus der Datenbank neu ein.
 * 
 * @version 07.12.2010
 * @author Georg Neufeld
 */
public class AxisBank extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Action a = ActionReflector.getAktionFromRequest(request, false);

		if (a != null) {
			a.setRequest(request);
			Object obj = a.doAktion();
			a.setContentObject(obj);

			request.setAttribute("content", a.getContentObject());
			request = a.getRequest();

			if (a.getContentObject() instanceof Error) {
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
			} else if (a.getZielJSP() != null) {
				request.getRequestDispatcher(a.getZielJSP()).forward(request,
						response);
			}
		} else {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		}
	}
}
