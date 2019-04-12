package ru.example.neoflex.springbootsoapservice;


import com.sun.xml.internal.messaging.saaj.soap.ver1_1.SOAPMessageFactory1_1Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpUrlConnection;
import org.springframework.xml.transform.StringResult;
import ru.neoflex.xml.clientebm.ClientDataReqEBM;

import javax.xml.soap.SOAPException;
import java.io.IOException;
import java.util.Date;

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

    Object callWebService(String url, ClientDataReqEBM request) {
        StringResult resultReq = new StringResult();
        jaxb2Marshaller.marshal(request, resultReq);
        System.out.print("resultReq ");
        System.out.println(resultReq.toString());

        return webServiceTemplate.marshalSendAndReceive(url, request, message -> {
                    SoapMessage soapMessage = (SoapMessage) message;
                    soapMessage.setSoapAction("DetailsAboutClients");
                    TransportContext context = TransportContextHolder.getTransportContext();
                    HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();
                    connection.addRequestHeader("Content-Type", "text/xml;charset=UTF-8");
                    connection.addRequestHeader("Date", new Date().toString());

                }
        );
//        return webServiceTemplate.marshalSendAndReceive(url, request, message -> {
//                    try {
//                        SaajSoapMessage soapMessage = (SaajSoapMessage) message;
//                        MimeHeaders headers = soapMessage.getSaajMessage().getMimeHeaders();
//                        headers.addHeader(TransportConstants.HEADER_CONTENT_TYPE, "application/xml;charset=utf-8");
//                        headers.addHeader(TransportConstants.HEADER_SOAP_ACTION, "DetailsAboutClients");
//                    } catch (Throwable e) {
//                        System.out.println(e.getMessage());
//                    }
//                }
//        );

    }

}


