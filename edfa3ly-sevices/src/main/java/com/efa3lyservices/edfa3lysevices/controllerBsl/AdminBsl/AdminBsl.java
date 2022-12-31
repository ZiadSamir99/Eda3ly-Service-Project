package com.efa3lyservices.edfa3lysevices.controllerBsl.AdminBsl;

import com.efa3lyservices.edfa3lysevices.controllerBsl.UserBsl.CustomerBsl;
import com.efa3lyservices.edfa3lysevices.models.Transaction;
import com.efa3lyservices.edfa3lysevices.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AdminBsl {
    CustomerBsl customer=new CustomerBsl();
    public List<Transaction> getRefundRequests(){
       return   this.customer.getAllrefunds();
    }

    public String chooseRefundtoReturn(int idx,Object acceptance){
        User e;
        List<Transaction> ref =this.customer.getAllrefunds();
        Transaction temp=ref.get(idx);
        e=this.customer.getUser(temp.getId());
        if (acceptance.equals("accept") && e.getTransactionByInd(idx).getPaymentMethod().equalsIgnoreCase("wallet")){
            e.setWallet(e.getWallet()+ temp.getMoney());
            this.customer.removeRequest(idx,e);
            this.customer.removeTransaction(idx,e);
            return this.customer.notify("Your refund request is accepted successfully!" +temp.getServiceName()+" "+temp.getMoney(),e);

        }else if(acceptance.equals("accept") && e.getTransactionByInd(idx).getPaymentMethod().equalsIgnoreCase("creditcard")){
            this.customer.removeRequest(idx,e);
            this.customer.removeRefundReq(idx);
            return this.customer.notify("Your refund request is accepted successfully!" +temp.getServiceName()+" "+temp.getMoney(),e);

        }
        else if (acceptance.equals("reject")){
            return this.customer.notify("Your refund request has been rejected",e);

        }
        return "done";
    }
    public List<Transaction> showUserTransactions(int id){
        User user=this.customer.getUser(id);
        return user.getTransactions();
    }

}
