package com.efa3lyservices.edfa3lysevices.controller.DonationsController;
import com.efa3lyservices.edfa3lysevices.Entity.Organizations;
import com.efa3lyservices.edfa3lysevices.Entity.OrganizationsFactory;
import com.efa3lyservices.edfa3lysevices.controllerBsl.DonationsBsl.NGOA;
import org.springframework.stereotype.Service;

@Service
public class NGOs implements OrganizationsFactory {


	@Override
	public Organizations getOrganization(String Organization) {
		if(Organization.equalsIgnoreCase("NGOA"))
			return NGOA.getinstance();
		//System.out.println("We have not Non-Profit Organization with that name ");
	return null;
	}

}
