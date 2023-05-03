package org.example;

import org.example.authorisationandpermit.PermitIssuerService;
import org.example.authorisationandpermit.VerificationService;
import org.example.vehicles.Lorry;
import org.example.vehicles.MotorBike;
import org.example.vehicles.PrivateCar;
import org.example.vehicles.VehicleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class TownCouncilTest {

    PermitIssuerService permitIssuerService;
    VerificationService verificationService;


    @BeforeEach
    void setUp() {
        permitIssuerService = mock(PermitIssuerService.class);
        verificationService = mock(VerificationService.class);

    }

    @Test
    public void whenVerificationServiceisSuccessfulForMotorBike(){

        Owner owner = new Owner("ID1");
        List<Owner> owners = List.of(owner);

        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
        TownCouncil townCouncil = new TownCouncil(verificationService, permitIssuerService);

        when(verificationService.verifyPerson(owner, motorBike)).thenReturn(true);
        when(permitIssuerService.issuePermit(motorBike)).thenReturn("1");

        townCouncil.issuePermit(owner, motorBike);

        verify(verificationService, atLeast(1)).verifyPerson(owner, motorBike);
        verify(permitIssuerService, atLeast(1)).issuePermit(motorBike);

        assertEquals(motorBike.getPermitNumber(), 1);
    }


    @Test
    public void whenVerificationServiceFailsForPrivateCar() {

        Owner owner = new Owner("ID1");
        List<Owner> owners = List.of(owner);

        PrivateCar privateCar = new PrivateCar("number1", owners, 20);
        TownCouncil townCouncil = new TownCouncil(verificationService, permitIssuerService);

        when(verificationService.verifyPerson(owner, privateCar)).thenReturn(false);
        when(permitIssuerService.issuePermit(privateCar)).thenReturn("1");

        townCouncil.issuePermit(owner, privateCar);
        verify(verificationService, atLeast(1)).verifyPerson(owner, privateCar);
        assertEquals(privateCar.getPermitNumber(), 0);

    }


    @Test
    public void whenVerificationServiceIsSuccessfulForLorry() {

        Owner owner = new Owner("ID1");
        List<Owner> owners = List.of(owner);

        Lorry lorry = new Lorry("number1", owners, 30,  180);
        TownCouncil townCouncil = new TownCouncil(verificationService, permitIssuerService);

        when(verificationService.verifyPerson(owner, lorry)).thenReturn(true);
        when(permitIssuerService.issuePermit(lorry)).thenReturn("1");

        townCouncil.issuePermit(owner, lorry);
        verify(verificationService, atLeast(1)).verifyPerson(owner, lorry);
        assertEquals(lorry.getPermitNumber(), 1);

    }

    @Test
    public void whenVerificationServiceFailsForLorry() {

        Owner owner = new Owner("ID1");
        List<Owner> owners = List.of(owner);

        Lorry lorry = new Lorry("number1", owners, 30,  180);
        TownCouncil townCouncil = new TownCouncil(verificationService, permitIssuerService);

        when(verificationService.verifyPerson(owner, lorry)).thenReturn(false);

        townCouncil.issuePermit(owner, lorry);

        verify(verificationService, atLeast(1)).verifyPerson(owner, lorry);
        assertEquals(lorry.getPermitNumber(), 0);

    }




















}

//    @Test
//    public void verifyRequester(){
//        Owner owner = new Owner("ID1");
//
//        List<Owner> owners = List.of(owner);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//
//        when(verificationService.verifyPerson())
//        when(permitIssuerService.issuePermit())
//
//        //assertTrue(townCouncil.verifyRequester(owner, motorBike));
//    }

