package com.kpilabs;

/**
 * Абстрактний базовий клас, що представляє загальну іграшку.
 */
public abstract class Toy {
    private final String name;
    private final double price;
    private final String size; // Small, Medium, Large

    /**
     * Конструктор для класу Toy.
     *
     * @param name  назва іграшки
     * @param price ціна іграшки
     * @param size  розмір іграшки (Small, Medium, Large)
     */
    public Toy(String name, double price, String size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    /**
     * Отримує назву іграшки.
     *
     * @return назва іграшки
     */
    public String getName() {
        return name;
    }

    /**
     * Отримує ціну іграшки.
     *
     * @return ціна іграшки
     */
    public double getPrice() {
        return price;
    }

    /**
     * Отримує розмір іграшки.
     *
     * @return розмір іграшки
     */
    public String getSize() {
        return size;
    }

    /**
     * Повертає рядкове представлення іграшки.
     *
     * @return рядкове представлення іграшки
     */
    @Override
    public String toString() {
        return String.format("%s | Назва: %s, Ціна: %.2f, Розмір: %s",
                this.getClass().getSimpleName(), name, price, size);
    }
}
