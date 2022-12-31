package com.efa3lyservices.edfa3lysevices.models;

public class Transaction {

    int id;
    String serviceName;
    double money;
    String paymentMethod;
    public Transaction(String service,double money,int id,String paymentMethod){
        this.money=money;
        this.serviceName=service;
        this.id=id;
        this.paymentMethod=paymentMethod;

    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
