package org.example.vehicles;

import org.example.Owner;

import java.util.List;

public abstract class Vehicle {
    private String numberPlate;
    private List<Owner> owners;
    private double amountChargedPerMonth;
    private int permitNumber = 0;

    private VehicleType type;


    public Vehicle(String numberPlate, List<Owner> owners, double amountChargedPerMonth){
        this.numberPlate = numberPlate;
        this.amountChargedPerMonth = amountChargedPerMonth;
        this.owners = owners;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

//    public String getNumberPlate() {
//        return numberPlate;
//    }

//    public void setNumberPlate(String numberPlate) {
//        this.numberPlate = numberPlate;
//    }

    public List<Owner> getOwners() {
        return owners;
    }

//    public void addOwner(Owner owner) {
//        this.owners.add(owner);
//    }

    public double getAmountChargedPerMonth() {
        return amountChargedPerMonth;
    }

    public void setAmountChargedPerMonth(double amountChargedPerMonth) {
        this.amountChargedPerMonth = amountChargedPerMonth;
    }

    public int getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(int permitNumber) {
        this.permitNumber = permitNumber;
    }

    public abstract double calculateCharge();
}
