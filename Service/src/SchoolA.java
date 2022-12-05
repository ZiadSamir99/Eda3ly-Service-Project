import java.util.Scanner;

public class SchoolA extends Organizations {

	public static SchoolA object;
	private SchoolA() {}
	public static SchoolA getinstance() {
		if(object==null) {
			object=new SchoolA();
		}
		return object;
	}
	@Override
	void AddDonation(double donations) {
		this.donations+=donations;
		this.money=donations;
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

	@Override
	public void Print() {
		System.out.println("Welcome There its our pleasur to help us to develope our school"
				+ "Which is called 'School A ' ");
		System.out.println("How much u will Donate ?");
		Scanner in=new Scanner(System.in);
		double don=in.nextInt();
		this.AddDonation(don);
		System.out.println("By ur help we now reached to : "+this.getTotalDonations()+"LE\n"
				+ "Thhank u 3>");
		
		
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.money;
	}
	
	

}
