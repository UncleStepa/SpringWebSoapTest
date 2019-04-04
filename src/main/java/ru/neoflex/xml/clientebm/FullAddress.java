package ru.neoflex.xml.clientebm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Student", propOrder = {
        "Address",
        "RegionName",
        "CountryName",
        "ClientID",
        "CityName",
        "Postal",
})

public class FullAddress
{
    @XmlElement(required = true)
    private String Address;
    @XmlElement(required = true)
    private String RegionName;
    @XmlElement(required = true)
    private String CountryName;
    @XmlElement(required = true)
    private String ClientID;
    @XmlElement(required = true)
    private String CityName;
    @XmlElement(required = true)
    private String Postal;
    @XmlElement(required = true)
    public String getAddress ()
    {
        return Address;
    }

    public void setAddress (String Address)
    {
        this.Address = Address;
    }

    public String getRegionName ()
    {
        return RegionName;
    }

    public void setRegionName (String RegionName)
    {
        this.RegionName = RegionName;
    }

    public String getCountryName ()
    {
        return CountryName;
    }

    public void setCountryName (String CountryName)
    {
        this.CountryName = CountryName;
    }

    public String getClientID ()
    {
        return ClientID;
    }

    public void setClientID (String ClientID)
    {
        this.ClientID = ClientID;
    }

    public String getCityName ()
    {
        return CityName;
    }

    public void setCityName (String CityName)
    {
        this.CityName = CityName;
    }

    public String getPostal ()
    {
        return Postal;
    }

    public void setPostal (String Postal)
    {
        this.Postal = Postal;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Address = "+Address+", RegionName = "+RegionName+", CountryName = "+CountryName+", ClientID = "+ClientID+", CityName = "+CityName+", Postal = "+Postal+"]";
    }
}
