package sb223ce_assign2.ex2;

public interface Ferry extends Iterable<Vehicle> {

    int countPassengers();

    int countVehicleSpace();

    int countMoney();

    void embark(Vehicle v) throws Exception;

    void embark(Passenger p) throws Exception;

    void disembark();

    boolean hasSpaceFor(Vehicle v);

    boolean hasRoomFor(Passenger p);

    String toString();
}