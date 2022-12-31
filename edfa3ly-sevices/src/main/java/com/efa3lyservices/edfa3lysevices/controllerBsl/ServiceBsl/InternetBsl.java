package com.efa3lyservices.edfa3lysevices.controllerBsl.ServiceBsl;

import com.efa3lyservices.edfa3lysevices.Entity.Companies;
import com.efa3lyservices.edfa3lysevices.Entity.Services;
import org.springframework.stereotype.Service;

@Service
public class InternetBsl extends Services {


    Companies company;
//    public static InternetBsl object;
//    private InternetBsl(){};
//    public static InternetBsl getInstance(){
//        if (object==null){
//            object = new InternetBsl();
//        }
//        return object;
//    }

    public InternetBsl(){
        printService();
    }

    @Override
    public void SetCompanies(Companies company) {

        this.company=company;
    }

    @Override
    public double cost(double money) {

        return this.company.calcBills(money);
    }



    @Override
    public String printService() {
        return "welcome to internet services";
    }
}
