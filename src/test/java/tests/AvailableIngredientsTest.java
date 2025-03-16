package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AvailableIngredientsTest {

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;
    private final int index;

    // Конструктор, принимающий параметры теста.
    public AvailableIngredientsTest(IngredientType expectedType, String expectedName, float expectedPrice, int index) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
        this.index = index;
    }

    // Метод, предоставляющий параметры для параметризованных тестов.
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100, 0},
                {IngredientType.SAUCE, "sour cream", 200, 1},
                {IngredientType.SAUCE, "chili sauce", 300, 2},
                {IngredientType.FILLING, "cutlet", 100, 3},
                {IngredientType.FILLING, "dinosaur", 200, 4},
                {IngredientType.FILLING, "sausage", 300, 5}
        };
    }

    // Проверяет, что тип ингредиента в базе данных соответствует ожидаемому.
    @Test
    public void testAvailableIngredientType() {
        // Создаём объект базы данных
        Database database = new Database();
        // Получаем ингредиент по индексу
        Ingredient actualIngredient = database.availableIngredients().get(index);
        // Проверяем, что тип ингредиента совпадает с ожидаемым
        assertEquals(expectedType, actualIngredient.getType());
    }

    // Проверяет, что название ингредиента в базе данных соответствует ожидаемому.
    @Test
    public void testAvailableIngredientName() {
        // Создаём объект базы данных
        Database database = new Database();
        // Получаем ингредиент по индексу
        Ingredient actualIngredient = database.availableIngredients().get(index);
        // Проверяем, что название ингредиента совпадает с ожидаемым
        assertEquals(expectedName, actualIngredient.getName());
    }

    // Проверяет, что цена ингредиента в базе данных соответствует ожидаемой.
    @Test
    public void testAvailableIngredientPrice() {
        // Создаём объект базы данных
        Database database = new Database();
        // Получаем ингредиент по индексу
        Ingredient actualIngredient = database.availableIngredients().get(index);
        // Проверяем, что цена ингредиента совпадает с ожидаемой (точность до 0.01)
        assertEquals(expectedPrice, actualIngredient.getPrice(), 0.01f);
    }
}

