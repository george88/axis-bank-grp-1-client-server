package actions;

public class Service extends Action {

	@Override
	public Object doAktion() {
		setDestinationJSP("service.jsp");
		return null;
	}

}
