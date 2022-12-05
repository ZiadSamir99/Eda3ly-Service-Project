

public class Internet extends Services{


    Companies company;
    public static Internet object;
    private Internet(){};
    public static Internet getInstance(){
        if (object==null){
            object = new Internet();
        }
        return object;
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

    @Override
    public void printService() {
        System.out.println("Internet Services");
    }
}
