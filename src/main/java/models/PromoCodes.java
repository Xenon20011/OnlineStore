package models;

public class PromoCodes implements PromoСode {
    private final String code;
    private final double discount;
    private boolean used;

    public PromoCodes(String code, double discount) {
        this.code = code;
        this.discount = discount;
        this.used = false;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public boolean isValid() {
        return !used;
    }

    @Override
    public void markAsUsed() {
        this.used = true;
    }
}

