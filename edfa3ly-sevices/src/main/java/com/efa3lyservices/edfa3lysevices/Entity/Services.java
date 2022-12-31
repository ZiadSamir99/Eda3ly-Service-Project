package com.efa3lyservices.edfa3lysevices.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;

@Service
public abstract class Services {
    public Services(){

    }
    String description = "";
    public abstract void SetCompanies(Companies company);
    public abstract double cost(double money);




    public abstract String printService();


}
