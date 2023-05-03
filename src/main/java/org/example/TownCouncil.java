package org.example;


import org.example.authorisationandpermit.PermitIssuerService;
import org.example.authorisationandpermit.VerificationService;
import org.example.vehicles.Vehicle;
import org.example.vehicles.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TownCouncil {
    private int permitNumber = 0;
    private Map<Vehicle, Integer> vehicleWithPermit = new HashMap<>();
    private Map<VehicleType, List<Vehicle>> vehicleTypeWithNumberOfVehicles = new HashMap<>();

    private List<Vehicle> listOfVehicles = new ArrayList<>();
    private Map<Vehicle , List<Owner>> vehicleWithOwners = new HashMap<>();
    PermitIssuerService permitIssuerService;
    VerificationService verificationService;

    public TownCouncil(VerificationService verificationService, PermitIssuerService permitIssuerService) {
        this.permitIssuerService = permitIssuerService;
        this.verificationService = verificationService;
    }

    public boolean verifyRequester(Owner owner, Vehicle vehicle){
        return vehicle.getOwners().contains(owner);
    }

    public void issuePermit (Owner owner,Vehicle vehicle) {

        if(verificationService.verifyPerson(owner, vehicle)){
            if (!permitIssuerService.issuePermit(vehicle).isEmpty()){
                if (vehicle.getPermitNumber() == 0){
                    if (vehicle.getType() != VehicleType.LORRY){
                        if(verifyRequester(owner,vehicle)){
                            permitNumber++;
                            vehicle.setPermitNumber(permitNumber);
                            vehicleWithPermit.put(vehicle, permitNumber);
                            listOfVehicles.add(vehicle);

                            vehicleTypeWithNumberOfVehicles.put(vehicle.getType(), listOfVehicles);
                        }
                    }else{
                        permitNumber++;
                        vehicle.setPermitNumber(permitNumber);
                        vehicleWithPermit.put(vehicle, permitNumber);
                        listOfVehicles.add(vehicle);

                        vehicleTypeWithNumberOfVehicles.put(vehicle.getType(), listOfVehicles);
                    }
                }
            }
        }

    }


    public boolean hasPermit(Vehicle vehicle) {
        return vehicleWithPermit.containsKey(vehicle);
    }

    public boolean hasType(VehicleType vehicleType) {
        return vehicleTypeWithNumberOfVehicles.containsKey(vehicleType);
    }

    public int sizeOfMap(){
        return vehicleWithPermit.size();
    }

    public int getSizeOfVehicleType(){
        int t = 0;
        for (VehicleType vehicleType: vehicleTypeWithNumberOfVehicles.keySet()) {
            t = vehicleTypeWithNumberOfVehicles.get(vehicleType).size();
        }
        return  t;
    }































//    List<Vehicle> listOfPrivateCars = new ArrayList<>();
//    List<Vehicle> listOfLorries = new ArrayList<>();
//
//    List<Vehicle> listOfMotorBikes = new ArrayList<>();
//    List<Vehicle> listOfVehicles = new ArrayList<>();
//    Map<Vehicle , List<Owner>> vehicleWithOwners = new HashMap<>();





//    public void registerOwner(Owner owner, Vehicle vehicle){
//        vehicle.addOwner(owner);
//        vehicleWithOwners.put(vehicle, vehicle.getOwners());
//    }


//    public boolean verifyRequester(Owner owner){
//        return owner.isRegistered();
//    }




//    public void issuePermit(Owner owner, Vehicle vehicle){
//        owner.setRegistered(true);
//        owner.setRegistered(true);
//        if(vehicle instanceof PrivateCar){
//            vehicle.setAmountChargedPerMonth(20);
//        } else if (vehicle instanceof Lorry) {
//
//        }
//    }


}
