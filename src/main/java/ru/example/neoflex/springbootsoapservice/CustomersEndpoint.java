package ru.example.neoflex.springbootsoapservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import ru.neoflex.xml.customers.CustomerRequest;
import ru.neoflex.xml.customers.CustomerResponse;

@Endpoint
public class CustomersEndpoint {
    private static final String NAMESPACE_URI = "http://www.neoflex.ru/xml/customers";

    private TransformCSTMRSToULBS transformCSTMRSToULBS;

    private StubRequest stubRequest;

    @Autowired
    public CustomersEndpoint(TransformCSTMRSToULBS transformCSTMRSToULBS, StubRequest stubRequest) {
        this.transformCSTMRSToULBS = transformCSTMRSToULBS;
        this.stubRequest = stubRequest;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CustomerRequest")
    @ResponsePayload
    public CustomerResponse getCustomer(@RequestPayload CustomerRequest request) throws Exception {

        CustomerResponse response = new CustomerResponse();
        System.out.println("getCustomer");
        //transformCSTMRSToULBS.firstTransform(request);
        try {
            System.out.println(stubRequest.callWebService("http://localhost:8088/mockClientsDetailsPortSoap11", transformCSTMRSToULBS.firstTransform(request)).getClass().getName());
        }catch (Throwable e){
            System.out.println(e.getMessage());
        }
        return response;
    }

}
