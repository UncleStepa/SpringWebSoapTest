package ru.neoflex.xml.clientebm;

public class Adds
{
    private String Curr;

    private String PayWay;

    private String ProductType;

    private String Quantity;

    private String Amt;

    public String getCurr ()
    {
        return Curr;
    }

    public void setCurr (String Curr)
    {
        this.Curr = Curr;
    }

    public String getPayWay ()
    {
        return PayWay;
    }

    public void setPayWay (String PayWay)
    {
        this.PayWay = PayWay;
    }

    public String getProductType ()
    {
        return ProductType;
    }

    public void setProductType (String ProductType)
    {
        this.ProductType = ProductType;
    }

    public String getQuantity ()
    {
        return Quantity;
    }

    public void setQuantity (String Quantity)
    {
        this.Quantity = Quantity;
    }

    public String getAmt ()
    {
        return Amt;
    }

    public void setAmt (String Amt)
    {
        this.Amt = Amt;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Curr = "+Curr+", PayWay = "+PayWay+", ProductType = "+ProductType+", Quantity = "+Quantity+", Amt = "+Amt+"]";
    }
}
