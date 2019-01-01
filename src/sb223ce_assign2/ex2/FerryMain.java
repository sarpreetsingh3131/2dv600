package sb223ce_assign2.ex2;

import sb223ce_assign2.ex2.Vehicle.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FerryMain {

    public static void main(String[] args) {
        try {
            Ferry ferry = new FerryImpl();
            Vehicle bicycle1 = new Bicycle(createPassengers(1));
            Vehicle bus1 = new Bus(createPassengers(20));
            Vehicle car1 = new Car(createPassengers(4));
            Vehicle lorry1 = new Lorry(createPassengers(2));

            Vehicle bicycle2 = new Bicycle(createPassengers(1));
            Vehicle bus2 = new Bus(createPassengers(20));
            Vehicle car2 = new Car(createPassengers(4));
            Vehicle lorry2 = new Lorry(createPassengers(2));

            List<Vehicle> vehicles = new ArrayList<>(
                    Arrays.asList(bicycle1, bicycle2, bus1, bus2, car1, car2, lorry1, lorry2));

            List<Passenger> passengers = new ArrayList<>(createPassengers(150));

            for (Vehicle v : vehicles) {
                if (ferry.hasSpaceFor(v)) {
                    ferry.embark(v);
                }
            }

            for (Passenger p : passengers) {
                if (ferry.hasRoomFor(p)) {
                    ferry.embark(p);
                }
            }

            System.out.println(ferry);

            ferry.iterator().forEachRemaining(vehicle -> System.out.println(vehicle));

            ferry.disembark();

            System.out.println(ferry);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static List<Passenger> createPassengers(int amount) {
        List<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            passengers.add(new Passenger());
        }
        return passengers;
    }
}
