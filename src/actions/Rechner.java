package actions;

public class Rechner extends Action {

	@Override
	public Object doAktion() {
		setDestinationJSP("rechner.jsp");
		return null;
	}

}
