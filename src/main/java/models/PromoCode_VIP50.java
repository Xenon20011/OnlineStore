package models;

public class PromoCode_VIP50 extends PromoСode {
    double amountDiscount = 50.0;
    String code = "VIP50";

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
