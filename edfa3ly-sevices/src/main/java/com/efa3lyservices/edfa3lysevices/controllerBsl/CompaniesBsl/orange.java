package com.efa3lyservices.edfa3lysevices.controllerBsl.CompaniesBsl;

import com.efa3lyservices.edfa3lysevices.Entity.Companies;

public class orange implements Companies {
    double offerss=0;
    double money=0;
    double CompanyProfits=0;
    public static orange object;
    private orange(){}
    public static orange getInstance(){
        if (object==null){
            object=new orange();
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
        double val=money-(money*offerss);
        this.CompanyProfits+=val;
        return val;
    }
    @Override
    public String printTransaction() {
    	return "U have been Recharged by "+this.money+ "U got Offer"+this.offerss*100+"% \n"
                +"Transaction Done Successefully Thank u !";

    }
    
    @Override
    public void addDiscount(double discount) {
        this.offerss=discount;
    }
    public double getOffer() {
    	return this.offerss;
    }
	@Override
	public String getcompanyName() {
		// TODO Auto-generated method stub
		return "Orange";
	}
}
