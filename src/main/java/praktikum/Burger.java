package praktikum;

import java.util.ArrayList;
import java.util.List;

/**
 * Модель бургера.
 * Бургер состоит из булочек и ингредиентов (начинка или соус).
 * Ингредиенты можно перемещать и удалять.
 * Можно распечать чек с информацией о бургере.
 */
public class Burger {

    // Булочка, используемая в бургере
    public Bun bun;
    // Список ингредиентов бургера
    public List<Ingredient> ingredients = new ArrayList<>();

    // ========================= Методы =========================

    // Установить булочку для бургера (сеттер).
    public void setBuns(Bun bun) {
        this.bun = bun;
    }

    // Добавить ингредиент в бургер (ingredient объект ингредиента).
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    // Удалить ингредиент из бургера по индексу (index индекс ингредиента в списке).
    public void removeIngredient(int index) {
        ingredients.remove(index);
    }

    /* Переместить ингредиент в списке на новую позицию.
    index - текущий индекс ингредиента;
    newIndex - новый индекс, на который нужно переместить ингредиент.
     */
    public void moveIngredient(int index, int newIndex) {
        ingredients.add(newIndex, ingredients.remove(index));
    }

    /* Рассчитать стоимость бургера.
    В стоимость включается:
    - Двойная цена булочки;
    - Суммарная цена всех ингредиентов.
    return: общая стоимость бургера.
     */
    public float getPrice() {
        float price = bun.getPrice() * 2;

        for (Ingredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }

        return price;
    }

    /* Получить чек с составом и ценой бургера.
    return: строка с информацией о бургере
     */
    public String getReceipt() {
        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName())); // Верхняя булочка

        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),// Тип ингредиента (начинка/соус)
                    ingredient.getName()));// Название ингредиента
        }

        receipt.append(String.format("(==== %s ====)%n", bun.getName())); // Нижняя булочка
        receipt.append(String.format("%nPrice: %f%n", getPrice())); // Итоговая цена

        return receipt.toString();
    }

}