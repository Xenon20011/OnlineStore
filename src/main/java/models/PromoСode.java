package models;

public interface PromoСode {
    String getCode();

    double getDiscount();

    boolean isValid();

    void markAsUsed();
}

