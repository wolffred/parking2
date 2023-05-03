package org.example.authorisationandpermit;

import org.example.vehicles.Vehicle;

public interface PermitIssuerService {
    String issuePermit(Vehicle vehicle);
}
