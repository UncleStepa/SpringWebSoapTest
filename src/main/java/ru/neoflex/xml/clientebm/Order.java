package ru.neoflex.xml.clientebm;

public class Order
{
    private String ClientId;

    private String DeliveryDate;

    private String EmpID;

    private String OrderID;

    private Adds Adds;

    private String Date;

    public String getClientId ()
    {
        return ClientId;
    }

    public void setClientId (String ClientId)
    {
        this.ClientId = ClientId;
    }

    public String getDeliveryDate ()
    {
        return DeliveryDate;
    }

    public void setDeliveryDate (String DeliveryDate)
    {
        this.DeliveryDate = DeliveryDate;
    }

    public String getEmpID ()
    {
        return EmpID;
    }

    public void setEmpID (String EmpID)
    {
        this.EmpID = EmpID;
    }

    public String getOrderID ()
    {
        return OrderID;
    }

    public void setOrderID (String OrderID)
    {
        this.OrderID = OrderID;
    }

    public Adds getAdds ()
    {
        return Adds;
    }

    public void setAdds (Adds Adds)
    {
        this.Adds = Adds;
    }

    public String getDate ()
    {
        return Date;
    }

    public void setDate (String Date)
    {
        this.Date = Date;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ClientId = "+ClientId+", DeliveryDate = "+DeliveryDate+", EmpID = "+EmpID+", OrderID = "+OrderID+", Adds = "+Adds+", Date = "+Date+"]";
    }
}
