package com.efa3lyservices.edfa3lysevices.controllerBsl.DurationsBsl;

import com.efa3lyservices.edfa3lysevices.Entity.Duration;

public class Month implements Duration {
    double money;
    @Override
    public double cost() {
    	return (this.money-this.money*(10/100));
    	
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public String getDescritpion() {
        return "Monthly";
    }


}
