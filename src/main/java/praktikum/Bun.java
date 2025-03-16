package praktikum;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
public class Bun {

    public String name;
    public float price;

    // Конструктор
    public Bun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    // ========================= Геттеры =========================
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

}