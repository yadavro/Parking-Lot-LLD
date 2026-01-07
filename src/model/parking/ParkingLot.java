package model.parking;

import model.ticket.Ticket;
import model.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingFloor> floors=new ArrayList<>();

    private ParkingLot (){}

    public static synchronized ParkingLot getInstance(){
        if(instance==null){
            instance=new ParkingLot();
        }
        return instance;
    }

    public  void addFloor(ParkingFloor floor){
        floors.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle){
        for(ParkingFloor floor: floors){
            ParkingSpot spot=floor.findAvailableSpace(vehicle);
            if(spot!=null){
                spot.parkVehicle(vehicle);
                return new Ticket(vehicle,spot);
            }
        }
        return  null;
    }

    public void unparkVehicle(Ticket ticket){
        ticket.getSpot().removeVehicle();
        ticket.closeTicket();
    }
}
