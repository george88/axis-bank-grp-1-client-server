package actions;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

public class BerechnungUeberschuss extends Action {

	@Override
	public Object doAktion() {
		
		try {
			ServiceClient sender = getServiceClient();
			QName operation = new QName("http://web.services.axisbank.de","getTilgungsPlan");
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getRequest().setAttribute("ergebnis","Nichts");
		
		setDestinationJSP("rechner.jsp");
		return null;
	}
	
	private ServiceClient getServiceClient() throws AxisFault {

		ServiceClient s = new ServiceClient();
		Options options = s.getOptions();
		EndpointReference targetEPR = new EndpointReference(
				"http://localhost:9080/axis2/services/WebAxisBank");
		options.setTo(targetEPR);

		return s;
	}

}
