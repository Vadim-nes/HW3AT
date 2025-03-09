package DeliveryCalc;

public enum Fragile {
    YES (300),
    NO (0);

    private int tax;

    Fragile (int tax) {
        this.tax = tax;
    }

    public int getTax (){
        return tax;
    }


}
