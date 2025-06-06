package cli;

import models.*;
import services.StoreService;

import java.util.*;


public class Class {
    public static void main(String[] args) {
        Map<String, PromoСode> promoCodes = new HashMap<>();
        promoCodes.put("WELCOME10", new PromoCode_WELCOME10());
        promoCodes.put("VIP50", new PromoCode_VIP50());


        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product("Футболка", 1000));
        catalog.add(new Product("Книга", 500));
        catalog.add(new Product("Кружка", 300));

        StoreService store = new StoreService(catalog);
        Scanner scanner = new Scanner(System.in);
String code=scanner.nextLine();
        if (code.isEmpty()) {
                System.out.println("Введите промокод");
                return;
            }
            PromoСode promo = promoCodes.get(code);
        System.out.println(promo.getCode());
            if (!promoCodes.containsKey(code.toUpperCase()) || !promo.isValid()) {
                System.out.println("Промокод не найден или уже использован");
                return;
            }
        System.out.println(promo.getAmountDiscount());
            promo.setValid(false);
        }
    }

