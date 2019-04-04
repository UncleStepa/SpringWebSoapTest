package ru.neoflex.xml.customers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "Customers"
})
@XmlRootElement(name = "Request")
public class Request
{
    @XmlElement(required = true)
    private Customers Customers;

    public ru.neoflex.xml.customers.Customers getCustomers ()
    {
        return Customers;
    }

    public void setCustomers (Customers Customers)
    {
        this.Customers = Customers;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Customers = "+Customers+"]";
    }
}
