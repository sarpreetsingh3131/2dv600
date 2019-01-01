package sb223ce_assign2.ex2;

public class Passenger {

    private int fee;

    public Passenger() {
        this.fee = 25; // fee without vehicle
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}