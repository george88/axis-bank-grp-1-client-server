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

public class Home extends Action {

	@Override
	public Object doAktion() {
		String getKreditWunsch = getRequest().getParameter("kwunsch");
		String getLaufZeit = getRequest().getParameter("gew_laufzeit");
		
		if(getKreditWunsch != null && getLaufZeit != null)
		{
			berechnungMitKredidLaufzeit(getKreditWunsch, getLaufZeit);			
		}
		
		setDestinationJSP("index.jsp");
		return null;
	}
	
	private void berechnungMitKredidLaufzeit(String getKreditWunsch,String getLaufZeit)
	{
		try {
			double kreditWunsch =0;
			int laufZeit =0;
			
			ServiceClient sender = getServiceClient();
			QName opTilgungsPlan = new QName(
					"http://web.services.axisbank.de", "getTilgungsPlanDurchBetragLaufzeit");

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

			Object[] opArgs = new Object[] { kreditWunsch,laufZeit };
			OMElement request = BeanUtil.getOMElement(opTilgungsPlan,
					opArgs, null, false, null);

			OMElement response = sender.sendReceive(request);
			Class<?>[] returnTypes = new Class[] { KreditWunsch.class };

			Object[] result = BeanUtil.deserialize(response, returnTypes,
					new DefaultObjectSupplier());

			KreditWunsch kreditWunschObjekt = (KreditWunsch) result[0];
			if (kreditWunschObjekt != null) {
				getRequest().setAttribute("kreditWuensche", kreditWunschObjekt);
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
