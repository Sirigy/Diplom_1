package praktikum;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс с методами по работе с базой данных.
 */
public class Database {

    // Список доступных булочек
    private final List<Bun> buns = new ArrayList<>();
    // Список доступных ингредиентов
    private final List<Ingredient> ingredients = new ArrayList<>();

    // Конструктор заполняет "базу данных" тестовыми булочками и ингредиентами.
    public Database() {
        // Добавляем булочки в список
        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));
        buns.add(new Bun("red bun", 300));

        // Добавляем соусы в список ингредиентов
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));

        // Добавляем начинки в список ингредиентов
        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));
    }

    //Получить список всех доступных булочек (return: список булочек).
    public List<Bun> availableBuns() {
        return buns;
    }

    // Получить список всех доступных ингредиентов (return: список ингредиентов).
    public List<Ingredient> availableIngredients() {
        return ingredients;
    }

}