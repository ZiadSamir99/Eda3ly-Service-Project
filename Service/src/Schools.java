
public class Schools implements OrganizationsFactory {

	@Override
	public Organizations getOrganization(String Organization) {
		if(Organization.equalsIgnoreCase("SchoolA")) {
			return SchoolA.getinstance();}
		System.out.println("We have not School with that name ");
		return null;
	}

}
