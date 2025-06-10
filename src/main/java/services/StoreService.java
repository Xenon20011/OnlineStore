package services;

import models.*;

import java.util.List;
import java.util.Map;

public class StoreService {
    private final List<Product> catalog;
    private final Cart cart;

    public StoreService(List<Product> catalog) {
        this.catalog = catalog;
        this.cart = new Cart();
    }

    public void showCatalog() {
        for (Product p : catalog) {
            System.out.println(p.name() + " - " + p.price() + " руб.");
        }
    }

    public void addProductToCart(String name, int quantity) {
        if (quantity > 0) {
            for (Product p : catalog) {
                if (p.name().equalsIgnoreCase(name)) {
                    cart.addItem(p, quantity);
                    System.out.println("Добавлено: " + name + " x" + quantity);
                    return;
                }
            }
            System.out.println("Товар не найден: " + name);
        } else {
            System.out.println("Некорректное количество, попробуйте еще раз");
        }
    }

    public void applyDiscount(double percent) {
        if (percent < 100) {
            cart.setDiscount(percent);
        } else {
            System.out.println("Недопустимый размер скидки");
        }
    }

    public void applyPromoCode(Map<String, PromoСode> promoCodes, String code) {
        if (code.isEmpty()) {
            System.out.println("Введите промокод");
            return;
        }
        PromoСode promo = promoCodes.get(code.toUpperCase());
        if (!promoCodes.containsKey(code.toUpperCase()) || !promo.isValid()) {
            System.out.println("Промокод не найден или уже использован");
            return;
        }
        cart.setDiscount(promo.getDiscount());
        promo.markAsUsed();
    }

    public void printCart() {
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getProduct().name() + " x" + item.getQuantity() + " = " + item.getTotalPrice());
        }
        System.out.println("Итого со скидкой: " + calculateTotal());
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : cart.getItems()) {
            total += item.getTotalPrice();
        }
        double discountAmount = total * cart.getDiscountPercent() / 100;
        return total - discountAmount;
    }
}