//    @Test
//    public void verifyRequesterReturnsFalse(){
//        Owner owner = new Owner("ID1");
//
//        Owner owner2 = new Owner("ID2");
//
//        List<Owner> owners = List.of(owner);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//
//        assertFalse(townCouncil.verifyRequester(owner2, motorBike));
//    }
//
//    @Test
//    public void shouldSuccessfullyIssuePermitWithOneOwner(){
//
//        Owner owner = new Owner("ID1");
//
//        List<Owner> owners = List.of(owner);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//
//        townCouncil.issuePermit(new Owner("ID1"), motorBike);
//        assertTrue(townCouncil.hasPermit(motorBike));
//
//    }
//
//
//    @Test
//    public void shouldFailIssuePermitWhenListOfOwnersIsEmpty(){
//
//        Owner owner = new Owner("ID1");
//
//        List<Owner> owners = List.of();
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//
//        townCouncil.issuePermit(new Owner("ID1"), motorBike);
//        assertFalse(townCouncil.hasPermit(motorBike));
//
//    }
//
//    @Test
//    public void shouldIssuePermitWhenThereAreMultipleOwners(){
//
//        Owner owner1 = new Owner("ID1");
//        Owner owner2 = new Owner("ID2");
//
//        List<Owner> owners = List.of(owner1, owner2);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//
//        townCouncil.issuePermit(owner2, motorBike);
//        assertTrue(townCouncil.hasPermit(motorBike));
//
//    }
//
//    @Test
//    public void shouldFailIfVehicleAlreadyHasPermit(){
//
//
//        Owner owner = new Owner("ID1");
//
//        List<Owner> owners = List.of(owner);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//        motorBike.setPermitNumber(4);
//        townCouncil.issuePermit(new Owner("ID1"), motorBike);
//
//        assertFalse(townCouncil.hasPermit(motorBike));
//        //assertFalse(townCouncil.issuePermit(new Owner("ID1"), motorBike));
//    }
//
//    @Test
//    public void shouldUpdateMap(){
//
//        Owner owner = new Owner("ID1");
//        List<Owner> owners = List.of(owner);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//        townCouncil.issuePermit(new Owner("ID1"), motorBike);
//
//        assertEquals(townCouncil.sizeOfMap(), 1);
//
//    }
//
//
//    @Test
//    public void shouldCheckVehicleType(){
//
//        Owner owner = new Owner("ID1");
//        List<Owner> owners = List.of(owner);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//        townCouncil.issuePermit(new Owner("ID1"), motorBike);
//
//        assertTrue(townCouncil.hasType(VehicleType.MOTORBIKE));
//
//    }
//
//
//    @Test
//    public void shouldCheckTheTotalNumberOfVehiclesOfAType(){
//
//        Owner owner1 = new Owner("ID1");
//        List<Owner> owners1 = List.of(owner1);
//
//        Owner owner2 = new Owner("ID2");
//        List<Owner> owners2 = List.of(owner2);
//
//        Owner owner3 = new Owner("ID3");
//        List<Owner> owners3 = List.of(owner3);
//
//        Owner owner4 = new Owner("ID4");
//        List<Owner> owners4 = List.of(owner4);
//
//
//        PrivateCar privateCar1 = new PrivateCar("number1", owners1, 20);
//        PrivateCar privateCar2 = new PrivateCar("number2", owners2, 20);
//        PrivateCar privateCar3 = new PrivateCar("number3", owners3, 20);
//        PrivateCar privateCar4 = new PrivateCar("number4", owners4, 20);
//
//
//        TownCouncil townCouncil = new TownCouncil();
//        townCouncil.issuePermit(new Owner("ID1"), privateCar1);
//        townCouncil.issuePermit(owner2, privateCar2);
//        townCouncil.issuePermit(owner3, privateCar3);
//        townCouncil.issuePermit(owner4, privateCar4);
//
//
//        Owner owner5 = new Owner("ID5");
//        List<Owner> owners5 = List.of(owner5);
//
//        MotorBike motorBike1 = new MotorBike("number1", owners5, 7, 500);
//
//        townCouncil.issuePermit(owner5, motorBike1);
//
//
////        for (VehicleType vehicleType: townCouncil.vehicleTypeWithNumberOfVehicles.keySet()) {
////            System.out.println(vehicleType);
////        }
//
//        assertEquals(townCouncil.getSizeOfVehicleType(), 5);








//        MotorBike motorBike1 = new MotorBike("number1", owners1, 7, 500);
//        MotorBike motorBike2 = new MotorBike("number2", owners2, 10, 900);
//        MotorBike motorBike3 = new MotorBike("number3", owners3, 10, 900);


//        Owner owner = new Owner("ID0");
//        List<Owner> owners = List.of(owner);
//
//
//
//        Owner owner11 = new Owner("ID11");
//        List<Owner> owners11 = List.of(owner11);






//}


































































