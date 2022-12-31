package com.efa3lyservices.edfa3lysevices.Entity;

import com.efa3lyservices.edfa3lysevices.models.User;

public interface Payment {
    public String pay(User u,double money,String Destination);
}
