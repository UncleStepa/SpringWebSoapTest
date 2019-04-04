package ru.neoflex.xml.customers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "Customer"
})
@XmlRootElement(name = "Customers")
public class Customers
{
    @XmlElement(required = true)
    private Customer Customer;

    public Customer getCustomer ()
    {
        return Customer;
    }

    public void setCustomer (Customer Customer)
    {
        this.Customer = Customer;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Customer = "+Customer+"]";
    }
}
