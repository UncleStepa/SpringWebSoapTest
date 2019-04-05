package ru.example.neoflex.springbootsoapservice;


import org.springframework.stereotype.Component;
import ru.neoflex.xml.clientebm.ClientDataReqEBM;
import ru.neoflex.xml.clientebm.ClientType;
import ru.neoflex.xml.customers.CustomerRequest;

@Component
public class TransformCSTMRSToULBS {


    public ClientDataReqEBM firstTransform(CustomerRequest request) {
        ClientDataReqEBM clientDataReqEBM = new ClientDataReqEBM();
        ClientType client = new ClientType();
        client.setSurname(request.getCustomers().getCustomer().getLastName());
        client.setName(request.getCustomers().getCustomer().getFirstName());
        client.setMiddleName(request.getCustomers().getCustomer().getMiddleName());
        client.setClientID(request.getCustomers().getCustomer().getCustomerID());
        client.setBirthDate(request.getCustomers().getCustomer().getBirthDateTime());
        client.setMobileNumber(request.getCustomers().getCustomer().getPhone());

        ru.neoflex.xml.clientebm.AddressType address = new ru.neoflex.xml.clientebm.AddressType();
        address.setAddress(request.getCustomers().getCustomer().getFullAddress().getAddress());
        address.setCityName(request.getCustomers().getCustomer().getFullAddress().getCity());
        address.setRegionName(request.getCustomers().getCustomer().getFullAddress().getRegion());
        address.setPostal(request.getCustomers().getCustomer().getFullAddress().getPostalCode());
        address.setCountryName(request.getCustomers().getCustomer().getFullAddress().getCountry());
        client.setFullAddress(address);
        System.out.println("transform1");
        ClientDataReqEBM.Clients q = new ClientDataReqEBM.Clients();
        q.setClient(client);
        clientDataReqEBM.setClients(q);
        return clientDataReqEBM;

    }

}
