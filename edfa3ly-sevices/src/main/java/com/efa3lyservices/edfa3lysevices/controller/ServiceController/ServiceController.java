package com.efa3lyservices.edfa3lysevices.controller.ServiceController;

import com.efa3lyservices.edfa3lysevices.Entity.*;
import com.efa3lyservices.edfa3lysevices.controller.DonationsController.GetDonationFactory;
import com.efa3lyservices.edfa3lysevices.controller.RecieptsController.DurationFac;
import com.efa3lyservices.edfa3lysevices.controller.RecieptsController.Reciept_factoryController;
import com.efa3lyservices.edfa3lysevices.controllerBsl.PaymentBsl.CreditCard;
import com.efa3lyservices.edfa3lysevices.controllerBsl.PaymentBsl.Wallet;
import com.efa3lyservices.edfa3lysevices.controllerBsl.UserBsl.CustomerBsl;
import com.efa3lyservices.edfa3lysevices.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ServiceController {
    ServiceFactory service = new ServiceFactory();
    Reciept_factoryController r=new Reciept_factoryController();


    CustomerBsl customer;
    GetDonationFactory DF=new GetDonationFactory();
    public ServiceController(CustomerBsl c){
        customer=c;
    }

    @GetMapping(value = "/user/services/mobile/{Service}/{id}/{phoneNum}/{servProvider}/{PayMethod}/{money}")
    public String createService(@PathVariable("Service") String Service,@PathVariable("servProvider") String Compname
    ,@PathVariable("id") int id,@PathVariable("PayMethod") String paymethod,@PathVariable("money") double money,
                                @PathVariable("phoneNum") String phoneNum )
    {

       User user =this.customer.getUser(id);
        Services s=this.service.createService(Service);
        Companies c =new CompanyFactoryController().create(Compname);
        s.SetCompanies(c);
        Payment p;
        if(paymethod.equalsIgnoreCase("CreditCard"))
            p=new CreditCard();
        else
            p=new Wallet();
        double val=c.calcBills(money);
        String ss=c.printTransaction();
        String  x=p.pay(user,val,phoneNum);
        if(x.substring(0,1).equalsIgnoreCase("1")){
            return x+" "+this.customer.addTransaction(Service,val,id,paymethod)+" "+ss;
        }else return x;
    }
    @GetMapping (value ="/user/donations/{schools}/{schoola}/{money}/{id}/{payMethod}")
    public String addDonations(@PathVariable("schools") String DonationF,@PathVariable("schoola")String ServiceN,@PathVariable("money")double money
        ,@PathVariable("id") int id,@PathVariable("payMethod") String payMethod){
        User user=this.customer.getUser(id);
        OrganizationsFactory Of= this.DF.getType(DonationF);
        Organizations org =Of.getOrganization(ServiceN);
        Payment p;
        if(payMethod.equalsIgnoreCase("CreditCard"))
            p=new CreditCard();
        else
            p=new Wallet();
        String x=p.pay(user,money,org.getname());

        if(x.substring(0,1).equalsIgnoreCase("1")){
            return x+" "+this.customer.addTransaction(DonationF,money,id,payMethod)+" "+org.AddDonation(money);
        }else return x;
    }
    @GetMapping(value = "/user/Receipts/{landline}/{phone}/{duration}/{money}/{id}/{payMethod}")
    public String getRiecpt(@PathVariable("landline") String landline,@PathVariable("phone") String phone,
                            @PathVariable("duration") String duration,@PathVariable("money") double money,
                            @PathVariable("id")int id,@PathVariable("payMethod")String payMethod ){
        User user=this.customer.getUser(id);

        Reciepts R=this.r.creatReciept(landline,phone);
        Duration d=new DurationFac().getDur(duration);
        Payment p;
        R.SetDuration(d);
        if(payMethod.equalsIgnoreCase("CreditCard"))
            p=new CreditCard();
        else
            p=new Wallet();
        String x=p.pay(user,money,phone);

        if(x.substring(0,1).equalsIgnoreCase("1")){
            return x+" "+this.customer.addTransaction(landline,money,id,payMethod)+"\nService Duration: "+d.getDescritpion();
        }else return x;
    }
}
