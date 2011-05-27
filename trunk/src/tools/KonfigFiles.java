package tools;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Properties;

public class KonfigFiles {

	private static final String fileType = "_Konfiguration.properties";
	private static final String konfigPath = "/konf/";

	public static final String WebService_WSDL = "WebService_WSDL";
	public static final String WebService_QNAME = "WebService_QNAME";
	public static final String WebService_Methode_TPBetrag = "WebService_Methode_TPBetrag";
	public static final String WebService_Methode_TPRate = "WebService_Methode_TPRate";

	public static final String Login_USER = "Login_USER";
	public static final String Login_PASSWORT = "Login_PASSWORT";

	public static HashMap<String, String> props = new HashMap<String, String>();

	public static String getString(String key) {
		String file = key.substring(0, key.indexOf("_"));
		key = key.substring(key.indexOf("_") + 1);
		if (props.containsKey(key))
			return props.get(key);
		try {
			Properties p = new Properties();
			p.load(new KonfigFiles().readFile(file));
			String prop = p.getProperty(key);
			if (prop != null)
				props.put(key, prop);
			return prop;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getInt(String key) {
		String file = key.substring(0, key.indexOf("_"));
		key = key.substring(key.indexOf("_") + 1);
		if (props.containsKey(key))
			return Integer.parseInt(props.get(key));
		try {
			Properties p = new Properties();
			p.load(new KonfigFiles().readFile(file));
			String prop = p.getProperty(key);
			if (prop != null)
				props.put(key, prop);
			return Integer.parseInt(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static double getDouble(String key) {
		String file = key.substring(0, key.indexOf("_"));
		key = key.substring(key.indexOf("_") + 1);
		if (props.containsKey(key))
			return Double.parseDouble(props.get(key));
		try {
			Properties p = new Properties();
			p.load(new KonfigFiles().readFile(file));
			String prop = p.getProperty(key);
			if (prop != null)
				props.put(key, prop);
			return Double.parseDouble(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public InputStreamReader readFile(String konfigFile) {
		return new InputStreamReader(this.getClass().getResourceAsStream(konfigPath + konfigFile + fileType));
	}
}
