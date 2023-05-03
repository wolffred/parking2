package org.example.vehicles;

import org.example.Owner;

import java.util.List;

public class PrivateCar extends Vehicle{


    public PrivateCar(String numberPlate, List<Owner> owners, double amountChargedPerMonth){
        super(numberPlate, owners, amountChargedPerMonth);
        setType(VehicleType.PRIVATECAR);
    }




    @Override
    public double calculateCharge() {
        return this.getAmountChargedPerMonth();
    }
}
