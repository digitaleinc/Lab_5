package com.kpilabs;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// variant 25

// Task

// 1. Підготувати ігрову кімнату для дітей різних вікових груп.
// Іграшок повинно бути фіксована кількість у межах виділеної суми грошей.
// Повинні зустрічатися іграшки для різних вікових груп: маленькі, середні та великі
// машинки, ляльки, м'ячі, кубики. Провести сортування іграшок у кімнаті за
// будь-яким параметром. Знайти іграшку в кімнаті, що відповідає заданому
// діапазону вартості.

// 2. Створити узагальнений клас та не менше 3 класів-нащадків,
// що описують задану варіантом (п.2) область знань.
// Створити клас, що складається з масиву об’єктів, з яким можна
// виконати вказані варіантом дії. Необхідно обробити всі виключні ситуації,
// що можуть виникнути під час виконання програмного коду. Код повинен бути
// детально задокументований. Код повинен відповідати стандартам Java Code Conventions
// (або Google Java Style Guide) та бути завантаженим на GitHub.

/**
 * Головний клас для запуску програми Ігрової Кімнати.
 */
public class Main {
    /**
     * Головний метод для виконання програми.
     *
     * @param args командні аргументи
     */
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            GameRoom gameRoom = new GameRoom(500.0); // Приклад бюджету
            // Додавання іграшок
            gameRoom.addToy(new Car("Хот вілс", 10.13, "маленька", "швидкісна"));
            gameRoom.addToy(new Doll("барбі", 15.22, "середня", "коричневий"));
            gameRoom.addToy(new Ball("баскетбольний м'яч", 8.01, "велика", "ґума"));
            gameRoom.addToy(new Block("набір лего", 29.23, "середня", 150));
            gameRoom.addToy(new Car("стара машинка", 12.87, "маленька", "вінтаж"));

            // Відображення всіх іграшок
            System.out.println("Всі іграшки в ігровій кімнаті:");
            gameRoom.displayToys();

            // Сортування іграшок за ціною
            gameRoom.sortToys(Comparator.comparingDouble(Toy::getPrice));
            System.out.println("\nІграшки, відсортовані за ціною:");
            gameRoom.displayToys();

            // Пошук іграшок у діапазоні цін
            System.out.print("\nВведіть мінімальну ціну: ");
            double minPrice = scanner.nextDouble();
            System.out.print("Введіть максимальну ціну: ");
            double maxPrice = scanner.nextDouble();

            List<Toy> filteredToys = gameRoom.findToysByPriceRange(minPrice, maxPrice);
            System.out.println("\nІграшки у заданому діапазоні цін:");
            if (filteredToys.isEmpty()) {
                System.out.println("Немає іграшок у цьому діапазоні.");
            } else {
                for (Toy toy : filteredToys) {
                    System.out.println(toy);
                }
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Сталася непередбачена помилка.");
        }
    }
}
