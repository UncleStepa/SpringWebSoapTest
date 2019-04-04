package ru.neoflex.xml.clientebm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "MobileNumber",
        "FullAddress",
        "ClientID",
        "MiddleName",
        "Surname",
        "Name",
        "BirthDate"
})
@XmlRootElement(name = "Client")
public class Client
{
    private String MobileNumber;

    private FullAddress FullAddress;

    private String ClientID;

    private String MiddleName;

    private String Surname;

    private String Name;

    private String BirthDate;

    public String getMobileNumber ()
    {
        return MobileNumber;
    }

    public void setMobileNumber (String MobileNumber)
    {
        this.MobileNumber = MobileNumber;
    }

    public FullAddress getFullAddress ()
    {
        return FullAddress;
    }

    public void setFullAddress (FullAddress FullAddress)
    {
        this.FullAddress = FullAddress;
    }

    public String getClientID ()
    {
        return ClientID;
    }

    public void setClientID (String ClientID)
    {
        this.ClientID = ClientID;
    }

    public String getMiddleName ()
    {
        return MiddleName;
    }

    public void setMiddleName (String MiddleName)
    {
        this.MiddleName = MiddleName;
    }

    public String getSurname ()
    {
        return Surname;
    }

    public void setSurname (String Surname)
    {
        this.Surname = Surname;
    }

    public String getName ()
    {
        return Name;
    }

    public void setName (String Name)
    {
        this.Name = Name;
    }

    public String getBirthDate ()
    {
        return BirthDate;
    }

    public void setBirthDate (String BirthDate)
    {
        this.BirthDate = BirthDate;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [MobileNumber = "+MobileNumber+", FullAddress = "+FullAddress+", ClientID = "+ClientID+", MiddleName = "+MiddleName+", Surname = "+Surname+", Name = "+Name+", BirthDate = "+BirthDate+"]";
    }
}
