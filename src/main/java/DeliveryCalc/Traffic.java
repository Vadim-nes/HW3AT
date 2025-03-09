package DeliveryCalc;

public enum Traffic {
    STANDARD (1),
    MEDIUM (1.2),
    HIGH (1.4),
    HIGHEST (1.6);

    private double koefficient;

    Traffic (double koefficient) {
        this.koefficient = koefficient;
    }

    public double getKoefficient (){
        return koefficient;
    }
}
