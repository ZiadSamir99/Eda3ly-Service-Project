package com.efa3lyservices.edfa3lysevices.controllerBsl.DonationsBsl;

import com.efa3lyservices.edfa3lysevices.Entity.Organizations;




public class SchoolA extends Organizations {
	public double donations=0;

	public static SchoolA object;
	private SchoolA() {}
	public static SchoolA getinstance() {
		if(object==null) {
			object=new SchoolA();
		}
		return object;
	}

	@Override
	public String AddDonation(double donations) {
		this.donations+=donations;
		this.money=donations;
		return "Transaction is done successfully "+this.getTotalDonations()+" to "+this.getname();
	}

	@Override
	public String getname() {
		// TODO Auto-generated method stub
		return "School A";
	}

	@Override
	public double getTotalDonations() {
		return this.donations;
	}

	
	

}
