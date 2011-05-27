package actions;

import tools.KonfigFiles;

public class Login extends Action {

	@Override
	public Object doAktion() {

		if (checkSession()) {
			setDestinationJSP("rechner1.jsp");
			return null;
		} else {
			if (getRequest().getParameter("benutzername") != null) {
				if (getRequest().getParameter("benutzername").equals(KonfigFiles.getString(KonfigFiles.Login_USER))) {
					if (getRequest().getParameter("passwort") != null) {
						if (getRequest().getParameter("passwort").equals(KonfigFiles.getString(KonfigFiles.Login_PASSWORT))) {
							getRequest().getSession(true).setAttribute("benutzername", getRequest().getParameter("benutzername"));
							setDestinationJSP("rechner1.jsp");
							return null;
						}
					}
				}
			}
		}
		setDestinationJSP("login.jsp");

		return null;
	}
}
