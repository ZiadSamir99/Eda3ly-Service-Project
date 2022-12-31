package com.efa3lyservices.edfa3lysevices.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String>Notifications=new ArrayList<String>();
    private String name;
    private String Email;
    private int id;
    private String PhoneNumber;
    private String Password;
    private String creditCardNum;
    private double wallet;
    private int ServiceIndex=0;
    private int RefundsIndex=0;
    private ArrayList<Transaction> Transactions;
    private ArrayList<Transaction> RefundRequest;


    public User(String email, String password, String name, int id, String creditCard){
        this.Email=email;
        this.Password=password;
        this.name=name;
        this.id=id;
        this.creditCardNum=creditCard;
        this.wallet=0;
        this.Transactions=new ArrayList<Transaction>();
        this.RefundRequest=new ArrayList<Transaction>();
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setRefundRequest(int id){
       this.RefundRequest.add(this.Transactions.get(id));
    }
    public ArrayList<Transaction> getRefundRequest(){
        return this.RefundRequest;
    }
    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }
    public String getName() {
        return this.name;
    }

    public Boolean logIn(String email,String password){
        if (Email.equalsIgnoreCase(email) && Password.equalsIgnoreCase(password)){
            return true;
        }else return false;
    }

    public int getId(){
        return this.id;
    }
   public void setTransactions(String x,double val,int id,String paymentMethod) {
        this.Transactions.add(new Transaction(x,val,id,paymentMethod));
   }

   public Transaction getTransactionByInd(int index){
        return this.Transactions.get(index);
   }

    public List<String> showUpdates(){
        if (this.Notifications.isEmpty()){
           List<String>s=new ArrayList<String>(2);
           s.add("No Notifications");
            return s;
        }else {
            return this.Notifications;
        }
    }

//    @Override
//    public void update() {
//        String msg=(String) adminName.getUpdate(this);
//        if (msg==null){
//            System.out.println("No new message");
//        }else
//            System.out.println(msg);
//
//    }
//
//    @Override
//    public void setSubject(Subject sub) {
//        this.adminName=sub;
//    }




    public double getWallet() {
        return this.wallet;
    }

//    public boolean isRefundsEmpty() {
//        if(this.RefundRequest.isEmpty()) {
//            return true;
//        }
//        return false;
//    }

    public ArrayList<Transaction> getTransactions() {
    return this.Transactions;
    }

    public void setNotifications(String notifyy) {
        this.Notifications.add(notifyy);

    }

}