import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class main {
    public static void main(String[] args) {
//
//        ServiceFactory s= new ServiceFactory();
//        Services obj=s.createService("Internet");
//        Companies c=new etisalat();
//        Discount d=new Discount10();
//
//        System.out.println(c.calccost(10));
//        System.out.println(c.getcost());
//        obj.SetCompanies(c);
//        obj.getDescription();

        Scanner in = new Scanner(System.in);
        User[] x = new User[10];
        int count = -1;
        List<Companies>servss=new ArrayList<>();
        servss.add(vodafone.getInstance());
        servss.add(etisalat.getInstance());
        servss.add(orange.getInstance());
        servss.add(we.getInstance());

        Admin admin=new Admin();
        while (true) {
            User customer=null;
            System.out.println("Welcome to Edfa3ly");
            System.out.println("1)Register as an Admin\n2)Register as Customer\n3)Exit the program");
            int startnum = in.nextInt();
            if (startnum ==1)
            {
                System.out.println("For refund list enter 1\nFor adding Discount enter 2");
                int start = in.nextInt();
                if (start ==1){
                		if(admin.RefundsEmpty()) {
                	
                		System.out.println("You have no requests at current time");
                		}
                	
                	else {
                   
                		admin.ListallRefunds();
                		}
                	}
                else if (start ==2) {
                    System.out.println("for special discount write 1\nfor overall discount write 2");
                    int DiscountNum = in.nextInt();
                    Discount d1=null;
                    if (DiscountNum == 1) {
                        d1=SpecialDiscount.getInstance();
                        
                        System.out.println("Write 1 to add Discount\n 2 to remove discount ");
                        int n=in.nextInt();
                        if(n==1) {
                        while (true) {
                            System.out.println("enter service provider (NAME as String as shown) to be discounted");
                            System.out.println("1)Vodafone\n2)Etisalat\n3)We\n4)Orange");
                            String servicePro = in.next();
                            Companies c=null;
                            if (servicePro.equalsIgnoreCase("Vodafone")) {
                                    c=vodafone.getInstance();
                            } else if (servicePro.equalsIgnoreCase("Etisalat")) {
                                    c=etisalat.getInstance();
                            } else if (servicePro.equalsIgnoreCase("We")) {
                                    c=we.getInstance();
                            } else if (servicePro.equalsIgnoreCase("Orange")) {
                                    c=orange.getInstance();
                            }
                            d1.addCompanyList(c);
                            System.out.println("Enter Discount you want to add:");
                            int value= in.nextInt();
                            if(value>=0 || value<=100) {
                            double discountPrice=(value/100.0);
                            d1.addDiscountToComp(discountPrice);
                            System.out.println(c.getOffer()*100+"%");
                            admin.postMessage("Discount has been added for you!"+ value+"%");
                            }
                            else
                            {
                            	System.out.println("This Offer is not available u Can not buy Items for free \n"
                            			+ "Or with price greater than its !!! ");
                            	
                            }
                            System.out.println("If you have finished write 0\nTo continue adding discounts write 1");
                            int Break=in.nextInt();
                            if (Break==0){
                                break;
                            }else if (Break==1){
                                continue;
                            }
                        }
                        }
                        else if(n==2) {
                        	Companies s=null;
                        	while (true) {
                                System.out.println("choose service provider to be discounted");
                                System.out.println("1)Vodafone\n2)Etisalat\n3)We\n4)Orange");
                                String servicePro = in.next();
                                Companies c=null;
                                if (servicePro.equalsIgnoreCase("Vodafone")) {
                                        s=vodafone.getInstance();
                                } else if (servicePro.equalsIgnoreCase("Etisalat")) {
                                        s=etisalat.getInstance();
                                } else if (servicePro.equalsIgnoreCase("We")) {
                                        s=we.getInstance();
                                } else if (servicePro.equalsIgnoreCase("Orange")) {
                                        s=orange.getInstance();
                                }
                                d1.removeDiscount(s);
                        }
                        

                    }
                }
                    else if(DiscountNum==2) {
                    	d1=OverallDiscount.getInstance();
                    	System.out.println("U we add a discount for all mobile and internet Services "
                    			+ "to Approve write 1"
                    			+ "to remove Overall discounts write 2 ");
                    	int app=in.nextInt();
                    	if(app==1) {
                    		for(Companies c: servss) {
                    		d1.addCompanyList(c);	
                    		}
                    		System.out.println("Please enter Discount you want to add ");
                    		int value= in.nextInt();
                            if(value>=0 || value<=100) {
                            double discountPrice=(value/100.0);
                            d1.addDiscountToComp(discountPrice);
                            admin.postMessage("Discount has been added for you!"+ value+"%");
                            }
                            else
                            {
                            	System.out.println("This Offer is not available you can not buy Items for free \n"
                            			+ "Or with price greater than its !!! ");
                            	
                            }
                    	}
                    	else if(app==2) {
                    		System.out.println("Remove all mobile and internet Services from discount ");
                    		for(Companies c: servss) {
                        		d1.removeDiscount(c);	
                        		}
                    	}
                    }
                    
                }

            }else if (startnum == 2) {
                System.out.println("If you are a new customer please register by writing number 1 \n if you want to login please write 2");
                int numS = in.nextInt();
                if (numS == 1) {
                    count++;
                    x[count] = new User();
                    x[count].signUp();
                    System.out.println("Registering completed successfully please login");
                    System.out.println("Enter email:");
                    String email;
                    email = in.next();
                    System.out.println("Enter Password:");
                    String Password;
                    Password = in.next();
                    boolean flag = false;
                    for (int i = 0; i <= count; i++) {
                        if (x[i].logIn(email, Password)) {
                            flag = true;
                            System.out.println("login Successfully!");
                            customer=x[i];
                            System.out.println("Welcome "+customer.getName()+" in Edfa3ly services\n");
                            break;
                        }
                    }
                    while(!flag) {
                        System.out.println("Email or Password is wrong please enter your info correct\n"+
                                "If you are not registered before please write new\nIf you remembered your info write old");
                        String check=in.next();
                        if (check.equalsIgnoreCase("new")){
                            x[count]=new User();
                            x[count].signUp();
                            customer=x[count];
                        }else if(check.equalsIgnoreCase("old"))
                        {
                            System.out.println("Enter email:");
                            email = in.next();
                            System.out.println("Enter Password:");
                            Password = in.next();
                            flag = false;
                            for (int i = 0; i <= count; i++) {
                                if (x[i].logIn(email, Password)) {
                                    flag = true;
                                    System.out.println("login Successfully!");
                                    customer=x[i];
                                    System.out.println("Welcome "+customer.getName()+" in Edfa3ly services\n");
                                    break;
                                }
                            }
                        }

                    }
                } else if (numS == 2) {
                    System.out.println("Enter email:");
                    String email;
                    email = in.next();
                    System.out.println("Enter Password:");
                    String Password;
                    Password = in.next();
                    boolean flag = false;
                    for (int i = 0; i <= count; i++) {
                        if (x[i].logIn(email, Password)) {
                            flag = true;
                            System.out.println("login Successfully!");
                            customer=x[i];
                            System.out.println("Welcome "+customer.getName()+" in Edfa3ly services\n");
                            break;
                        }
                    }
                    while (!flag) {
                        System.out.println("Email or Password is wrong please enter your info correct\n"+
                                "If you are not registered before please write new\nIf you remembered your info write old");
                        String check=in.next();
                        if (check.equalsIgnoreCase("new")){
                            x[count]=new User();
                            x[count].signUp();
                            customer=x[count];
                        }else if(check.equalsIgnoreCase("old")){
                            System.out.println("Enter email:");
                            email = in.next();
                            System.out.println("Enter Password:");
                            Password = in.next();
                            flag = false;
                            for (int i = 0; i <= count; i++) {
                                if (x[i].logIn(email, Password)) {
                                    flag = true;
                                    System.out.println("login Successfully!");
                                    customer=x[i];
                                    System.out.println("Welcome "+customer.getName()+" in Edfa3ly services\n");

                                    break;
                                }
                            }
                        }
                    }
                }
                customer.setSubject(admin);
                int servNumber=0;
                while(servNumber!=7){
                    System.out.println("Fawry Services:please enter the number corresponding to every service: \n"+
                            "1) My Wallet \n" +"2) Internet payment or Recharge Mobile \n"+
                            "3) Landline payment \n4) Donations\n5)Make Refund\n6) Check Updates\n7) Log Out");
                    servNumber=in.nextInt();
                    String Credit;
                    int money;
                    String service="";
                    if (servNumber==1){
                    	System.out.println("write the number corresponding to each feature\n1) Wallet balance\n2) Add money to wallet");
                        int wallCheck=in.nextInt();
                        if(wallCheck==1) {
                        	System.out.println("Wallet Balance= "+customer.getWallet());
                        }else if(wallCheck==2) {
                        	System.out.println("enter credit card number:");
                            Credit=in.next();
                            System.out.println("enter amount of payment:");
                            money=in.nextInt();
                            customer.addToWallet(money,Credit);
                            System.out.println("Transcation finished successfully!! thank you!\nWallet Balance= "+customer.getWallet());	
                        }
                    }else if (servNumber==2){
                        System.out.println("write service name u want : \nfor internet please write Internet \n" +
                                "for mobile recharge please write Recharge");
                        service=in.next();
                        ServiceFactory obj=new ServiceFactory();
                        Services obj1;
                        obj1=obj.createService(service);
                        obj1.printService();
                        System.out.println("choose number service provider by writing the number corresponding: \n"+
                                " 1) Vodafone\n2) We\n3) Etisalat\n4) Orange");
                        int prov=in.nextInt();
                        Companies comp=null;
                        if (prov==1){
                            comp=vodafone.getInstance();
                        }else if (prov==2){
                            comp=we.getInstance();
                        }else if (prov==3){
                            comp=etisalat.getInstance();
                        }else if (prov==4){
                            comp=orange.getInstance();
                        }else System.out.println("Error");
                        obj1.SetCompanies(comp);
                        obj1.getDescription();
                        System.out.println("Way of payment:");
                        System.out.println("1) wallet \n 2)credit card \n 3)Cash");
                        int p=in.nextInt();
                        System.out.println("amount of payment:"+obj1.cost());
                        if (customer.setPayment(p,obj1.cost())){
                            customer.setTransactions(service,obj1.cost());
                            System.out.println("Wallet Balance= "+customer.getWallet());
                            comp.printTransaction();
                            System.out.println("Transcation finished successfully!! thank you!");
                        }else
                        	System.out.println("Transaction failed!");
                        

                    } else if (servNumber==3) {
                    	Duration duration;
                        Reciepts reciept;
                        Reciept_factory fac = new Reciept_factory();
                        reciept = fac.creatReciept("Landline");
                    	System.out.println("Enter number coressponding to each duration: \n 1)quarter receipt \n 2)monthly receipt");
                    	int durNum = in.nextInt();
                        if(durNum==1)
                        {
                            duration = new quarter();
                            reciept.SetDuration(duration);
                        }
                        else if (durNum==2)
                        {
                        	duration = new Month();
                            reciept.SetDuration(duration);
                        }
                        else
                        {
                            System.out.println("the duration maybe wrong or something dosn't exist now!! ");
                            System.out.println("please Enter correct duration form(m for monthly or q for quarter)");
                        }
                        
                        System.out.println("Way of payment:");
                        System.out.println("1) wallet \n 2)credit card \n 3)Cash");
                        int p=in.nextInt();
                        System.out.println("amount of payment:"+reciept.CalBills());
                        if (customer.setPayment(p,reciept.CalBills())){
                            customer.setTransactions(service,reciept.CalBills());
                            System.out.println("Wallet Balance= "+customer.getWallet());
                            System.out.println("Transcation finished successfully!! thank you!");
                        }else
                        	System.out.println("Transaction failed!");
                        
                        

                    } else if (servNumber==4) {
                        GetDonationFactory obj1=new GetDonationFactory();
                        System.out.println("Enter Orgnization type Number :\n1)Schools\n2)Cancer Hospitals\n3)NGOs");
                        int OrgNumber=in.nextInt();
                        String name="";
                        Organizations B=null;
                        if (OrgNumber==1){
                            name="Schools";
                            OrganizationsFactory A=obj1.getType(name);
                            System.out.println("Write the name of the school");
                            System.out.println("1)SchoolA");
                            String schoolName=in.next();
                            B=A.getOrganization(schoolName);
                            
                        }else if (OrgNumber==2){
                            name="Cancer Hospitals";
                            OrganizationsFactory A=obj1.getType(name);
                            System.out.println("Write the name of the Hospital");
                            System.out.println("1)CancerhospitalA");
                            String hospitalName=in.next();
                            B=A.getOrganization(hospitalName);
                     
                        }
                        else if (OrgNumber==3){
                            name="NGOs";
                            OrganizationsFactory A=obj1.getType(name);
                            System.out.println("Write the name of the NGO");
                            System.out.println("1)NGOA");
                            String ngoName =in.next();
                           B=A.getOrganization(ngoName);
     
                        }
                        if(B==null) {
                        	System.out.println("U have entered name of Organization incorrctly");
                        }
                        else {
                        B.Print();
                        System.out.println("Way of payment:");
                        System.out.println("1) wallet \n 2)credit card \n 3)Cash");
                        int p=in.nextInt();
                        System.out.println("amount of payment:"+B.cost());
                        if (customer.setPayment(p,B.cost())){
                            customer.setTransactions(service,B.cost());
                            System.out.println("Wallet Balance= "+customer.getWallet());
                            System.out.println("Transcation finished successfully!! thank you!");
                        }else
                        	System.out.println("Transaction failed!");
  
                        }
                        
                        
                        
                    }else if(servNumber==5){
                        customer.makeRefund();
                    } else if (servNumber==6) {
                        customer.showUpdates();
                    }


                }

            } else if(startnum ==3){
                break;
            }

        }

    }
    

}


