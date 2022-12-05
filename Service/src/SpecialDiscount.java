import java.util.ArrayList;
import java.util.List;

public class SpecialDiscount extends Discount{
    public List<Companies> Serv=new ArrayList<>();
    public static SpecialDiscount object;
    private SpecialDiscount(){}
    public static SpecialDiscount getInstance(){
        if (object==null){
            object=new SpecialDiscount();
        }
        return object;
    }
    @Override
    public void addCompanyList(Companies c) {
        this.Serv.add(c);
    }

    @Override
    public void addDiscountToComp(double discount) {
        for(Companies c : this.Serv) {
        	c.addDiscount(discount);
        }

    }
	@Override
	public void removeDiscount(Companies c) {
		String N=c.getcompanyName();
		boolean flag=false;
		String temp="";
		for(int i=0;i<this.Serv.size();i++) {
			if(this.Serv.get(i).getcompanyName()==N) {
				this.Serv.get(i).addDiscount(0.0);
				temp=this.Serv.get(i).getcompanyName();
				this.Serv.remove(i);
				flag=true;
				break;
				
			}
			
		}
		if(!flag) {
			System.out.println("This company has no discount at all !! ");
		}
		else
		{
			System.out.println("Discount has been removed Successfully :) from  : " + temp);
		}
	}
    
}
