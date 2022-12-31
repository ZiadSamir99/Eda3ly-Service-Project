package com.efa3lyservices.edfa3lysevices.controllerBsl.RecieptsBsl;
import com.efa3lyservices.edfa3lysevices.Entity.Duration;
import com.efa3lyservices.edfa3lysevices.Entity.Reciepts;

public class Landline implements Reciepts {

    String number;
    double money;
    Duration duration;
    private static Landline landline_instance = null;

    private Landline(String number)
    {

        this.number = number;
    }
    public static Landline getInstance(String number)
    {

        if (landline_instance == null)
            landline_instance=new Landline(number);
        return landline_instance;

    }
    @Override
    public double CalBills() {

        return duration.cost();
    }

    @Override
    public void SetDuration(Duration dur)
    {
         duration=dur;

    }

    public String setMoney(double money)
    {
        this.duration.setMoney(money);
        return "money sent "+this.CalBills()+"with duration: "+this.duration.getDescritpion();
    }

    @Override
    public String getServiceName() {
        return "Landline";
    }

    public double getMoney() {
        return money;
    }

    public String getNumber() {
        return number;
    }
}
