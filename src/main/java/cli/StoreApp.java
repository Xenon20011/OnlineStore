package cli;

import enums.Commands;
import models.Product;
import models.PromoCode_VIP50;
import models.PromoCode_WELCOME10;
import models.PromoСode;
import services.StoreService;

import java.util.*;

public class StoreApp {
    public static void main(String[] args) {
        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product("Футболка", 1000));
        catalog.add(new Product("Книга", 500));
        catalog.add(new Product("Кружка", 300));

        Map<String, PromoСode> promoCodes = new HashMap<>();
        promoCodes.put("WELCOME10", new PromoCode_WELCOME10());
        promoCodes.put("VIP50", new PromoCode_VIP50());

        StoreService store = new StoreService(catalog);
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            try {
                System.out.println("""
                        \n
                        Пиши \'catalog\' что бы посмотреть каталог
                        Пиши \'add\' что бы добавить товар в корзину
                        Пиши \'discount\' что бы применить скидку
                        Пиши \'promocode\' что бы применить промокод
                        Пиши \'list\' что бы показать корзину
                        Пиши \'exit\' что бы выйти
                        """);
                String choice = scanner.nextLine();
                switch (Commands.valueOf(choice.toUpperCase())) {
                    case Commands.CATALOG -> store.showCatalog();
                    case Commands.ADD -> {
                        System.out.print("Введите название товара: ");
                        String name = scanner.nextLine();
                        System.out.print("Введите количество: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        if (quantity > 0) {
                            store.addProductToCart(name, quantity);
                        } else {
                            System.out.println("Некорректное количество, попробуйте еще раз");
                        }
                    }
                    case Commands.DISCOUNT -> {
                        System.out.print("Введите процент скидки: ");
                        double percent = Double.parseDouble(scanner.nextLine());
                        if (percent < 100) {
                            store.applyDiscount(percent);
                        } else {
                            System.out.println("Недопустимый размер скидки");
                        }
                    }
                    case Commands.PROMOCODE -> {
                        System.out.print("Введите промокод: ");
                        String promo = scanner.nextLine();
                        store.applyPromoCode(promoCodes, promo);
                    }
                    case Commands.LIST -> store.printCart();
                    case Commands.EXIT -> running = false;
                    default -> System.out.println("Неверный ввод.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Необработанная ошибка");
            } catch (IllegalArgumentException e) {
                System.out.println("Неверная команда");
            }

        }
        scanner.close();
        System.out.println("Спасибо за покупки!");
    }
}