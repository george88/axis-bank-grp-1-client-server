package actions;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.engine.DefaultObjectSupplier;

import axisKlassen.KreditWunsch;
import axisKlassen.Tilgungsplan;

public class Rechner extends Action {

	@Override
	public Object doAktion() {

		String gewrate = getRequest().getParameter("gewrate");
		System.out.println(gewrate);
		if (gewrate != null) {
			try {
				ServiceClient sender = getServiceClient();
				QName opTilgungsPlan = new QName(
						"http://web.services.axisbank.de", "getTilgungsPlan");

				int nachKomma = gewrate.indexOf(".");
				if (nachKomma != -1) {
					gewrate = gewrate.substring(0, nachKomma);
				} else {
					nachKomma = gewrate.indexOf(",");
					if (nachKomma != -1) {
						gewrate = gewrate.substring(0, nachKomma);
					}
				}
				int ueberschuss = 0;
				System.out.println(getRequest().getParameter("gewrate"));
				try {
					ueberschuss = Integer.parseInt(gewrate);
				} catch (Exception e) {
					ueberschuss = 0;
				}
				System.out.println(ueberschuss);

				Object[] opArgs = new Object[] { ueberschuss };
				OMElement request = BeanUtil.getOMElement(opTilgungsPlan,
						opArgs, null, false, null);

				OMElement response = sender.sendReceive(request);
				Class<?>[] returnTypes = new Class[] { KreditWunsch[].class };

				Object[] result = BeanUtil.deserialize(response, returnTypes,
						new DefaultObjectSupplier());

				KreditWunsch[] kreditWuensche = (KreditWunsch[]) result[0];
				if (kreditWuensche != null) {
					getRequest().setAttribute("kreditWuensche", kreditWuensche);
				}

			} catch (AxisFault e) {
				e.printStackTrace();

			}

		}

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
