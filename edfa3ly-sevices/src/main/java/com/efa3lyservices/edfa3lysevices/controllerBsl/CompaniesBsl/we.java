package com.efa3lyservices.edfa3lysevices.controllerBsl.CompaniesBsl;

import com.efa3lyservices.edfa3lysevices.Entity.Companies;
public class we implements Companies {
    double offerss=0;
    double money=0;
    double CompanyProfits=0;
    public static we object;
    private we(){}
    public static we getInstance(){
        if (object==null){
            object=new we();
        }
        return object;
    }


    @Override
    public double calcBills(double money)
    {
        double val= money-(money*offerss);
        this.CompanyProfits+=val;
        return val;
    }


    @Override
    public void addDiscount(double discount) {
        this.offerss=discount;
    }
    @Override
    public String printTransaction() {
    	return "U have been Recharged by "+this.money+ "U got Offer"+this.offerss*100+"% \n"
                +"Transaction Done Successefully Thank u !";

    }
    public double getOffer() {
    	return this.offerss;
    }
	@Override
	public String getcompanyName() {
		// TODO Auto-generated method stub
		return "We";
	}

}
