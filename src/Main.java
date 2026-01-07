import FeeCalculator.HourlyFeeStrategy;
import enums.SpotType;
import enums.VehicleType;
import factory.VehicleFactory;
import model.ticket.Ticket;
import model.vehicle.Vehicle;
import model.parking.ParkingFloor;
import model.parking.ParkingLot;
import model.parking.ParkingSpot;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot=ParkingLot.getInstance();
        ParkingFloor floor1= new ParkingFloor(1, Arrays.asList(
                new ParkingSpot(1, SpotType.SMALL),
                new ParkingSpot(2, SpotType.MEDIUM),
                new ParkingSpot(3, SpotType.LARGE)));

        parkingLot.addFloor(floor1);

        Vehicle car= VehicleFactory.createVehicle(VehicleType.CAR, "KA-01-1234");
        Ticket ticket=parkingLot.parkVehicle(car);

        System.out.println("Vehicle parked. Ticket issued.");

        Thread.sleep(2000);

        parkingLot.unparkVehicle(ticket);

        HourlyFeeStrategy feeStrategy = new HourlyFeeStrategy();
        double fee = feeStrategy.calculateFee(ticket.getEntryTime(), ticket.getExitTime());

        System.out.println("Vehicle unparked. Fee = ₹" + fee);
    }
}