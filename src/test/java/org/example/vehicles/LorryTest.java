package org.example.vehicles;

import org.example.Owner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LorryTest {

    @Test
    void calculateChargeForCapacityGreaterThanMAxCapacity (){
        Owner owner = new Owner("ID1");
        List<Owner> owners = List.of(owner);

        Lorry lorry = new Lorry("number1", owners, 30,  180);

        lorry.calculateCharge();

        assertEquals(lorry.getFinalCharge(), 40);
    }


    @Test
    void calculateChargeForCapacityLesserThanMAxCapacity (){
        Owner owner = new Owner("ID1");
        List<Owner> owners = List.of(owner);

        Lorry lorry = new Lorry("number1", owners, 30, 50);

        lorry.calculateCharge();

        assertEquals(lorry.getFinalCharge(), 30);
    }

}