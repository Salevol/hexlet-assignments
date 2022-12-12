package exercise;

class Circle {

    private final Point center;
    private final Integer radius;

    Circle (Point center, Integer radius) {
        this.radius = radius;
        this.center = center;
    }

    public Integer getRadius() {
        return radius;
    }

    public Double getSquare() throws NegativeRadiusException{
        if (this.radius < 0) {
            throw new NegativeRadiusException();
        }
        return Math.PI * radius * radius;
    }


}
