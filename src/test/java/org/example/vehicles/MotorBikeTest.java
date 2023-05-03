package org.example.vehicles;

import org.example.Owner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MotorBikeTest {



    @Test
    public void calculateChargeWhenCapacityIsLessThan850(){
        Owner owner = new Owner("ID1");
        List<Owner> owners = List.of(owner);

        MotorBike motorBike = new MotorBike("number1", owners, 7,  500);

        assertEquals(7, motorBike.calculateCharge());
    }




    @Test
    public void calculateChargeWhenCapacityIsGreaterThan850(){
        Owner owner = new Owner("ID1");

        List<Owner> owners = List.of(owner);
        MotorBike motorBike = new MotorBike("number1", owners, 7, 950);

        assertEquals(10, motorBike.calculateCharge());
    }

}