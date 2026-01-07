package factory;

import enums.VehicleType;
import model.vehicle.Car;
import model.vehicle.MotorCycle;
import model.vehicle.Truck;
import model.vehicle.Vehicle;

public class VehicleFactory {
    public  static Vehicle createVehicle(VehicleType type,String license){
        switch (type) {
            case CAR:
                return new Car(license, type);
            case MOTORCYCLE:
                return new MotorCycle(license, type);
            case TRUCK:
                return new Truck(license, type);
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }
}
