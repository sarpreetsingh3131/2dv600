package sb223ce_assign2.ex2;

import java.util.List;

public abstract class Vehicle {

	private int space;
	private int fee;
	private int maxPassengers;
	private List<Passenger> passengers;
	private Type type;

	public Vehicle(Type type, int space, int fee, int passengerFee, int maxPassengers, List<Passenger> passengers)
			throws Exception {
		this.type = type;
		this.space = space;
		this.fee = fee;
		this.maxPassengers = maxPassengers;

		if (passengers.size() > maxPassengers) {
			throw new Exception("Only " + maxPassengers + " can travel in a " + type + "!!");
		}

		this.passengers = passengers;
		passengers.forEach(passenger -> passenger.setFee(passengerFee)); // set the respective fee
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public int getSpace() {
		return this.space;
	}

	public int getFee() {
		return this.fee;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "{\n\tVehicle type = " + this.type + "\n\tVehicle fee = " + this.fee + "\n\tSpace needed  = "
				+ this.space + "\n\tMax passengers limit = " + this.maxPassengers + "\n\tPassengers carrying = "
				+ this.passengers.size() + "\n\tPassenger fee = " + this.passengers.get(0).getFee() + "\n}";
	}

	// for extra information
	protected enum Type {
		BICYCLE, BUS, CAR, LORRY
	}

	// We can make separate java files for below classes,
	// however I prefer in this way as we only require constructors.
	// 1 CAR SPACE = 5 BICYCLES SPACES, 1 LORRY = 40 BICYCLES, 1 BUS = 20 BICYCLES

	public static class Bicycle extends Vehicle {

		Bicycle(List<Passenger> passengers) throws Exception {
			super(Type.BICYCLE, 1, 50, 0, 1, passengers);
		}
	}

	public static class Lorry extends Vehicle {

		Lorry(List<Passenger> passengers) throws Exception {
			super(Type.LORRY, 40, 300, 15, 2, passengers);
		}
	}

	public static class Bus extends Vehicle {

		Bus(List<Passenger> passengers) throws Exception {
			super(Type.BUS, 20, 200, 10, 20, passengers);
		}
	}

	public static class Car extends Vehicle {

		Car(List<Passenger> passengers) throws Exception {
			super(Type.CAR, 5, 100, 15, 4, passengers);
		}
	}
}
