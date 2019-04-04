package ru.example.neoflex.springbootsoapservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import ru.neoflex.xml.customers.Customer;
import ru.neoflex.xml.customers.Request;
import ru.neoflex.xml.customers.Response;

@Endpoint
public class CustomersEndpoint {
    private static final String NAMESPACE_URI = "http://www.howtodoinjava.com/xml/school";

    private TransformCSTMRSToULBS transformCSTMRSToULBS;

    @Autowired
    public CustomersEndpoint(TransformCSTMRSToULBS transformCSTMRSToULBS) {
        this.transformCSTMRSToULBS = transformCSTMRSToULBS;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "Request")
    @ResponsePayload
    public Response getCustomer(@RequestPayload Request request) {

        Response response = new Response();
        transformCSTMRSToULBS.firstTransform(request);



        return response;
    }
}
