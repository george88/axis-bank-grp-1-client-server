package actions;

import org.apache.axis2.client.ServiceClient;

public class Service extends Action {

	ServiceClient sender;

	@Override
	public Object doAktion() {
		setDestinationJSP("service.jsp");
		return null;
	}

	public void connect() {

		// try {
		// sender = new ServiceClient();
		// Options options = sender.getOptions();
		// EndpointReference targetEPR = new EndpointReference(
		// "http://localhost:8080/axis2/services/SimpleHotelService?wsdl");
		// options.setTo(targetEPR);
		//
		// QName qualifiedname = new QName("http://axishotels.de", "findHotel");
		// Object[] opArgs = new Object[] { "ax050" };
		// OMElement request = BeanUtil.getOMElement(qualifiedname, opArgs,
		// null, false, null);
		// OMElement response = sender.sendReceive(request);
		// Class[] returnTypes = new Class[] { String.class };
		// Object[] result = BeanUtil.deserialize(response, returnTypes,
		// new DefaultObjectSupplier());
		//
		// } catch (AxisFault e) {
		// e.printStackTrace();
		// }

	}

}
