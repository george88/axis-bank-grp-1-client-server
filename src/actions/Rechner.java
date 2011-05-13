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


public class Rechner extends Action {

	/******************************Public Methoden************************************/
	@Override
	public Object doAktion() {
		
		String gewRate = getRequest().getParameter("gewrate");

		if (gewRate != null) {
			berechnungMitRate(gewRate);
		}

		setDestinationJSP("rechner.jsp");
		return null;
	}
	
	/*************************Private Methoden*****************************************/
	
	private void berechnungMitRate(String gewRate)
	{
		try {
			ServiceClient sender = getServiceClient();
			QName opTilgungsPlan = new QName(
					"http://web.services.axisbank.de", "getTilgungsPlanDurchRate");

			int nachKomma = gewRate.indexOf(".");
			if (nachKomma != -1) {
				gewRate = gewRate.substring(0, nachKomma);
			} else {
				nachKomma = gewRate.indexOf(",");
				if (nachKomma != -1) {
					gewRate = gewRate.substring(0, nachKomma);
				}
			}
			int ueberschuss = 0;
			System.out.println(getRequest().getParameter("gewrate"));
			try {
				ueberschuss = Integer.parseInt(gewRate);
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

	private ServiceClient getServiceClient() throws AxisFault {

		ServiceClient s = new ServiceClient();
		Options options = s.getOptions();
		EndpointReference targetEPR = new EndpointReference(
				"http://localhost:9080/axis2/services/WebAxisBank");
		options.setTo(targetEPR);

		return s;
	}

}
