package org.example.authorisationandpermit;

import org.example.Owner;
import org.example.vehicles.Vehicle;

public interface VerificationService {
    boolean verifyPerson(Owner owner, Vehicle vehicle);
}
