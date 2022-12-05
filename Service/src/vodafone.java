import java.util.Scanner;
public class vodafone implements Companies{
    public double off=0.0;
    double money=0;
    double CompanyProfits=0;
    public static vodafone object;
    private vodafone(){}
    public static vodafone getInstance(){
        if (object==null){
            object=new vodafone();
        }
        return object;
    }
    
    @Override
    public void PrintService() {
        System.out.println("Welcome To Vodafone");
        Scanner in=new Scanner(System.in);
        System.out.println("Enter phone number:");
        String number=in.next();
        System.out.println("Also we have offer which is "+this.off*100+"% \n");
        System.out.println("Enter ur amount of money: ");
        int money=in.nextInt();
        setMoney(money);
    }


    public void setMoney(int money) {
        this.money = money;
    }



    @Override
    public double calcBills()
    {
        double val= this.money-(this.money*off);
        this.CompanyProfits+=val;
        return val;
    }
    
    @Override
    public void printTransaction() {
    	System.out.println("U have been Recharged by "+this.money+ "U got Offer"+this.off*100+"% \n"
                + "Ur new balance is : "+this.money+"Transaction Done Successefully Thank u !");

    }

    @Override
    public void addDiscount(double discount) {
        this.off=discount;
    }
    public double getOffer() {
    	return this.off;
    }
	@Override
	public String getcompanyName() {
		// TODO Auto- method stub
		return "Vodafone";
	}
}
