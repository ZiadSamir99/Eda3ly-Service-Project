import java.util.Scanner;

public class CancerhospitalA extends Organizations {

	public static CancerhospitalA object;
	private CancerhospitalA() {}
	public static CancerhospitalA getinstance() {
		if(object==null) {
			object=new CancerhospitalA();
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
		return "Cancer Hospital 1";
	}

	@Override
	public double getTotalDonations() {
		return this.donations;
	}

	@Override
	public void Print() {
		System.out.println("Welcome There its our pleasur to help us to develope our Cancer Hospital "
				+ "Which is called 'Cancer Hospital 1 ' ");
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
