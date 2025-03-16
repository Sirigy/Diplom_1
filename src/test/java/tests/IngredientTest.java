package tests;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;


public class IngredientTest {

    // Проверяет, что метод корректно возвращает цену ингредиента.
    @Test
    public void testGetPrice() {
        // Создаём объект ингредиента с тестовыми данными
        Ingredient ingredient = new Ingredient(FILLING, "some ingredient", 500);
        // Ожидаемая цена ингредиента
        float expectedPrice = 500;

        // Получаем фактическую цену
        float actualPrice = ingredient.getPrice();

        // Сравниваем ожидаемое и фактическое значения (точность до 0.01)
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }

    // Проверяет, что метод корректно возвращает название ингредиента.
    @Test
    public void testGetName() {
        // Создаём объект ингредиента с тестовыми данными
        Ingredient ingredient = new Ingredient(FILLING, "some ingredient", 600);
        // Ожидаемое название ингредиента
        String expectedName = "some ingredient";

        // Получаем фактическое название
        String actualName = ingredient.getName();

        // Сравниваем ожидаемое и фактическое значения
        assertEquals(expectedName, actualName);
    }

    // Проверяет, что метод корректно возвращает тип ингредиента.
    @Test
    public void testGetType() {
        // Создаём объект ингредиента с тестовыми данными
        Ingredient ingredient = new Ingredient(FILLING, "some ingredient", 400);
        // Ожидаемый тип ингредиента
        IngredientType expectedType = FILLING;

        // Получаем фактический тип
        IngredientType actualType = ingredient.getType();

        // Сравниваем ожидаемое и фактическое значения
        assertEquals(expectedType, actualType);
    }
}

