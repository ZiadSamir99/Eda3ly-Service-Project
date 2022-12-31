package com.efa3lyservices.edfa3lysevices.Entity;

public interface Companies {


    public double getOffer();
    public String getcompanyName();

    double calcBills(double money);

    public void addDiscount(double discount);
    public String printTransaction();
}
