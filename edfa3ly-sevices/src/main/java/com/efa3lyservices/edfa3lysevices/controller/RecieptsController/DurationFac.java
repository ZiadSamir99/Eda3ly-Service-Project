package com.efa3lyservices.edfa3lysevices.controller.RecieptsController;

import com.efa3lyservices.edfa3lysevices.Entity.Duration;
import com.efa3lyservices.edfa3lysevices.controllerBsl.DurationsBsl.Month;
import com.efa3lyservices.edfa3lysevices.controllerBsl.DurationsBsl.quarter;
import org.springframework.stereotype.Service;

@Service
public class DurationFac {
    public Duration getDur(String duration){
        if(duration.equalsIgnoreCase("Quarter"))
            return new quarter();
        if (duration.equalsIgnoreCase("Monthly"))
            return new Month();
        return null;
    }
}
