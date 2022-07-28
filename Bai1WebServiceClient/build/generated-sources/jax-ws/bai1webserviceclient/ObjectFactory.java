
package bai1webserviceclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bai1webserviceclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Sum_QNAME = new QName("http://mycalcws/", "sum");
    private final static QName _SumResponse_QNAME = new QName("http://mycalcws/", "sumResponse");
    private final static QName _ProdResponse_QNAME = new QName("http://mycalcws/", "prodResponse");
    private final static QName _Prod_QNAME = new QName("http://mycalcws/", "prod");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bai1webserviceclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Prod }
     * 
     */
    public Prod createProd() {
        return new Prod();
    }

    /**
     * Create an instance of {@link Sum }
     * 
     */
    public Sum createSum() {
        return new Sum();
    }

    /**
     * Create an instance of {@link ProdResponse }
     * 
     */
    public ProdResponse createProdResponse() {
        return new ProdResponse();
    }

    /**
     * Create an instance of {@link SumResponse }
     * 
     */
    public SumResponse createSumResponse() {
        return new SumResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycalcws/", name = "sum")
    public JAXBElement<Sum> createSum(Sum value) {
        return new JAXBElement<Sum>(_Sum_QNAME, Sum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycalcws/", name = "sumResponse")
    public JAXBElement<SumResponse> createSumResponse(SumResponse value) {
        return new JAXBElement<SumResponse>(_SumResponse_QNAME, SumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycalcws/", name = "prodResponse")
    public JAXBElement<ProdResponse> createProdResponse(ProdResponse value) {
        return new JAXBElement<ProdResponse>(_ProdResponse_QNAME, ProdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Prod }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycalcws/", name = "prod")
    public JAXBElement<Prod> createProd(Prod value) {
        return new JAXBElement<Prod>(_Prod_QNAME, Prod.class, null, value);
    }

}
