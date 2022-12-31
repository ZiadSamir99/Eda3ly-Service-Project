package com.efa3lyservices.edfa3lysevices.controllerBsl.DurationsBsl;

import com.efa3lyservices.edfa3lysevices.Entity.Duration;
//import com.efa3lyservices.edfa3lysevices.Entity.Duration;


public class quarter implements Duration {
    double money;
	@Override
    public double cost() {
    	return (this.money-this.money*(25/100));
    	
    }
    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }
    public String getDescritpion() {
        return "quarterly";
    }
    }
