package ru.neoflex.xml.clientebm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "Client"
})

public class Clients
{
    private Client Client;

    public Client getClient ()
    {
        return Client;
    }

    public void setClient (Client Client)
    {
        this.Client = Client;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Client = "+Client+"]";
    }
}
