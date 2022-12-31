package com.efa3lyservices.edfa3lysevices.controllerBsl.CompaniesBsl;

import com.efa3lyservices.edfa3lysevices.Entity.Companies;

import java.util.Scanner;
public class vodafone implements Companies {
    public double off=0.0;
    double money=0;
    double CompanyProfits=0;
    public static vodafone object;
    private vodafone(){}
    public static vodafone getInstance(){
        if (object==null){
            object=new vodafone();
        }
        return object;
    }


    public void setMoney(double money) {
        this.money = money;
    }



    @Override
    public double calcBills(double money)
    {
        this.money=money;
        double val= money-(money*off);
        this.CompanyProfits+=val;
        return val;
    }
    
    @Override
    public String printTransaction() {
    	return "U have been Recharged by "+this.money+ "U got Offer"+this.off*100+"% \n"
                +"Transaction Done Successefully Thank u !";

    }

    @Override
    public void addDiscount(double discount) {
        this.off=discount;
    }
    public double getOffer() {
    	return this.off;
    }
	@Override
	public String getcompanyName() {
		// TODO Auto- method stub
		return "Vodafone";
	}
}
