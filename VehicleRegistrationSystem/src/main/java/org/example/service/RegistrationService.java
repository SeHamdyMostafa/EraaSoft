package org.example.service;

import org.example.customExceptions.DuplicatePlateException;
import org.example.customExceptions.VehicleNotFoundException;
import org.example.model.Vehicle;

import java.util.*;

public class RegistrationService {


    private List<Vehicle> vehicleList = new ArrayList<>(); // For adding
    private Map<String, Vehicle> plateIndex = new HashMap<>(); //For Searching
    private Set<String> registeredPlates = new HashSet<>(); // For duplicate check


    public void registerVehicle(Vehicle vehicle){
        String plateNumber=vehicle.getPlateNumber().toUpperCase();
        if(registeredPlates.contains(plateNumber)){
            throw new DuplicatePlateException(plateNumber);
        }
        vehicleList.add(vehicle);
        plateIndex.put(plateNumber, vehicle);
        registeredPlates.add(plateNumber);

    }

    public Vehicle findByPlate(String plateNumber){
        plateNumber=plateNumber.toUpperCase();
        if (!plateIndex.containsKey(plateNumber)){
            throw new VehicleNotFoundException(plateNumber);
        }
        return plateIndex.get(plateNumber);

    }

    public void deleteVehicle(String plateNumber){
       Vehicle vehicle=findByPlate(plateNumber);
        plateNumber=plateNumber.toUpperCase();
        if (!plateIndex.containsKey(plateNumber)){
            throw new VehicleNotFoundException(plateNumber);
        }
        plateIndex.remove(plateNumber);
        vehicleList.remove(vehicle);
        registeredPlates.remove(plateNumber);

    }

    public void updateOwner(String plateNumber, String newOwner){
        Vehicle vehicle=findByPlate(plateNumber);
        if (!plateIndex.containsKey(plateNumber)){
            throw new VehicleNotFoundException(plateNumber);
        }
        vehicle.setOwnerName(newOwner);
        }

        public List<Vehicle> getAllVehicles(){
        return  Collections.unmodifiableList(vehicleList);
        }


}
