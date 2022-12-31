package com.efa3lyservices.edfa3lysevices.controllerBsl.DonationsBsl;

import com.efa3lyservices.edfa3lysevices.Entity.Organizations;

public class CancerhospitalA extends Organizations {

	public double donations=0;

	public static CancerhospitalA object;
	private CancerhospitalA() {}
	public static CancerhospitalA getinstance() {
		if(object==null) {
			object=new CancerhospitalA();
		}
		return object;
	}

	@Override
	public String AddDonation(double donations) {
		this.donations += donations;
		this.money=donations;
		getTotalDonations();
		return "Transaction is done successfully "+this.getTotalDonations()+" to "+this.getname();
	}

	@Override
	public String getname() {
		// TODO Auto-generated method stub
		return "Cancer Hospital 1";
	}

	@Override
	public double getTotalDonations() {
		return this.donations;
	}


}
