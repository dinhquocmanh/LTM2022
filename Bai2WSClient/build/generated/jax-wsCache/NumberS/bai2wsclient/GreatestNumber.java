
package bai2wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for greatestNumber complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="greatestNumber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reqId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="greatestNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "greatestNumber", propOrder = {
    "reqId",
    "greatestNumber"
})
public class GreatestNumber {

    protected int reqId;
    protected String greatestNumber;

    /**
     * Gets the value of the reqId property.
     * 
     */
    public int getReqId() {
        return reqId;
    }

    /**
     * Sets the value of the reqId property.
     * 
     */
    public void setReqId(int value) {
        this.reqId = value;
    }

    /**
     * Gets the value of the greatestNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGreatestNumber() {
        return greatestNumber;
    }

    /**
     * Sets the value of the greatestNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGreatestNumber(String value) {
        this.greatestNumber = value;
    }

}
