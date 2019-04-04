package ru.neoflex.xml.clientebm;

public class ClientDataResEBM
{
    private Orders Orders;

    public Orders getOrders ()
    {
        return Orders;
    }

    public void setOrders (Orders Orders)
    {
        this.Orders = Orders;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Orders = "+Orders+"]";
    }
}

