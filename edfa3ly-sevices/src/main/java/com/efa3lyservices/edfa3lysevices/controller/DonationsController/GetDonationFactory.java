package com.efa3lyservices.edfa3lysevices.controller.DonationsController;

import com.efa3lyservices.edfa3lysevices.Entity.OrganizationsFactory;
import org.springframework.stereotype.Service;

@Service
public class GetDonationFactory {
	public OrganizationsFactory getType(String Type) {
		if(Type.equalsIgnoreCase("Schools"))
			return new Schools();
		if(Type.equalsIgnoreCase("CancerHospitals"))
			return new CancerHospitals();
		if(Type.equalsIgnoreCase("NGOs"))
			return new NGOs();
		return null;
	}

}
