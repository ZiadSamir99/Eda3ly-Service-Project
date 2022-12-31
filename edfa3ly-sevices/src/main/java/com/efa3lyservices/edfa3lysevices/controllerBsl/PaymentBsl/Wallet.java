package com.efa3lyservices.edfa3lysevices.controllerBsl.PaymentBsl;

import com.efa3lyservices.edfa3lysevices.Entity.Payment;
import com.efa3lyservices.edfa3lysevices.models.User;
import org.springframework.stereotype.Service;

@Service
public class Wallet implements Payment {


    @Override
    public String pay(User u, double money,String destination) {
        if(u.getWallet()>=money){
            u.setWallet(u.getWallet()-money);
            return "1 done with money "+money+" to : "+destination+" ur current wallet is "+u.getWallet();
        }
        else return "Can not recharge u have no enough money ";

    }

}
