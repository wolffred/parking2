package org.example;

import java.util.Objects;

public class Owner {

    private String nationalId;


    public Owner(String nationalId) {
        this.nationalId = nationalId;

    }


    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return nationalId.equals(owner.nationalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalId);
    }
}
