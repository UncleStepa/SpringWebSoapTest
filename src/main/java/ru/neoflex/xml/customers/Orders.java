package ru.neoflex.xml.customers;

public class Orders
{
    private Order[] Order;

    public Order[] getOrder ()
    {
        return Order;
    }

    public void setOrder (Order[] Order)
    {
        this.Order = Order;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Order = "+Order+"]";
    }
}
