
public class GetDonationFactory {
	OrganizationsFactory getType(String Type) {
		if(Type=="Schools")
			return new Schools();
		if(Type=="Cancer Hospitals")
			return new CancerHospitals();
		if(Type=="NGOs")
			return new NGOs();
		return null;
	}

}
