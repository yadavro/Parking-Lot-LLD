package model.ticket;

import enums.TicketStatus;
import model.vehicle.Vehicle;
import model.parking.ParkingSpot;

public class Ticket {
    private static int counter=1;

    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private long entryTime;
    private long exitTime;
    private TicketStatus status;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime=System.currentTimeMillis();
        this.status=TicketStatus.ACTIVE;
        this.ticketId="TICKET-"+ counter++;
    }

    public void closeTicket(){
        this.exitTime=System.currentTimeMillis();
        this.status=TicketStatus.CLOSED;
    }

    public ParkingSpot getSpot(){
        return spot;
    }
    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }
}
