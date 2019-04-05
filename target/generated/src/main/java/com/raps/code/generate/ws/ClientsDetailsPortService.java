
package com.raps.code.generate.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ClientsDetailsPortService", targetNamespace = "http://www.neoflex.ru/xml/clients", wsdlLocation = "file:/D:/GIT/SpringWebSoapTest/src/main/resources/wsdl/clients.wsdl")
public class ClientsDetailsPortService
    extends Service
{

    private final static URL CLIENTSDETAILSPORTSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.raps.code.generate.ws.ClientsDetailsPortService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.raps.code.generate.ws.ClientsDetailsPortService.class.getResource(".");
            url = new URL(baseUrl, "file:/D:/GIT/SpringWebSoapTest/src/main/resources/wsdl/clients.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/D:/GIT/SpringWebSoapTest/src/main/resources/wsdl/clients.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        CLIENTSDETAILSPORTSERVICE_WSDL_LOCATION = url;
    }

    public ClientsDetailsPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ClientsDetailsPortService() {
        super(CLIENTSDETAILSPORTSERVICE_WSDL_LOCATION, new QName("http://www.neoflex.ru/xml/clients", "ClientsDetailsPortService"));
    }

    /**
     * 
     * @return
     *     returns ClientsDetailsPort
     */
    @WebEndpoint(name = "ClientsDetailsPortSoap11")
    public ClientsDetailsPort getClientsDetailsPortSoap11() {
        return super.getPort(new QName("http://www.neoflex.ru/xml/clients", "ClientsDetailsPortSoap11"), ClientsDetailsPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ClientsDetailsPort
     */
    @WebEndpoint(name = "ClientsDetailsPortSoap11")
    public ClientsDetailsPort getClientsDetailsPortSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.neoflex.ru/xml/clients", "ClientsDetailsPortSoap11"), ClientsDetailsPort.class, features);
    }

}