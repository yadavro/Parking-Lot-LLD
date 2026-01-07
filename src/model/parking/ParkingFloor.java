package model.parking;

import model.vehicle.Vehicle;

import java.util.List;

public class ParkingFloor {
    private int floorName;
    private List<ParkingSpot> spots;

    public ParkingFloor(int floorName, List<ParkingSpot> spots) {
        this.floorName = floorName;
        this.spots = spots;
    }

    public ParkingSpot findAvailableSpace(Vehicle vehicle){
        for(ParkingSpot spot: spots){
            if(spot.isFree() && spot.canFitVehicle(vehicle)){
                return spot;
            }
        }
        return null;
    }
}
