package ru.example.neoflex.springbootsoapservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import ru.neoflex.xml.clientebm.ClientDataReqEBM;
import ru.neoflex.xml.clientebm.ClientDataResEBM;
import ru.neoflex.xml.customers.CustomerRequest;
import ru.neoflex.xml.customers.CustomerResponse;

@Endpoint
public class CustomersEndpoint {
    private static final String NAMESPACE_URI = "http://www.neoflex.ru/xml/customers";

    private TransformCSTMRSToULBS transformCSTMRSToULBS;

    private StubRequest stubRequest;

    private String urlEBM;

    @Autowired
    public CustomersEndpoint(TransformCSTMRSToULBS transformCSTMRSToULBS, StubRequest stubRequest, String urlEBM) {
        this.transformCSTMRSToULBS = transformCSTMRSToULBS;
        this.stubRequest = stubRequest;
        this.urlEBM = urlEBM;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CustomerRequest")
    @ResponsePayload
    public CustomerResponse customerRequest(@RequestPayload CustomerRequest request) {

        CustomerResponse response = new CustomerResponse();
        try {
            ClientDataReqEBM reqEBM = transformCSTMRSToULBS.firstTransform(request);
            ClientDataResEBM resEBM = (ClientDataResEBM) stubRequest.callWebService(urlEBM, reqEBM);
            response = transformCSTMRSToULBS.firstTransform(resEBM);
        } catch (Throwable e) {
            System.out.print("Throwable CustomerResponse ");
            System.out.println(e.getMessage());
            throw e;
        }
        return response;
    }

}
