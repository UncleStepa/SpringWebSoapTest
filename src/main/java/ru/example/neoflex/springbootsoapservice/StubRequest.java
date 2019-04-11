package ru.example.neoflex.springbootsoapservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.xml.transform.StringResult;
import ru.neoflex.xml.clientebm.ClientDataReqEBM;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.net.URISyntaxException;

@Component
public class StubRequest {

    private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

    private final Jaxb2Marshaller jaxb2Marshaller;

    @Autowired
    public StubRequest(String urlEBM, Jaxb2Marshaller jaxb2Marshaller) {
        try {
            SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(MessageFactory.newInstance());
            webServiceTemplate.setDefaultUri(urlEBM);
            webServiceTemplate.setMessageFactory(messageFactory);
            webServiceTemplate.setMarshaller(jaxb2Marshaller);
            webServiceTemplate.setUnmarshaller(jaxb2Marshaller);
            webServiceTemplate.afterPropertiesSet();
            System.out.print("StubRequest ");
            System.out.println(urlEBM);
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        this.jaxb2Marshaller = jaxb2Marshaller;
    }

    public Object callWebService(String url, ClientDataReqEBM request) {
        StringResult resultReq = new StringResult();
        jaxb2Marshaller.marshal(request, resultReq);
        System.out.print("resultReq ");
        System.out.println(resultReq.toString());

        StreamResult result = new StreamResult(System.out);
        webServiceTemplate.marshalSendAndReceive(url, request, new SoapActionCallback("DetailsAboutClients"));
        return result;
    }
}


