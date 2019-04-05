package ru.example.neoflex.springbootsoapservice;


import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Envelope1_1Impl;
import com.sun.xml.internal.messaging.saaj.soap.ver1_2.Envelope1_2Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import ru.neoflex.xml.clientebm.ClientDataReqEBM;
import ru.neoflex.xml.clientebm.ClientDataResEBM;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.soap.*;

@Component
public class StubReauest {
    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public ClientDataResEBM callStubV2(ClientDataReqEBM reqEBM) throws SOAPException, JAXBException {
        System.out.println("1");
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        template = new WebServiceTemplate(new SaajSoapMessageFactory(factory));
        template.setMarshaller(marshaller);
        template.setUnmarshaller(marshaller.getJaxbContext().createUnmarshaller());
        System.out.println("2");
        SoapActionCallback requestCallback = new SoapActionCallback("ClientsDetailsPortService") {
            public void doWithMessage(WebServiceMessage message) {
                System.out.println("3");
                SaajSoapMessage soapMessage = (SaajSoapMessage) message;
                SoapHeader soapHeader = soapMessage.getSoapHeader();

                QName wsaToQName = new QName("http://www.w3.org/2005/08/addressing", "To", "wsa");
                SoapHeaderElement wsaTo = soapHeader.addHeaderElement(wsaToQName);
                wsaTo.setText("http://ws64-146:8088/mockClientsDetailsPortSoap11");

                QName wsaActionQName = new QName("http://www.w3.org/2005/08/addressing", "Action", "wsa");
                SoapHeaderElement wsaAction = soapHeader.addHeaderElement(wsaActionQName);
                wsaAction.setText("ClientsDetailsPortService");
            }
        };
        Object o = template.marshalSendAndReceive("http://ws64-146:8088/mockClientsDetailsPortSoap11", reqEBM, requestCallback);
        System.out.println(o.getClass().getName());
        return (ClientDataResEBM) o;
    }

    public void callStub(ClientDataReqEBM clientDataReqEBM) throws Exception {

        String URI = "http://ws64-146:8088/mockClientsDetailsPortSoap11?wsdl";
        String SoapAction = "ClientsDetailsPortService";
        System.out.println("callStub 1");
        SaajSoapMessageFactory messageFactory = null;
        try {
            messageFactory = new SaajSoapMessageFactory(
                    MessageFactory.newInstance());
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        messageFactory.afterPropertiesSet();
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(
                messageFactory);
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//
//        marshaller.setContextPath("ru.neoflex.xml.clientebm");
//        marshaller.afterPropertiesSet();

        System.out.println("callStub 2");

        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.afterPropertiesSet();

        System.out.println("callStub 3");
        System.out.println(clientDataReqEBM.getClients() != null);
        System.out.println(clientDataReqEBM.getClients().getClient() != null);
        System.out.println(clientDataReqEBM.getClients().getClient().getMiddleName() != null);
        ClientDataResEBM response = (ClientDataResEBM)
                webServiceTemplate.marshalSendAndReceive(URI, clientDataReqEBM, new ActionCallback("test"));

        System.out.println("callStub 4" + response.toString());

    }
}


