package org.example;

import org.example.model.Vehicle;

public class Truck extends Vehicle {

    private double cargoCapacityTons;

    public Truck(String plateNumber, String ownerName, int registrationYear, String status,double cargoCapacityTons) {
        super(plateNumber, ownerName, "Truck", registrationYear, status);
        this.cargoCapacityTons = cargoCapacityTons;
    }

    @Override
    public String getRegistrationLabel() {
        return "Commercial Truck — Cargo: " + cargoCapacityTons + " tons";

    }

}
