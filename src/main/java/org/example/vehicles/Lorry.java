package org.example.vehicles;

import org.example.Main;
import org.example.Owner;

import java.util.List;

public class Lorry extends Vehicle{

    private int capacity;
    private double extraCharge;
    private final int maxCapacity = 150;
    private final int capacityDivision = 20;
    private double finalCharge;
    float newCapacity;
    float extraChargeCapacity;

    public Lorry(String numberPlate, List<Owner> owners, double amountChargedPerMonth, int capacity) {
        super(numberPlate, owners, amountChargedPerMonth);
        this.capacity = capacity;
        setType(VehicleType.LORRY);
    }


//    public Lorry(String numberPlate, List<Owner> owners, double amountChargedPerMonth, int capacity, Pr){
//        super(numberPlate, owners, amountChargedPerMonth);
//        this.capacity = capacity;
//        this.type = VehicleType.LORRY;
//    }


//    public double getExtraCharge() {
//        return extraCharge;
//    }
//
//    public void setExtraCharge(double extraCharge) {
//        this.extraCharge = extraCharge;
//    }

    @Override
    public double calculateCharge() {
        if(capacity > maxCapacity){
            newCapacity = capacity - maxCapacity;
            extraChargeCapacity = newCapacity / capacityDivision;
            extraChargeCapacity = Math.round(extraChargeCapacity);
            extraCharge = extraChargeCapacity * 5;
            setFinalCharge(extraCharge + getAmountChargedPerMonth());
        } else {
            setFinalCharge(getAmountChargedPerMonth());
        }
        return getFinalCharge();
    }


    public double getFinalCharge() {
        return finalCharge;
    }

    public void setFinalCharge(double finalCharge) {
        this.finalCharge = finalCharge;
    }
}
