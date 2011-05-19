package actions;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.engine.DefaultObjectSupplier;
import axisKlassen.*;

public class Rechner2 extends Action {

	/*
	 * *****************************Public
	 * Methoden***********************************
	 */
	@Override
	public Object doAktion() {

		String gewRate = getRequest().getParameter("gewrate");

		if (gewRate != null) {
			berechnungDurchRate(gewRate);
		}

		setDestinationJSP("rechner2.jsp");
		return null;
	}

	/*
	 * ************************Private
	 * Methoden****************************************
	 */
	private void berechnungDurchRate(String gewRate) {
		try {
			ServiceClient sender = WebService.getServiceClient();
			QName getTilgungsPlanDurchRate = new QName(
					"http://web.services.axisbank.de",
					"getTilgungsPlanDurchRate");

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
				getRequest()
						.setAttribute("fehler",
								"Bitte überprüfen Sie Ihre Eingaben.<br>Rate: 75 - 4.100 Euro");
			}
			System.out.println(ueberschuss);

			Object[] opArgs = new Object[] { ueberschuss };
			OMElement request = BeanUtil.getOMElement(getTilgungsPlanDurchRate,
					opArgs, null, false, null);

			OMElement response = sender.sendReceive(request);
			Class<?>[] returnTypes = new Class[] { KreditWunsch[].class };

			Object[] result = BeanUtil.deserialize(response, returnTypes,
					new DefaultObjectSupplier());

			KreditWunsch[] kreditWuensche = (KreditWunsch[]) result[0];
			if (kreditWuensche != null) {
				getRequest().setAttribute("kreditWuensche", kreditWuensche);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
