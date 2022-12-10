package exercise;

class Cottage implements Home {
    private double area;
    private int floor;

    Cottage(double area, int floor) {
        this.area = area;
        this.floor = floor;
    }
    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public byte compareTo(Home that) {
        if (this.getArea() > that.getArea()) {
            return 1;
        } else if (this.getArea() < that.getArea()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.floor + " этажный коттедж площадью " + this.getArea() + " метров";
    }
}
