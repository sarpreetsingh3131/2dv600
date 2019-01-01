package sb223ce_assign1;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public boolean isEqualTo(Point point) {
        if (point instanceof Point) { // check if point is valid object
            return this.x == point.x && this.y == point.y;
        }
        return false;
    }

    public double distanceTo(Point point) throws Exception {
        if (point instanceof Point) {
            return Math.sqrt(Math.pow(this.x - point.y, 2) + Math.pow(this.y - point.y, 2));
        }
        throw new Exception("The given object is not an instance of Point class.");
    }

    public void move(int x, int y) {
        this.x += x; // add
        this.y += y;
    }

    public void moveToXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
