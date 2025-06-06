package models;

public class PromoCode_WELCOME10 extends PromoСode {
    double amountDiscount = 10.0;
    String code = "WELCOME10";
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
