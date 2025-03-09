package DeliveryCalc;

public enum Dimensions {

    LARGE (200),
    SMALL (100);

    private int tax;

    Dimensions (int tax) {
        this.tax = tax;
    }

    public int getTax(){
        return tax;
    }
}