//package org.example;
//
//import org.example.vehicles.MotorBike;
//import org.example.vehicles.PrivateCar;
//import org.example.vehicles.VehicleType;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.anyInt;
//
//class TownCouncilTest {
//
//    @Test
//    public void verifyRequester(){
//        Owner owner = new Owner("ID1");
//
//        List<Owner> owners = List.of(owner);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//
//        assertTrue(townCouncil.verifyRequester(owner, motorBike));
//    }
//
//    @Test
//    public void verifyRequesterReturnsFalse(){
//        Owner owner = new Owner("ID1");
//
//        Owner owner2 = new Owner("ID2");
//
//        List<Owner> owners = List.of(owner);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//
//        assertFalse(townCouncil.verifyRequester(owner2, motorBike));
//    }
//
//    @Test
//    public void shouldSuccessfullyIssuePermitWithOneOwner(){
//
//        Owner owner = new Owner("ID1");
//
//        List<Owner> owners = List.of(owner);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//
//        townCouncil.issuePermit(new Owner("ID1"), motorBike);
//        assertTrue(townCouncil.hasPermit(motorBike));
//
//    }
//
//
//    @Test
//    public void shouldFailIssuePermitWhenListOfOwnersIsEmpty(){
//
//        Owner owner = new Owner("ID1");
//
//        List<Owner> owners = List.of();
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//
//        townCouncil.issuePermit(new Owner("ID1"), motorBike);
//        assertFalse(townCouncil.hasPermit(motorBike));
//
//    }
//
//    @Test
//    public void shouldIssuePermitWhenThereAreMultipleOwners(){
//
//        Owner owner1 = new Owner("ID1");
//        Owner owner2 = new Owner("ID2");
//
//        List<Owner> owners = List.of(owner1, owner2);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//
//        townCouncil.issuePermit(owner2, motorBike);
//        assertTrue(townCouncil.hasPermit(motorBike));
//
//    }
//
//    @Test
//    public void shouldFailIfVehicleAlreadyHasPermit(){
//
//
//        Owner owner = new Owner("ID1");
//
//        List<Owner> owners = List.of(owner);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//        motorBike.setPermitNumber(4);
//        townCouncil.issuePermit(new Owner("ID1"), motorBike);
//
//        assertFalse(townCouncil.hasPermit(motorBike));
//        //assertFalse(townCouncil.issuePermit(new Owner("ID1"), motorBike));
//    }
//
//    @Test
//    public void shouldUpdateMap(){
//
//        Owner owner = new Owner("ID1");
//        List<Owner> owners = List.of(owner);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//        townCouncil.issuePermit(new Owner("ID1"), motorBike);
//
//        assertEquals(townCouncil.sizeOfMap(), 1);
//
//    }
//
//
//    @Test
//    public void shouldCheckVehicleType(){
//
//        Owner owner = new Owner("ID1");
//        List<Owner> owners = List.of(owner);
//
//        MotorBike motorBike = new MotorBike("number1", owners, 7, 500);
//
//        TownCouncil townCouncil = new TownCouncil();
//        townCouncil.issuePermit(new Owner("ID1"), motorBike);
//
//        assertTrue(townCouncil.hasType(VehicleType.MOTORBIKE));
//
//    }
//
//
//    @Test
//    public void shouldCheckTheTotalNumberOfVehiclesOfAType(){
//
//        Owner owner1 = new Owner("ID1");
//        List<Owner> owners1 = List.of(owner1);
//
//        Owner owner2 = new Owner("ID2");
//        List<Owner> owners2 = List.of(owner2);
//
//        Owner owner3 = new Owner("ID3");
//        List<Owner> owners3 = List.of(owner3);
//
//        Owner owner4 = new Owner("ID4");
//        List<Owner> owners4 = List.of(owner4);
//
//
//        PrivateCar privateCar1 = new PrivateCar("number1", owners1, 20);
//        PrivateCar privateCar2 = new PrivateCar("number2", owners2, 20);
//        PrivateCar privateCar3 = new PrivateCar("number3", owners3, 20);
//        PrivateCar privateCar4 = new PrivateCar("number4", owners4, 20);
//
//
//        TownCouncil townCouncil = new TownCouncil();
//        townCouncil.issuePermit(new Owner("ID1"), privateCar1);
//        townCouncil.issuePermit(owner2, privateCar2);
//        townCouncil.issuePermit(owner3, privateCar3);
//        townCouncil.issuePermit(owner4, privateCar4);
//
//
//        Owner owner5 = new Owner("ID5");
//        List<Owner> owners5 = List.of(owner5);
//
//        MotorBike motorBike1 = new MotorBike("number1", owners5, 7, 500);
//
//        townCouncil.issuePermit(owner5, motorBike1);
//
//
////        for (VehicleType vehicleType: townCouncil.vehicleTypeWithNumberOfVehicles.keySet()) {
////            System.out.println(vehicleType);
////        }
//
//        assertEquals(townCouncil.getSizeOfVehicleType(), 5);
//
//
//
//
//
//
//
//
////        MotorBike motorBike1 = new MotorBike("number1", owners1, 7, 500);
////        MotorBike motorBike2 = new MotorBike("number2", owners2, 10, 900);
////        MotorBike motorBike3 = new MotorBike("number3", owners3, 10, 900);
//
//
////        Owner owner = new Owner("ID0");
////        List<Owner> owners = List.of(owner);
////
////
////
////        Owner owner11 = new Owner("ID11");
////        List<Owner> owners11 = List.of(owner11);
//
//
//
//
//
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}