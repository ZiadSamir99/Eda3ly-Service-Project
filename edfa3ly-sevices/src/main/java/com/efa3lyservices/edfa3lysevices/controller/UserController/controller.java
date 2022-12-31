package com.efa3lyservices.edfa3lysevices.controller.UserController;

import com.efa3lyservices.edfa3lysevices.controllerBsl.UserBsl.CustomerBsl;
import com.efa3lyservices.edfa3lysevices.models.Transaction;
import com.efa3lyservices.edfa3lysevices.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

    CustomerBsl customer;
    public controller(CustomerBsl c){
        customer=c;
    }
    @PostMapping(value = "/user/register")
    public String add(@RequestBody User customer){
        return this.customer.registerUser(customer);
    }
    @GetMapping(value = "/user/showUserData/{id}")
    public User getUser(@PathVariable("id") int id){
        return this.customer.getUser(id);
    }




    @PutMapping(value = "/user/addMoneyToWallet/{money}/{id}")
    public String addMoneyToWallet( @PathVariable("money") double money, @PathVariable("id") int id){
         User user= this.customer.getUser(id);
        return this.customer.addMoneyToWallet(user,money,id);

    }

    @PostMapping(value = "/user/login")
    public String login( @RequestBody User user){
        return this.customer.Login(user);
    }

    @PostMapping (value = "/user/requestRefund/{index}")
    public String addRefund(@RequestBody User user,@PathVariable("index") int index ){

        return this.customer.addRefundRequest(user,index-1);
    }
    @GetMapping(value = "/user/requestList/{id}")
    public List<Transaction> getRequest(@PathVariable("id")int id){
        return this.customer.getRefundRequests(id);
    }
    @GetMapping(value = "user/ShowUpdates/{id}")
    public List<String> showAlluserUpdates(@PathVariable("id")int id){
        return this.customer.getUser(id).showUpdates();
    }

}
