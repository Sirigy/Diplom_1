package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

// Указываем, что тест будет параметризованным
@RunWith(Parameterized.class)
public class IngredientTypeTest {

    // Поле для хранения тестируемого типа ингредиента
    private final IngredientType ingredientType;

    // Поле для хранения ожидаемого строкового представления
    private final String name;

    // Конструктор, который будет получать параметры теста
    public IngredientTypeTest(IngredientType ingredientType, String name) {
        this.ingredientType = ingredientType;
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"}, // Тестируем, что IngredientType.SAUCE соответствует строке "SAUCE"
                {IngredientType.FILLING, "FILLING"} // Тестируем, что IngredientType.FILLING соответствует строке "FILLING"
        };
    }

    // Тест проверяет, что метод name() у IngredientType возвращает ожидаемое строковое значение
    @Test
    public void nameIngredientTypeTest() {
        assertEquals(name, ingredientType.name()); // Сравниваем ожидаемое и фактическое значения
    }
}
