package ru.example.neoflex.springbootsoapservice;


import com.sun.xml.internal.messaging.saaj.soap.ver1_1.SOAPMessageFactory1_1Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.TransportConstants;
import org.springframework.xml.transform.StringResult;
import ru.neoflex.xml.clientebm.ClientDataReqEBM;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.transform.stream.StreamResult;

@Component
public class StubRequest {

    private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

    private final Jaxb2Marshaller jaxb2Marshaller;

    @Autowired
    public StubRequest(String urlEBM, Jaxb2Marshaller jaxb2Marshaller) {
        try {
            SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(SOAPMessageFactory1_1Impl.newInstance());
            //messageFactory.setSoapVersion(SoapVersion.SOAP_11);
            messageFactory.afterPropertiesSet();


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
        return webServiceTemplate.marshalSendAndReceive(url, request, message -> {
                    try {
                        SaajSoapMessage soapMessage = (SaajSoapMessage) message;
                        MimeHeaders headers = soapMessage.getSaajMessage().getMimeHeaders();
                        headers.addHeader(TransportConstants.HEADER_CONTENT_TYPE, "application/xml;charset=utf-8");
                        headers.addHeader(TransportConstants.HEADER_SOAP_ACTION, "DetailsAboutClients");
                    } catch (Throwable e) {
                        System.out.println(e.getMessage());
                    }
                }
        );

    }

}


