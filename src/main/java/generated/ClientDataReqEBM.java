//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.04.05 at 05:23:04 PM SAMT 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Clients">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Client" type="{}ClientType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clients"
})
@XmlRootElement(name = "ClientDataReqEBM")
public class ClientDataReqEBM {

    @XmlElement(name = "Clients", required = true)
    protected ClientDataReqEBM.Clients clients;

    /**
     * Gets the value of the clients property.
     * 
     * @return
     *     possible object is
     *     {@link ClientDataReqEBM.Clients }
     *     
     */
    public ClientDataReqEBM.Clients getClients() {
        return clients;
    }

    /**
     * Sets the value of the clients property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientDataReqEBM.Clients }
     *     
     */
    public void setClients(ClientDataReqEBM.Clients value) {
        this.clients = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Client" type="{}ClientType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "client"
    })
    public static class Clients {

        @XmlElement(name = "Client", required = true)
        protected ClientType client;

        /**
         * Gets the value of the client property.
         * 
         * @return
         *     possible object is
         *     {@link ClientType }
         *     
         */
        public ClientType getClient() {
            return client;
        }

        /**
         * Sets the value of the client property.
         * 
         * @param value
         *     allowed object is
         *     {@link ClientType }
         *     
         */
        public void setClient(ClientType value) {
            this.client = value;
        }

    }

}
