package com.efa3lyservices.edfa3lysevices.controllerBsl.ServiceBsl;

import com.efa3lyservices.edfa3lysevices.Entity.Companies;
import com.efa3lyservices.edfa3lysevices.Entity.Services;
import org.springframework.stereotype.Service;

@Service
public class MobileRechargeBsl extends Services {


   Companies company;
//   public static MobileRechargeBsl object;
//   private MobileRechargeBsl(){};
//   public static MobileRechargeBsl getInstance(){
//       if (object==null){
//           object = new MobileRechargeBsl();
//       }
//       return object;
//   }

    public MobileRechargeBsl(){
        printService();
    }
    public String printService(){
        return "Mobile Recharge Service";
    }
    @Override
    public void SetCompanies(Companies company) {
        this.company=company;
    }

    @Override
    public double cost(double money) {
        return this.company.calcBills(money);
    }


}
