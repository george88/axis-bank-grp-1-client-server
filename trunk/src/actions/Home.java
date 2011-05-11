package actions;

public class Home extends Action {

	@Override
	public Object doAktion() {
		setDestinationJSP("index.jsp");
		return null;
	}

}
