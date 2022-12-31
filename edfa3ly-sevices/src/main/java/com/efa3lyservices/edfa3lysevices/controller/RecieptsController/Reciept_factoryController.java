package com.efa3lyservices.edfa3lysevices.controller.RecieptsController;
import com.efa3lyservices.edfa3lysevices.Entity.Reciepts;
import com.efa3lyservices.edfa3lysevices.controllerBsl.RecieptsBsl.Landline;
import org.springframework.stereotype.Service;

@Service
public class Reciept_factoryController {
    public Reciepts creatReciept(String reciept ,String number)
    {
        if(reciept.equalsIgnoreCase("Landline"))
        {
            return Landline.getInstance(number);
        }
        return null;
    }

}
