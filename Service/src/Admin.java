import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Admin implements Subject{

    int n=0;
    String message;
    private List<Observer>observers;
    private List<User>refunds =new ArrayList<>();
    boolean changed;
    HashMap<Integer,HashMap<User,Integer>>requests=new HashMap<Integer, HashMap<User,Integer>>();
    HashMap<User,Integer> val=new HashMap<User,Integer>();

    public void addRequests(User customer,int indexTrans)
    {
        customer.getTransactions();
        this.val.put(customer,indexTrans);
        this.requests.put(this.n,this.val);
    }
    public Admin(){
        this.observers=new ArrayList<>();
    }
    public void getRequests() {
        System.out.println(this.requests);
    }

    @Override
    public void register(Observer obs) {
        if(!observers.contains(obs))
            observers.add(obs);
    }

    @Override
    public void unregister(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        List<Observer>observerslocal=null;

        if (!changed)
            return;
        observerslocal=new ArrayList<>(this.observers);
        this.changed=false;
        for (Observer obs:observerslocal){
            obs.update();
        }
    }

    @Override
    public Object getUpdate(Observer obs) {
        return this.message;
    }
    public void postMessage(String s){
        System.out.println(s);
        this.message=s;
        this.changed=true;
        notifyObservers();
    }
    public void addusertorefund(User u) {
        this.refunds.add(u);
    }
    public void ListallRefunds() {
        System.out.println("Choose user number you want to refund ");
        for(int i=0;i<this.refunds.size();i++){
            System.out.println("User number : " + (i+1) + "   " +"His name is : "+ this.refunds.get(i).getName());
            Scanner in=new Scanner(System.in);
            int num=in.nextInt();
            num-=1;
            this.refunds.get(num).listRefunds();
            while(true) {
                System.out.println("Choose number of transaction u want to retrieve its price to user and if u want to exit press 0 ");
                int num1=in.nextInt();
                if(num1==0)
                    break;
                double val=this.refunds.get(num).ReturnRefund(num1);
                this.refunds.get(num).RemoveRefunds(num1);
                this.refunds.get(num).addNotification(val);
                //  this.refunds.get(num).update();
                if(this.refunds.get(num).isRefundsEmpty())
                    this.refunds.remove(num);
            }

        }
    }
    public boolean RefundsEmpty() {
    	if(this.refunds.isEmpty()) {
    		return true;
    	}
		return false;
    		
    }

}