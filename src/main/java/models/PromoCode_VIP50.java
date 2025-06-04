package models;

public class PromoCode_VIP50 implements PromoСode {
  final double VIP50=50.0;

    @Override
    public double getPromoCode() {
        return VIP50;
    }

    @Override
    public void applyPromoСode() {

    }
}
