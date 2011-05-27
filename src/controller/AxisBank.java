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
 * gibt sie, mit Hilfe der <code>AktionReflector</code>, in die entsprechende
 * Klasse vom Typ Aktion ab. Dort wird die Anfrage , durch das, hier
 * stattfindende, aufrufen der doAktion()-Methode, weiterverarbeitet und bei
 * Beendigung dieser, der Zielparameter augelesen und die entsprechende Ziel-jsp
 * aufgerufen. Dazu prüft sie, in Threads ausgelagert, den aktuellen Stand der
 * Medien und lädt diese, bei Bedarf, aus der Datenbank neu ein.
 * 
 * @version 18.05.2011
 * @author Georg Neufeld
 */
public class AxisBank extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 2516647514935364746L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("session") != null && request.getParameter("session").equals("delete") && request.getSession(false) != null) {
			request.getSession(false).invalidate();
		}

		Action a = ActionReflector.getAktionFromRequest(request, false);
		if (a != null) {
			a.setRequest(request);
			a.doAktion();
			request = a.getRequest();
			if (a.getZielJSP() != null) {
				request.setAttribute(a.getZielJSP(), a.getZielJSP());
				request.getRequestDispatcher(a.getZielJSP()).forward(request, response);
			} else {
				request.setAttribute("rechner1.jsp", "rechner1.jsp");
				request.getRequestDispatcher("/rechner1.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("rechner1.jsp", "rechner1.jsp");
			request.getRequestDispatcher("/rechner1.jsp").forward(request, response);
		}
	}
}
