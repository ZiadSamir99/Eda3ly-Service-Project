package com.efa3lyservices.edfa3lysevices.Entity;

import com.efa3lyservices.edfa3lysevices.models.User;

public interface Subject {
//    public void register(CustomerBsl obs);
//    public void unregister(CustomerBsl obs);
    public void notifyObservers();
//    public Object getUpdate(CustomerBsl obs);
    public void addusertorefund(User u);

    void ListallRefunds();
}
