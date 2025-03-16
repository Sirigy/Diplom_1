package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AvailableBunsTest {

    private final String expectedName;
    private final float expectedPrice;
    private final int index;

    // Конструктор, принимающий параметры теста.
    public AvailableBunsTest(String expectedName, float expectedPrice, int index) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
        this.index = index;
    }

    // Метод, предоставляющий параметры для параметризованных тестов.
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"black bun", 100, 0},
                {"white bun", 200, 1},
                {"red bun", 300, 2}
        };
    }

    // Проверяет, что имя булочки в списке базы данных соответствует ожидаемому.
    @Test
    public void testAvailableBunName() {
        // Создаём объект базы данных
        Database database = new Database();
        // Получаем булочку по индексу
        Bun actualBun = database.availableBuns().get(index);
        // Проверяем, что имя булочки совпадает с ожидаемым
        assertEquals(expectedName, actualBun.getName());
    }

    // Проверяет, что цена булочки в списке базы данных соответствует ожидаемой.
    @Test
    public void testAvailableBunPrice() {
        // Создаём объект базы данных
        Database database = new Database();
        // Получаем булочку по индексу
        Bun actualBun = database.availableBuns().get(index);
        // Проверяем, что цена булочки совпадает с ожидаемой (точность до 0.01)
        assertEquals(expectedPrice, actualBun.getPrice(), 0.01f);
    }
}

