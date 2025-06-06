package models;

public class PromoСode {
    double amountDiscount;
    String code;
    public String getCode() {
        return code;
    }

    public double getAmountDiscount() {
        return amountDiscount;
    }

    public boolean isValid() {
        return true;
    }

    public boolean setValid(boolean used) {
        return used;
    }
}
