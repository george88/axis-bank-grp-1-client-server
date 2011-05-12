package actions;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.engine.DefaultObjectSupplier;

import axisKlassen.Tilgungsplan;

public class BerechnungUeberschuss extends Action {

	@Override
	public Object doAktion() {

		try {
			ServiceClient sender = getServiceClient();
			QName opTilgungsPlan = new QName("http://web.services.axisbank.de",
					"getTilgungsPlan");

			String strUeberS = getRequest().getParameter("gewrate");
			int nachKomma = strUeberS.indexOf(".");
			if (nachKomma != -1) {
				strUeberS = strUeberS.substring(0, nachKomma);
			} else {
				nachKomma = strUeberS.indexOf(",");
				if (nachKomma != -1) {
					strUeberS = strUeberS.substring(0, nachKomma);
				}
			}
			int ueberschuss = 0;
			System.out.println(getRequest().getParameter("gewrate"));
			try {
				ueberschuss = Integer.parseInt(strUeberS);
			} catch (Exception e) {
				ueberschuss = 0;
			}
			System.out.println(ueberschuss);

			Object[] opArgs = new Object[] { ueberschuss };
			OMElement request = BeanUtil.getOMElement(opTilgungsPlan, opArgs,
					null, false, null);

			OMElement response = sender.sendReceive(request);
			Class<?>[] returnTypes = new Class[] { Tilgungsplan.class };

			Object[] result = BeanUtil.deserialize(response, returnTypes,
					new DefaultObjectSupplier());

			Tilgungsplan tilgungsPlan = (Tilgungsplan) result[0];
			if (tilgungsPlan != null) {
				getRequest().setAttribute("tilgungsPlan", tilgungsPlan);
			}

		} catch (AxisFault e) {
			e.printStackTrace();

		}

		getRequest().setAttribute("ergebnis", "Nichts");

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
