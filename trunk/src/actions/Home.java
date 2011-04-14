package actions;

public class Home extends Action {

	@Override
	public Object doAktion() {
		setZielJSP("index.jsp");
		return null;
	}

}
