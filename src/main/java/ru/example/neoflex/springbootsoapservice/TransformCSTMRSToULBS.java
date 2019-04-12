package ru.example.neoflex.springbootsoapservice;


import org.springframework.stereotype.Component;
import ru.neoflex.xml.clientebm.ClientDataReqEBM;
import ru.neoflex.xml.clientebm.ClientDataResEBM;
import ru.neoflex.xml.clientebm.ClientType;
import ru.neoflex.xml.clientebm.OrderType;
import ru.neoflex.xml.customers.CustomerRequest;
import ru.neoflex.xml.customers.CustomerResponse;
import ru.neoflex.xml.customers.DetailsType;

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
        ClientDataReqEBM.Clients q = new ClientDataReqEBM.Clients();
        q.setClient(client);
        clientDataReqEBM.setClients(q);
        return clientDataReqEBM;

    }

    public CustomerResponse firstTransform(ClientDataResEBM request) {
        CustomerResponse response = new CustomerResponse();
        if (request != null && request.getOrders() != null && request.getOrders().getOrder().size() > 0) {
            request.getOrders().getOrder().forEach(orderType -> response.getOrders().getOrder().add(transformOrder(orderType)));
        }
        return response;

    }

    private ru.neoflex.xml.customers.OrderType transformOrder(OrderType orderType) {
        if (orderType == null) {

            System.err.println("orderType == null");
            return null;
        }
        ru.neoflex.xml.customers.OrderType resultOrder = new ru.neoflex.xml.customers.OrderType();

        resultOrder.setCustomerID(orderType.getClientId());
        resultOrder.setEmployeeID(orderType.getEmpID());
        resultOrder.setOrderID(orderType.getOrderID());
        resultOrder.setOrderDate(orderType.getDate());
        resultOrder.setRequiredDate(orderType.getDeliveryDate());

        if (orderType.getAdds() != null) {
            DetailsType detailsType = new DetailsType();
            detailsType.setAmount(orderType.getAdds().getAmt());
            detailsType.setItemType(orderType.getAdds().getProductType());
            detailsType.setCurrency(orderType.getAdds().getCurr());
            detailsType.setPaymentMethod(orderType.getAdds().getPayWay());
            detailsType.setNumber(orderType.getAdds().getQuantity());
            resultOrder.setDetails(detailsType);
        }

        return resultOrder;
    }

}
