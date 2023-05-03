package org.example.vehicles;

import org.example.Owner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PrivateCarTest {

    @Test
    public void calculateCharge(){
        Owner owner = new Owner("ID1");
        List<Owner> owners = List.of(owner);

        PrivateCar privateCar = new PrivateCar("number1", owners, 20);

        assertEquals(20, privateCar.calculateCharge());
    }

}