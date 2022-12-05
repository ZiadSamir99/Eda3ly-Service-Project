import java.util.Scanner;

public class quarter implements Duration{
    double money;
	@Override
    public void printDuration() {
        System.out.println("it's quarter receipt");
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Landline number:");
        String number=in.next();
        System.out.println("Enter ur amount of money: ");
        int money=in.nextInt();
        this.setMoney(money);

    }
	public void setMoney(double money) {
		this.money=money;
	}
    @Override
    public double cost() {
    	return (this.money-this.money*(25/100));
    	
    }
}
