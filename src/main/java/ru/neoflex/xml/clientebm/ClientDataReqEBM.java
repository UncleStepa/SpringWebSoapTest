package ru.neoflex.xml.clientebm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "Clients"
})
@XmlRootElement(name = "ClientDataReqEBM")
public class ClientDataReqEBM
{
    private Clients Clients;

    public Clients getClients ()
    {
        return Clients;
    }

    public void setClients (Clients Clients)
    {
        this.Clients = Clients;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Clients = "+Clients+"]";
    }
}
