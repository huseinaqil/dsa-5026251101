public class Rental implements Chargeable {
    private String id;
    private int days;

    protected Rental(String id, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Days can not be 0 or negative");
        }
        this.id = id;
        this.days = days;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    public int calculateCharge() {
        return 0;
    }

    public int calculateCharge(int units) {
        if (units <= 0) {
            throw new IllegalArgumentException("units can not be 0 or negative");
        }
        return units * calculateCharge();
    }

    public String label() {
        return "Rental";
    }

    public String summary(int units) {
        return id + " | " + label() + " | " + calculateCharge(units);
    }
}
