package ru.neoflex.xml.customers;

public class Details
{
    private String Number;

    private String ItemType;

    private String Amount;

    private String Currency;

    private String PaymentMethod;

    public String getNumber ()
    {
        return Number;
    }

    public void setNumber (String Number)
    {
        this.Number = Number;
    }

    public String getItemType ()
    {
        return ItemType;
    }

    public void setItemType (String ItemType)
    {
        this.ItemType = ItemType;
    }

    public String getAmount ()
    {
        return Amount;
    }

    public void setAmount (String Amount)
    {
        this.Amount = Amount;
    }

    public String getCurrency ()
    {
        return Currency;
    }

    public void setCurrency (String Currency)
    {
        this.Currency = Currency;
    }

    public String getPaymentMethod ()
    {
        return PaymentMethod;
    }

    public void setPaymentMethod (String PaymentMethod)
    {
        this.PaymentMethod = PaymentMethod;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Number = "+Number+", ItemType = "+ItemType+", Amount = "+Amount+", Currency = "+Currency+", PaymentMethod = "+PaymentMethod+"]";
    }
}
