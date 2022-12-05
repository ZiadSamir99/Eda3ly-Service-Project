
public class NGOs implements OrganizationsFactory {

	@Override
	public Organizations getOrganization(String Organization) {
		if(Organization.equalsIgnoreCase("NGOA"))
			return NGOA.getinstance();
		System.out.println("We have not Non-Profit Organization with that name ");
	return null;
	}

}
