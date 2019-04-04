package ru.example.neoflex.springbootsoapservice;

import org.springframework.stereotype.Component;
import ru.neoflex.xml.clientebm.Client;
import ru.neoflex.xml.clientebm.FullAddress;
import ru.neoflex.xml.customers.Customer;
import ru.neoflex.xml.customers.Orders;
import ru.neoflex.xml.customers.Request;

import javax.annotation.PostConstruct;
import javax.xml.soap.Name;

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

        FullAddress address = new FullAddress();
        address.setAddress(request.getCustomers().getCustomer().getFullAddress().getAddress());
        address.setCityName(request.getCustomers().getCustomer().getFullAddress().getCity());
        address.setRegionName(request.getCustomers().getCustomer().getFullAddress().getRegion());
        address.setPostal(request.getCustomers().getCustomer().getFullAddress().getPostalCode());
        address.setCountryName(request.getCustomers().getCustomer().getFullAddress().getCountry());
        client.setFullAddress(address);
        return client;

    }
}
