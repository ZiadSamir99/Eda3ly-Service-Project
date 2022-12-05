import java.util.Scanner;
public class NGOA extends Organizations {

	public static NGOA object;
	private NGOA() {}
	public static NGOA getinstance() {
		if(object==null) {
			object=new NGOA();
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
		return "NGO 1";
	}

	@Override
	public double getTotalDonations() {
		return this.donations;
	}

	@Override
	public void Print() {
		System.out.println("Welcome There, its our pleasure to help us to develope "+this.getname()+" Organization");
		System.out.println("How much will you Donate ?");
		Scanner in=new Scanner(System.in);
		double don=in.nextInt();
		this.AddDonation(don);
		System.out.println("By ur help we will reach to : "+this.getTotalDonations()+"LE\n"
				+ "Thank u <3");
	}
	@Override
	public double cost() {
		return this.money;
	}

}
