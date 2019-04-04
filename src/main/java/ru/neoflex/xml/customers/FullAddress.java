package ru.neoflex.xml.customers;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Student", propOrder = {
        "Address",
        "Region",
        "PostalCode",
        "Country",
        "CustomerID",
        "City",
})
public class FullAddress
{
    @XmlElement(required = true)
    private String Address;
    @XmlElement(required = true)
    private String Region;
    @XmlElement(required = true)
    private String PostalCode;
    @XmlElement(required = true)
    private String Country;
    @XmlElement(required = true)
    private String CustomerID;
    @XmlElement(required = true)
    private String City;

    public String getAddress ()
    {
        return Address;
    }

    public void setAddress (String Address)
    {
        this.Address = Address;
    }

    public String getRegion ()
    {
        return Region;
    }

    public void setRegion (String Region)
    {
        this.Region = Region;
    }

    public String getPostalCode ()
    {
        return PostalCode;
    }

    public void setPostalCode (String PostalCode)
    {
        this.PostalCode = PostalCode;
    }

    public String getCountry ()
    {
        return Country;
    }

    public void setCountry (String Country)
    {
        this.Country = Country;
    }

    public String getCustomerID ()
    {
        return CustomerID;
    }

    public void setCustomerID (String CustomerID)
    {
        this.CustomerID = CustomerID;
    }

    public String getCity ()
    {
        return City;
    }

    public void setCity (String City)
    {
        this.City = City;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Address = "+Address+", Region = "+Region+", PostalCode = "+PostalCode+", Country = "+Country+", CustomerID = "+CustomerID+", City = "+City+"]";
    }
}
