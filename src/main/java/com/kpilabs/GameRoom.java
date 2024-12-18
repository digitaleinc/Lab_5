package com.kpilabs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Клас, що представляє ігрову кімнату, яка містить колекцію іграшок.
 */
public class GameRoom {
    private final List<Toy> toys;
    private final double budget;

    /**
     * Конструктор для класу GameRoom.
     *
     * @param budget виділений бюджет для покупки іграшок
     */
    public GameRoom(double budget) {
        this.toys = new ArrayList<>();
        this.budget = budget;
    }

    /**
     * Додає іграшку до ігрової кімнати, якщо це не перевищує бюджет.
     *
     * @param toy іграшка, яку потрібно додати
     * @throws IllegalArgumentException якщо додавання іграшки перевищує бюджет
     */
    public void addToy(Toy toy) {
        if (getTotalPrice() + toy.getPrice() > budget) {
            throw new IllegalArgumentException("Не можна додати іграшку. Бюджет перевищено.");
        }
        toys.add(toy);
    }

    /**
     * Обчислює загальну ціну всіх іграшок в ігровій кімнаті.
     *
     * @return загальна ціна
     */
    public double getTotalPrice() {
        return toys.stream().mapToDouble(Toy::getPrice).sum();
    }

    /**
     * Сортує іграшки на основі заданого компаратора.
     *
     * @param comparator компаратор, що визначає порядок сортування
     */
    public void sortToys(Comparator<Toy> comparator) {
        toys.sort(comparator);
    }

    /**
     * Знаходить іграшки у заданому діапазоні цін.
     *
     * @param minPrice мінімальна ціна
     * @param maxPrice максимальна ціна
     * @return список іграшок у заданому діапазоні цін
     */
    public List<Toy> findToysByPriceRange(double minPrice, double maxPrice) {
        List<Toy> result = new ArrayList<>();
        for (Toy toy : toys) {
            if (toy.getPrice() >= minPrice && toy.getPrice() <= maxPrice) {
                result.add(toy);
            }
        }
        return result;
    }

    /**
     * Відображає всі іграшки в ігровій кімнаті.
     */
    public void displayToys() {
        if (toys.isEmpty()) {
            System.out.println("В ігровій кімнаті немає іграшок.");
            return;
        }
        for (Toy toy : toys) {
            System.out.println(toy);
        }
    }
}
