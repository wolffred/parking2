package org.example.vehicles;

import org.example.Owner;

import java.util.List;

public class MotorBike extends Vehicle{
    private int capacity;
    private final int scooterCapacity = 850;
    private double finalCharge;

    public MotorBike(String numberPlate, List<Owner> owners, double amountChargedPerMonth, int capacity) {
        super(numberPlate, owners, amountChargedPerMonth);
        this.capacity = capacity;
        setType(VehicleType.MOTORBIKE);
    }

    @Override
    public double calculateCharge() {
        if(capacity <= scooterCapacity && capacity > 0){
            return getAmountChargedPerMonth();
        }
        else {
            setAmountChargedPerMonth(10);
            return getAmountChargedPerMonth();
        }
    }
}