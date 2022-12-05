import java.util.Scanner;

public class we implements Companies{
    double offerss=0;
    double money=0;
    double CompanyProfits=0;
    public static we object;
    private we(){}
    public static we getInstance(){
        if (object==null){
            object=new we();
        }
        return object;
    }
    @Override
    public void PrintService() {
        int product;
        System.out.println("Welcome To We");
        Scanner in=new Scanner(System.in);
        System.out.println("Enter phone number:");
        String number=in.next();
        System.out.println("Also we have offer which is "+this.offerss*100+"% \n");
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
        double val= this.money-(this.money*offerss);
        this.CompanyProfits+=val;
        return val;
    }


    @Override
    public void addDiscount(double discount) {
        this.offerss=discount;
    }
    @Override
    public void printTransaction() {
    	System.out.println("U have been Recharged by "+this.money+ "U got Offer"+this.offerss*100+"% \n"
                + "Ur new balance is : "+this.money+"Transaction Done Successefully Thank u !");

    }
    public double getOffer() {
    	return this.offerss;
    }
	@Override
	public String getcompanyName() {
		// TODO Auto-generated method stub
		return "We";
	}

}
