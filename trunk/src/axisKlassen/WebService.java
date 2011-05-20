package axisKlassen;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

import tools.KonfigFiles;

public class WebService {
	public static ServiceClient getServiceClient() {

		ServiceClient s = null;
		try {
			s = new ServiceClient();
		} catch (AxisFault e) {
			e.printStackTrace();
		}
		if (s != null) {
			Options options = s.getOptions();
			EndpointReference targetEPR = new EndpointReference(KonfigFiles.getString(KonfigFiles.WebService_WSDL, KonfigFiles.Konfiguration_Datei_WebService));
			options.setTo(targetEPR);
		}
		return s;
	}

}
