package actions;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.engine.DefaultObjectSupplier;

import tools.KonfigFiles;
import axisKlassen.*;

public class Rechner1 extends Action {

	/*
	 * *****************************Public
	 * Methoden***********************************
	 */
	@Override
	public Object doAktion() {
		String getKreditWunsch = getRequest().getParameter("kwunsch");
		String getLaufZeit = getRequest().getParameter("gew_laufzeit");

		if (getKreditWunsch != null && getLaufZeit != null) {
			berechnungDurchKreditLaufzeit(getKreditWunsch, getLaufZeit);
		}

		setDestinationJSP("rechner1.jsp");
		return null;
	}

	/*
	 * ************************Private
	 * Methoden****************************************
	 */
	private void berechnungDurchKreditLaufzeit(String getKreditWunsch, String getLaufZeit) {
		try {
			double kreditWunsch = 0;
			int laufZeit = 0;

			ServiceClient sender = WebService.getServiceClient();

			QName opTilgungsPlan = new QName(KonfigFiles.getString(KonfigFiles.WebService_QNAME), KonfigFiles.getString(KonfigFiles.WebService_Methode_TPBetrag));

			int nachKomma = getKreditWunsch.indexOf(".");
			if (nachKomma != -1) {
				getKreditWunsch = getKreditWunsch.substring(0, nachKomma);
			} else {
				nachKomma = getKreditWunsch.indexOf(",");
				if (nachKomma != -1) {
					getKreditWunsch = getKreditWunsch.substring(0, nachKomma);
				}
			}

			nachKomma = getLaufZeit.indexOf(".");
			if (nachKomma != -1) {
				getLaufZeit = getLaufZeit.substring(0, nachKomma);
			} else {
				nachKomma = getLaufZeit.indexOf(",");
				if (nachKomma != -1) {
					getLaufZeit = getLaufZeit.substring(0, nachKomma);
				}
			}

			try {
				kreditWunsch = Double.parseDouble(getKreditWunsch);
			} catch (Exception e) {
				kreditWunsch = 0;
			}

			try {
				laufZeit = Integer.parseInt(getLaufZeit);
			} catch (Exception e) {
				laufZeit = 0;
			}

			Object[] opArgs = new Object[] { kreditWunsch, laufZeit };
			OMElement request = BeanUtil.getOMElement(opTilgungsPlan, opArgs, null, false, null);

			OMElement response = sender.sendReceive(request);
			Class<?>[] returnTypes = new Class[] { KreditWunsch.class };

			Object[] result = BeanUtil.deserialize(response, returnTypes, new DefaultObjectSupplier());

			KreditWunsch kreditWunschObjekt = (KreditWunsch) result[0];

			if (kreditWunschObjekt != null) {
				getRequest().setAttribute("kreditWuensche", kreditWunschObjekt);
			} else {
				getRequest().setAttribute("fehler", "Bitte überprüfen Sie Ihre Eingaben.<br>Kredit: 5.000 - 50.000 Euro <br> Laufzeit: 12 - 84 Monate");
			}

		} catch (AxisFault e) {
			e.printStackTrace();

		}
	}

}
