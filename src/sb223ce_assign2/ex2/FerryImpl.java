package sb223ce_assign2.ex2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FerryImpl implements Ferry {

    private final int MAX_VEHICLE_SPACE = 250;
    private final int MAX_PASSENGERS = 200;
    private List<Passenger> passengers;
    private List<Vehicle> vehicles;
    private int money;

    public FerryImpl() {
        this.money = 0;
        this.passengers = new ArrayList<>();
        this.vehicles = new ArrayList<>();
    }

    @Override
    public int countPassengers() {
        return this.passengers.size();
    }

    @Override
    public int countVehicleSpace() {
        return this.vehicles.stream() // using Java Stream API
                .mapToInt(vehicles -> vehicles.getSpace()) // get space of each vehicle
                .sum(); // return the sum
    }

    @Override
    public int countMoney() {
        return this.money;
    }

    @Override
    public void embark(Vehicle v) throws Exception {
        if (this.vehicles.contains(v)) {
            throw new Exception("Cannot embark the same vehicle(" + v.getType() + ") twice!!");
        }
        for (Passenger passenger : v.getPassengers()) {
            this.embark(passenger);
        }
        this.money += v.getFee();
        this.vehicles.add(v);
    }

    @Override
    public void embark(Passenger p) throws Exception {
        if (this.passengers.contains(p)) {
            throw new Exception("Cannot embark the same person twice!!");
        }
        this.money += p.getFee();
        this.passengers.add(p);
    }

    @Override
    public void disembark() {
        this.passengers.clear();
        this.vehicles.clear();
    }

    @Override
    public boolean hasSpaceFor(Vehicle v) {
        return this.countVehicleSpace() + v.getSpace() <= this.MAX_VEHICLE_SPACE;
    }

    @Override
    public boolean hasRoomFor(Passenger p) {
        return this.countPassengers() + 1 <= this.MAX_PASSENGERS;
    }

    @Override
    public Iterator<Vehicle> iterator() {
        // no need to implement iterator as ArrayList provide it
        return this.vehicles.iterator();
    }

    @Override
    public String toString() {
        return "{\n\tMoney earned = " + this.countMoney() +
                "\n\tTotal passengers on board = " + this.countPassengers() +
                "\n\tPassengers with vehicle  = " + this.countPassengersWithVehicle() +
                "\n\tPassengers without vehicle = " + (this.countPassengers() - this.countPassengersWithVehicle()) +
                "\n\tSeats available for passengers = " + (this.MAX_PASSENGERS - this.countPassengers()) +
                "\n\tTotal vehicles on board = " + this.vehicles.size() +
                "\n\tNo. of bicycles = " + this.countParticularVehicle(Vehicle.Type.BICYCLE) +
                "\n\tNo. of buses = " + this.countParticularVehicle(Vehicle.Type.BUS) +
                "\n\tNo. of cars = " + this.countParticularVehicle(Vehicle.Type.CAR) +
                "\n\tNo. of lorries = " + this.countParticularVehicle(Vehicle.Type.LORRY) +
                "\n\tSpaces available for vehicles = " + (this.MAX_VEHICLE_SPACE - this.countVehicleSpace()) +
                "\n}";
    }

    // Extra methods to display extra information
    private int countPassengersWithVehicle() {
        return this.vehicles.stream()
                .mapToInt(vehicle -> vehicle.getPassengers().size())
                .sum();
    }

    private int countParticularVehicle(Vehicle.Type type) {
        return (int) this.vehicles.stream()
                .filter(vehicle -> vehicle.getType() == type)
                .count();
    }
}
