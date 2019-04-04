package ru.example.neoflex.springbootsoapservice;

import org.springframework.stereotype.Component;
import ru.neoflex.xml.clientebm.Client;
import ru.neoflex.xml.customers.Customer;
import ru.neoflex.xml.customers.Orders;
import ru.neoflex.xml.customers.Request;

import javax.annotation.PostConstruct;

@Component
public class TransformCSTMRSToULBS {


    public Client firstTransform(Request request){

        Client client = new Client();
        client.setSurname(request.getCustomers().getCustomer().getLastName());
        client.setName(request.getCustomers().getCustomer().getFirstName());
        client.setMiddleName(request.getCustomers().getCustomer().getMiddleName());
        client.setClientID(request.getCustomers().getCustomer().getCustomerID());
        client.setBirthDate(request.getCustomers().getCustomer().getBirthDateTime());
        client.setMobileNumber(request.getCustomers().getCustomer().getPhone());
        client.getFullAddress().setAddress(request.getCustomers().getCustomer().getFullAddress().getAddress());
        client.getFullAddress().setCityName(request.getCustomers().getCustomer().getFullAddress().getCity());
        client.getFullAddress().setRegionName(request.getCustomers().getCustomer().getFullAddress().getRegion());
        client.getFullAddress().setPostal(request.getCustomers().getCustomer().getFullAddress().getPostalCode());
        client.getFullAddress().setCountryName(request.getCustomers().getCustomer().getFullAddress().getCountry());
        return client;
    }
}
