
public class CancerHospitals implements OrganizationsFactory {

	@Override
	public Organizations getOrganization(String Organization) {
		if(Organization.equalsIgnoreCase("CancerhospitalA"))
			return CancerhospitalA.getinstance();
		System.out.println("We have not Cancer Hospital with that name ");
return null;
	}

}
