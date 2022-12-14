
package bai1webserviceclient;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CalcServiceImplementorService", targetNamespace = "http://mycalcws/", wsdlLocation = "http://localhost:50000/Calc?wsdl")
public class CalcServiceImplementorService
    extends Service
{

    private final static URL CALCSERVICEIMPLEMENTORSERVICE_WSDL_LOCATION;
    private final static WebServiceException CALCSERVICEIMPLEMENTORSERVICE_EXCEPTION;
    private final static QName CALCSERVICEIMPLEMENTORSERVICE_QNAME = new QName("http://mycalcws/", "CalcServiceImplementorService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:50000/Calc?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CALCSERVICEIMPLEMENTORSERVICE_WSDL_LOCATION = url;
        CALCSERVICEIMPLEMENTORSERVICE_EXCEPTION = e;
    }

    public CalcServiceImplementorService() {
        super(__getWsdlLocation(), CALCSERVICEIMPLEMENTORSERVICE_QNAME);
    }

    public CalcServiceImplementorService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CALCSERVICEIMPLEMENTORSERVICE_QNAME, features);
    }

    public CalcServiceImplementorService(URL wsdlLocation) {
        super(wsdlLocation, CALCSERVICEIMPLEMENTORSERVICE_QNAME);
    }

    public CalcServiceImplementorService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CALCSERVICEIMPLEMENTORSERVICE_QNAME, features);
    }

    public CalcServiceImplementorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalcServiceImplementorService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CalcServiceImplementor
     */
    @WebEndpoint(name = "CalcServiceImplementorPort")
    public CalcServiceImplementor getCalcServiceImplementorPort() {
        return super.getPort(new QName("http://mycalcws/", "CalcServiceImplementorPort"), CalcServiceImplementor.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CalcServiceImplementor
     */
    @WebEndpoint(name = "CalcServiceImplementorPort")
    public CalcServiceImplementor getCalcServiceImplementorPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://mycalcws/", "CalcServiceImplementorPort"), CalcServiceImplementor.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CALCSERVICEIMPLEMENTORSERVICE_EXCEPTION!= null) {
            throw CALCSERVICEIMPLEMENTORSERVICE_EXCEPTION;
        }
        return CALCSERVICEIMPLEMENTORSERVICE_WSDL_LOCATION;
    }

}
