package ru.neoflex.xml.customers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customer", propOrder = {
        "FirstName",
        "Phone",
        "CustomerID",
        "LastName",
        "MiddleName",
        "BirthDateTime",
})
public class Customer{

    @XmlElement(required = true)
    private FullAddress FullAddress;
    @XmlElement(required = true)
    private String FirstName;
    @XmlElement(required = true)
    private String Phone;
    @XmlElement(required = true)
    private String CustomerID;
    @XmlElement(required = true)
    private String LastName;
    @XmlElement(required = true)
    private String MiddleName;
    @XmlElement(required = true)
    private String BirthDateTime;

    public FullAddress getFullAddress ()
    {
        return FullAddress;
    }

    public void setFullAddress (FullAddress FullAddress)
    {
        this.FullAddress = FullAddress;
    }

    public String getFirstName ()
    {
        return FirstName;
    }

    public void setFirstName (String FirstName)
    {
        this.FirstName = FirstName;
    }

    public String getPhone ()
    {
        return Phone;
    }

    public void setPhone (String Phone)
    {
        this.Phone = Phone;
    }

    public String getCustomerID ()
    {
        return CustomerID;
    }

    public void setCustomerID (String CustomerID)
    {
        this.CustomerID = CustomerID;
    }

    public String getLastName ()
    {
        return LastName;
    }

    public void setLastName (String LastName)
    {
        this.LastName = LastName;
    }

    public String getMiddleName ()
    {
        return MiddleName;
    }

    public void setMiddleName (String MiddleName)
    {
        this.MiddleName = MiddleName;
    }

    public String getBirthDateTime ()
    {
        return BirthDateTime;
    }

    public void setBirthDateTime (String BirthDateTime)
    {
        this.BirthDateTime = BirthDateTime;
    }


}
