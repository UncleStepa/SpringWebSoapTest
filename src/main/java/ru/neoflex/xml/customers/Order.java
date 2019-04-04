package ru.neoflex.xml.customers;

public class Order
{
    private String RequiredDate;

    private Details Details;

    private String CustomerID;

    private String EmployeeID;

    private String OrderID;

    private String OrderDate;

    public String getRequiredDate ()
    {
        return RequiredDate;
    }

    public void setRequiredDate (String RequiredDate)
    {
        this.RequiredDate = RequiredDate;
    }

    public Details getDetails ()
    {
        return Details;
    }

    public void setDetails (Details Details)
    {
        this.Details = Details;
    }

    public String getCustomerID ()
    {
        return CustomerID;
    }

    public void setCustomerID (String CustomerID)
    {
        this.CustomerID = CustomerID;
    }

    public String getEmployeeID ()
    {
        return EmployeeID;
    }

    public void setEmployeeID (String EmployeeID)
    {
        this.EmployeeID = EmployeeID;
    }

    public String getOrderID ()
    {
        return OrderID;
    }

    public void setOrderID (String OrderID)
    {
        this.OrderID = OrderID;
    }

    public String getOrderDate ()
    {
        return OrderDate;
    }

    public void setOrderDate (String OrderDate)
    {
        this.OrderDate = OrderDate;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [RequiredDate = "+RequiredDate+", Details = "+Details+", CustomerID = "+CustomerID+", EmployeeID = "+EmployeeID+", OrderID = "+OrderID+", OrderDate = "+OrderDate+"]";
    }
}
