package com.efa3lyservices.edfa3lysevices.controller.AdminController;

import com.efa3lyservices.edfa3lysevices.Entity.Companies;
import com.efa3lyservices.edfa3lysevices.controller.ServiceController.CompanyFactoryController;
import com.efa3lyservices.edfa3lysevices.controllerBsl.AdminBsl.AdminBsl;
import com.efa3lyservices.edfa3lysevices.controllerBsl.CompaniesBsl.etisalat;
import com.efa3lyservices.edfa3lysevices.controllerBsl.CompaniesBsl.orange;
import com.efa3lyservices.edfa3lysevices.controllerBsl.CompaniesBsl.vodafone;
import com.efa3lyservices.edfa3lysevices.controllerBsl.CompaniesBsl.we;
import com.efa3lyservices.edfa3lysevices.models.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {
    AdminBsl admin;
    List<Companies> Comp ;
    CompanyFactoryController compFC;
    public AdminController(){
        admin=new AdminBsl();
        compFC=new CompanyFactoryController();
        Comp=new ArrayList<Companies>();
        Comp.add(vodafone.getInstance());
        Comp.add(etisalat.getInstance());
        Comp.add(orange.getInstance());
        Comp.add(we.getInstance());
    }

    @GetMapping(value = "/admin/listRequests")
    public List<Transaction> getAllRefunds(){
        return this.admin.getRefundRequests();
    }
    @PutMapping(value = "/admin/acceptRequest/{index}")
    public String acceptRequest(@PathVariable("index") int index,@RequestBody Object accept){

        return this.admin.chooseRefundtoReturn(index-1,accept);
    }
    @PutMapping(value = "/admin/addoffers/{ServiceName}")
    public String addOffer(@PathVariable("ServiceName") String compName,@RequestBody int offer){
        double offerr=offer/100.0;
        Companies temp = compFC.create(compName);
        temp.addDiscount(offerr);
        return "Offer added successfully :))";
    }
    @PutMapping(value = "/admin/addoffersToallServices")
    public String addOffertoallServices(@RequestBody int offer){

        for (Companies obj : Comp)
        {
            obj.addDiscount(offer/100.0);
        }
        return "Offers added successfully to all Companies :))";
    }
    @PutMapping(value = "/admin/RemoveOffersfromAllServices")
    public String RemoveallOfferfromServices(){

        for (Companies obj : Comp)
        {
            obj.addDiscount(0.0);
        }
        return "Offers are Removed successfully from all Companies :((";
    }
    @GetMapping(value="/admin/ShowUserTransactions/{id}")
    public List<Transaction> showUserTransactions(@PathVariable("id") int id){
        return this.admin.showUserTransactions(id);
    }
}
