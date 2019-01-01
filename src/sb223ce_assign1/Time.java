package sb223ce_assign1;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time() {
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public Time(int hours, int minutes, int seconds) throws Exception {
        this.setHours(hours);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    public Time(int seconds) throws Exception {
        this.setClock(seconds);
    }

    public void setClock(int seconds) throws Exception {
        if (seconds < 0) {
            throw new Exception("Seconds must be positive.");
        }
        // 1hr = 3600 sec, use mod 24 to go back to 0
        this.hours = (seconds / 3600) % 24;
        // first get remaining sec, then change into min, 1min = 60 sec,
        this.minutes = (seconds % 3600) / 60;
        // get remaining sec
        this.seconds = (seconds % 3600) % 60;
    }

    public void tick() throws Exception {
        this.setClock(this.toSeconds(this) + 1); // increment by 1 second
    }

    public void tickDown() throws Exception {
        this.setClock(this.toSeconds(this) - 1); // decrement by 1 second
    }

    public Time addTime(Time time) throws Exception {
        this.setClock(this.toSeconds(this) + this.toSeconds(time));
        return this;
    }

    public Time subtractTime(Time time) throws Exception {
        int difference = this.toSeconds(this) - this.toSeconds(time);
        difference = difference < 0 ? -difference : difference; // make it positive
        return new Time(difference);
    }

    // helper method that converts time into seconds
    private int toSeconds(Time time) {
        return time.hours * 3600 + time.minutes * 60 + time.seconds;
    }

    @Override
    public String toString() {
        return this.toString(this.hours) + ":" + this.toString(this.minutes) + ":" + this.toString(this.seconds);
    }

    // for printing in hh:mm:ss format
    private String toString(int i) {
        return i < 10 ? "0" + i : "" + i;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) throws Exception {
        if (hours < 0 || hours > 23) {
            throw new Exception("Hours must be in range 0-23.");
        }
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) throws Exception {
        if (minutes < 0 || minutes > 59) {
            throw new Exception("Minutes must be in range 0-59.");
        }
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) throws Exception {
        if (seconds < 0 || seconds > 59) {
            throw new Exception("Seconds must be in range 0-59.");
        }
        this.seconds = seconds;
    }
}
