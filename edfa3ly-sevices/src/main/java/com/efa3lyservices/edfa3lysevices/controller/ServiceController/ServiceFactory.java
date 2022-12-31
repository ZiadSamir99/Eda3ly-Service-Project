package com.efa3lyservices.edfa3lysevices.controller.ServiceController;
import com.efa3lyservices.edfa3lysevices.Entity.Services;
import com.efa3lyservices.edfa3lysevices.controllerBsl.ServiceBsl.InternetBsl;
import com.efa3lyservices.edfa3lysevices.controllerBsl.ServiceBsl.MobileRechargeBsl;
import org.springframework.stereotype.Service;

@Service
public class ServiceFactory {
    Services services;

    public Services createService(String Service)
    {
        if (Service.equalsIgnoreCase("recharge")) {
            return new MobileRechargeBsl();
        }else if(Service.equalsIgnoreCase("Internet")) {
            return new InternetBsl();
        }
        return null;
    }


}

