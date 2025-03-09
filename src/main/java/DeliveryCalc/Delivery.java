package DeliveryCalc;

public class Delivery {

    private double distance;
    private Dimensions dimensions;
    private Fragile fragile;
    private Traffic traffic;

    public Delivery(double distance, Dimensions dimensions, Fragile fragile, Traffic traffic) {

        if (distance <= 0) {
            throw new IllegalArgumentException("It can't be negative value or 0");
        }

        this.distance = distance;
        this.dimensions = dimensions;
        this.fragile = fragile;
        this.traffic = traffic;

    }

    public double calculateDelivery() {

        int basicPayment = 400;

        int distanceExtraTax;

        if (this.distance > 30) {
            distanceExtraTax = 300;
        } else if (this.distance > 10) {
            distanceExtraTax = 200;
        } else if (this.distance > 2) {
            distanceExtraTax = 100;
        } else {
            distanceExtraTax = 50;
        }

        if (fragile == Fragile.YES && this.distance > 30) {
            throw new ArithmeticException("Fragile package can't be delivered so far > 30 km");
        }

        double totalPayment = (distanceExtraTax  + dimensions.getTax() + fragile.getTax()) * traffic.getKoefficient();

        if (totalPayment > 400) {
            return totalPayment;

        } else return 400;
    }
}