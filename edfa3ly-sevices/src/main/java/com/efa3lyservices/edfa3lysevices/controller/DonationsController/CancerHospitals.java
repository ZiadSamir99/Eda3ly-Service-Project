package com.efa3lyservices.edfa3lysevices.controller.DonationsController;
import com.efa3lyservices.edfa3lysevices.Entity.Organizations;
import com.efa3lyservices.edfa3lysevices.Entity.OrganizationsFactory;
import com.efa3lyservices.edfa3lysevices.controllerBsl.DonationsBsl.CancerhospitalA;
import org.springframework.stereotype.Service;

@Service
public class CancerHospitals implements OrganizationsFactory {

	@Override
	public Organizations getOrganization(String Organization) {
		if(Organization.equalsIgnoreCase("CancerhospitalA"))
			return CancerhospitalA.getinstance();
	return null;
	}

}
