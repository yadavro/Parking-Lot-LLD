package model.parking;

import enums.SpotType;
import enums.VehicleType;
import model.vehicle.Vehicle;

public class ParkingSpot {
    private int id;
    private Vehicle parkedVehicle;
    private SpotType spotType;

    public ParkingSpot(int id, SpotType spotType) {
        this.id = id;
        this.spotType = spotType;
    }

    public boolean isFree(){
        return parkedVehicle==null;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        if(vehicle.getType()== VehicleType.MOTORCYCLE){
            return  true;
        }else if(vehicle.getType()==VehicleType.CAR){
            return spotType ==SpotType.MEDIUM || spotType ==SpotType.LARGE;
        }else if(vehicle.getType()==VehicleType.TRUCK){
            return spotType== SpotType.LARGE;
        }
        return false;
    }

    public void parkVehicle(Vehicle vehicle){
        this.parkedVehicle=parkedVehicle;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
    }

    public int getId() {
        return id;
    }
}
