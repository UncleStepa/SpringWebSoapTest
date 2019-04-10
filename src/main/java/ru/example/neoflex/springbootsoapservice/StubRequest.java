package ru.example.neoflex.springbootsoapservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.net.URISyntaxException;

@Component
public class StubRequest {
    private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

    @Autowired
    public StubRequest(String urlEBM, Jaxb2Marshaller jaxb2Marshaller) {
        webServiceTemplate.setDefaultUri(urlEBM);
        webServiceTemplate.setMarshaller(jaxb2Marshaller);
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller);
    }

    public Object callWebService(String url, Object request) throws URISyntaxException {
        StreamSource source = new StreamSource(String.valueOf(request));
        StreamResult result = new StreamResult(System.out);
        webServiceTemplate.sendSourceAndReceiveToResult(url, source, new ActionCallback("DetailsAboutClients"), result);
        return result;
    }
}


