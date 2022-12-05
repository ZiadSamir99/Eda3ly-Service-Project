import java.util.*;

public class User implements Observer{
    private Subject adminName;
    private List<String>Notifications=new ArrayList<>();
    private String name;
    private String Email;
    private String PhoneNumber;
    private String Password;
    private String creditCardNum;
    private int wallet;
    private int ServiceIndex=0;
    private int RefundsIndex=0;
    private HashMap<String,Double> Transactions=new HashMap<String,Double>();
    private HashMap<Integer,HashMap<String,Double>> TransactionswithIndex=new HashMap<Integer,HashMap<String,Double>>();
    private HashMap<Integer,HashMap<String,Double>> RefundRequest=new HashMap<Integer,HashMap<String,Double>>();
    private Payment p;

    public boolean setPayment(int s,double money){
        if (s==1){
            if (this.wallet>=money){
                this.wallet-=money;
                p=new Wallet();
                p.pay();
                return true;
            }else {
                System.out.println("wallet has no enough money!!");
                return false;
            }
        }else if (s==2){
            p=new CreditCard();
            p.pay();
            return true;
        }else{
            System.out.println("Paying cash");
            return false;
        }
    }
    public void addToWallet(int money,String CreditcardNum){
        if (creditCardNum.equalsIgnoreCase(CreditcardNum))
        {   wallet=wallet+money;
            System.out.println("done!!");
        }
        else System.out.println("wrong password!");

    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }
    public String getName() {
        return this.name;
    }
    public void signUp(){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter name");
        String name=in.nextLine();
        setName(name);
        System.out.println("Enter Email");
        String Email=in.nextLine();
        setEmail(Email);
        System.out.println("Enter password");
        String Password=in.nextLine();
        setPassword(Password);
        System.out.println("Enter Credit Card number");
        String CreditCardNum=in.nextLine();
        setCreditCardNum(CreditCardNum);
        System.out.println("Done");

    }
    public Boolean logIn(String email,String password){
        if (Email.equalsIgnoreCase(email) && Password.equalsIgnoreCase(password)){
            return true;
        }else return false;
    }

    public void setTransactions(String x,double val) {

        this.ServiceIndex++;
        this.Transactions.put(x,val);
        this.TransactionswithIndex.put(this.ServiceIndex,Transactions);
        //  this.Transactions.clear();
    }
    public void getTransactions() {
        System.out.println(this.TransactionswithIndex);
    }

    public void addNotification(double val){
        this.Notifications.add("Your refund has been accepted with refund= "+val);
    }
    public void showUpdates(){
        if (this.Notifications.isEmpty()){
            System.out.println("No new messages");
        }else {
            System.out.println("You have "+this.Notifications.size()+"messages");
            System.out.println(this.Notifications);
            this.Notifications.clear();
        }
    }
    @Override
    public void update() {
        String msg=(String) adminName.getUpdate(this);
        if (msg==null){
            System.out.println("No new message");
        }else
            System.out.println(msg);

    }

    @Override
    public void setSubject(Subject sub) {
        this.adminName=sub;
    }
    public void makeRefund() {
        if(this.TransactionswithIndex.isEmpty()) {
            System.out.println("You can not make refund you have no transactions ");
        }
        else
        {
            this.getTransactions();
            System.out.println("Choose number of Transaction you want to request Its refund");
            Scanner in=new Scanner(System.in);
            int num=in.nextInt();
            this.RefundsIndex++;
            this.RefundRequest.put(this.RefundsIndex,this.TransactionswithIndex.get(num));
            this.adminName.addusertorefund(this);


        }

    }
    public void listRefunds() {
        for(int i=0;i<this.RefundRequest.size();i++) {
            System.out.println(this.RefundRequest);
        }
    }
    public void RemoveRefunds(int indx) {




    }

    public int getWallet() {
        return this.wallet;
    }

    public double ReturnRefund(int ind) {
        HashMap<String,Double> temp=new HashMap<String,Double>();
        temp.putAll(this.RefundRequest.get(ind));
        double val1=0,val2=0;
        val1=this.wallet;
        temp.forEach((key, value)->{
            this.wallet+=value;
        });
        val2=this.wallet;
        return val2-val1;

    }
    public boolean isRefundsEmpty() {
        if(this.RefundRequest.isEmpty()) {
            return true;
        }
        return false;
    }


}