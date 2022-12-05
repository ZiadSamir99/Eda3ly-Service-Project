

public class MobileRecharge extends Services{


   Companies company;
   public static MobileRecharge object;
   private MobileRecharge(){};
   public static MobileRecharge getInstance(){
       if (object==null){
           object = new MobileRecharge();
       }
       return object;
   }


    public void printService(){
        System.out.println("Mobile Recharge Services");
    }
    @Override
    public void SetCompanies(Companies company) {
        this.company=company;
    }

    @Override
    public double cost() {
        return this.company.calcBills();
    }

    @Override
    public void getDescription() {
        this.company.PrintService();
    }
}
