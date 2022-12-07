package exercise;

class Segment {
    private final Point beginPoint;

    private final Point endPoint;

    Segment (Point point1, Point point2) {
        this.beginPoint = point1;
        this.endPoint = point2;
    }

    public Point getMidPoint() {
        int x = (beginPoint.getX() + endPoint.getX()) / 2;
        int y = (beginPoint.getY() + endPoint.getY()) / 2;
        return new Point(x, y);
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }
}
