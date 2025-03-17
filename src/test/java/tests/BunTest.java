package tests;

import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    // Проверяет, что метод корректно возвращает название булочки.
    @Test
    public void testGetName() {
        // Создаём объект булочки с тестовыми данными
        Bun bun = new Bun("Some bun", 500);
        // Ожидаемое название булочки
        String expectedName = "Some bun";

        // Получаем фактическое название
        String actualName = bun.getName();

        // Сравниваем ожидаемое и фактическое значения
        assertEquals(expectedName, actualName);
    }

    // Проверяет, что метод корректно возвращает цену булочки.
    @Test
    public void testGetPrice() {
        // Создаём объект булочки с тестовыми данными
        Bun bun = new Bun("Some bun", 600);
        // Ожидаемая цена булочки
        float expectedPrice = 600;

        // Получаем фактическую цену
        float actualPrice = bun.getPrice();

        // Сравниваем ожидаемое и фактическое значения (точность до 0.01)
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }
}
