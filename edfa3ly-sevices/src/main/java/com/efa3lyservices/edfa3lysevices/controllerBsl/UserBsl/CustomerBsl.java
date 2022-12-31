package com.efa3lyservices.edfa3lysevices.controllerBsl.UserBsl;

import com.efa3lyservices.edfa3lysevices.Entity.Payment;
import com.efa3lyservices.edfa3lysevices.models.Transaction;
import com.efa3lyservices.edfa3lysevices.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerBsl {
    public static List<User>users;
    public static List<Transaction>userRefunds;
    private Payment p;

    public CustomerBsl(){
       users= new ArrayList<User>();
       userRefunds= new ArrayList<Transaction>();
    }

    public User getUser(int id){
        for (User USER:users) {
            if (USER.getId()==id){
                return USER;
            }
        }
        return null;
    }
    public void removeRefundReq(int idx){
        this.getAllrefunds().remove(idx);
    }
     public String registerUser(User user){
        for (User users: users) {
            if (users.getEmail().equalsIgnoreCase(user.getEmail())){
                return "this account already exists!!";
            }

        }

        this.users.add(user);
        return "registered successfully!!";
    }
    public String Login(User user1){
        for (User Users:users) {
            if (Users.getEmail().equalsIgnoreCase(user1.getEmail()) && Users.getPassword().equalsIgnoreCase(user1.getPassword())){
                return "login Successfully!";
            }
        }
        return "please register first!";
    }

    public String addMoneyToWallet(User user , double money,int id){
            for (User users:users) {
                if (user.getCreditCardNum().equalsIgnoreCase(users.getCreditCardNum())) {
                    double wal = users.getWallet() + money;
                    users.setWallet(wal);
                    users.setTransactions("Add money to wallet",money,id,"creditcard");
                    return "money added successfully!!";
                }
            }
            return "wrong password!";

        }
    public String addTransaction(String name,double money,int id,String paymentMethod){
        for (User user:users){
         if (user.getId()==id){
             user.setTransactions(name,money,user.getId(),paymentMethod);
             if(paymentMethod.equalsIgnoreCase("wallet"))
             {
                     user.setWallet(user.getWallet()-money);
             }
             return "Transaction done successfully!! \n Service Name: "+name+" to "+user.getName();
         }
        }
        return "incorrect id";

    }
    public void removeTransaction(int indx,User user){
        for (User user1:users){
            if(user1.getId()==user.getId()){
                user1.getTransactions().remove(indx);
            }
        }
    }
    public String addRefundRequest(User user,int index){
        for (User User1:users){
            if (user.getId()==User1.getId()){
                this.userRefunds.add(User1.getTransactionByInd(index));
                User1.setRefundRequest(index);
                return "User request added successfully!";
            }

        }
        return "User not found!!";

    }

    public List<Transaction> getRefundRequests(int id){
        for (User User1:users){
            if (id==User1.getId()){
               return User1.getRefundRequest();
            }
        }
    return null;
    }

    public List<Transaction> getAllrefunds() {
        return this.userRefunds;
    }

    public String notify(String note,User user){
        user.setNotifications(note);
        return "Done";
    }
     public String removeRequest(int idx,User user){
        user.getRefundRequest().remove(idx);
        return "Removed Successfully !";
    }
    public List<String> listNotifications(User user){
        return user.showUpdates();
    }
}


