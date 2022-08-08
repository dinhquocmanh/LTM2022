
package bai4ws;

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
@WebServiceClient(name = "ProductS", targetNamespace = "http://medianews.vn/", wsdlLocation = "http://203.162.10.109:8080/ProductService/ProductS?wsdl")
public class ProductS_Service
    extends Service
{

    private final static URL PRODUCTS_WSDL_LOCATION;
    private final static WebServiceException PRODUCTS_EXCEPTION;
    private final static QName PRODUCTS_QNAME = new QName("http://medianews.vn/", "ProductS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://203.162.10.109:8080/ProductService/ProductS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PRODUCTS_WSDL_LOCATION = url;
        PRODUCTS_EXCEPTION = e;
    }

    public ProductS_Service() {
        super(__getWsdlLocation(), PRODUCTS_QNAME);
    }

    public ProductS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), PRODUCTS_QNAME, features);
    }

    public ProductS_Service(URL wsdlLocation) {
        super(wsdlLocation, PRODUCTS_QNAME);
    }

    public ProductS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PRODUCTS_QNAME, features);
    }

    public ProductS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ProductS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ProductS
     */
    @WebEndpoint(name = "ProductSPort")
    public ProductS getProductSPort() {
        return super.getPort(new QName("http://medianews.vn/", "ProductSPort"), ProductS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ProductS
     */
    @WebEndpoint(name = "ProductSPort")
    public ProductS getProductSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://medianews.vn/", "ProductSPort"), ProductS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PRODUCTS_EXCEPTION!= null) {
            throw PRODUCTS_EXCEPTION;
        }
        return PRODUCTS_WSDL_LOCATION;
    }

}