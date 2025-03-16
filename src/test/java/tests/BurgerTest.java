package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class) // Использование MockitoJUnitRunner для автоматической инициализации моков
public class BurgerTest {

    @Mock
    Bun bun; // Мок-объект булочки
    @Mock
    Ingredient ingredient; // Мок-объект ингредиента


    // Проверяет, что переданная булочка корректно устанавливается в объекте Burger.
    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        Bun mockedBun = mock(Bun.class);
        burger.setBuns(mockedBun);

        Bun actualBun = burger.bun;
        assertEquals(mockedBun, actualBun);
    }

    // Проверяет, что после добавления ингредиента его количество в списке увеличивается.
    @Test
    public void testAddIngredientWithVerify() {
        Burger burger = new Burger();
        Ingredient mockedIngredient = mock(Ingredient.class);

        burger.addIngredient(mockedIngredient);

        assertEquals(1, burger.ingredients.size());
    }

    // Проверяет, что добавленный ингредиент корректно сохраняется в списке.
    @Test
    public void testAddIngredientWithMock() {
        Burger burger = new Burger();
        Ingredient mockedIngredient = mock(Ingredient.class);

        burger.addIngredient(mockedIngredient);

        assertEquals(mockedIngredient, burger.ingredients.get(0));
    }

   // Проверяет, что после удаления ингредиента размер списка уменьшается.
    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        burger.removeIngredient(0);
        int expectedSize = 0;

        int actualSize = burger.ingredients.size();
        assertEquals(expectedSize, actualSize);
    }

    // Проверяет, что ингредиент перемещается на нужный индекс.
    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(mock(Ingredient.class));
        burger.addIngredient(mock(Ingredient.class));
        Ingredient expectedIngredient = ingredient;

        burger.moveIngredient(0, 2);

        Ingredient actualIngredient = burger.ingredients.get(2);
        assertEquals(expectedIngredient, actualIngredient);
    }

    // Проверяет, что метод корректно вычисляет общую стоимость бургера.
    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Ingredient ingredient2 = mock(Ingredient.class);
        Mockito.when(ingredient.getPrice()).thenReturn(20f);
        Mockito.when(ingredient2.getPrice()).thenReturn(30f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        float expectedPrice = 10f * 2 + 20f + 30f;

        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.01f);
    }

    // Проверяет, что чек генерируется корректно и содержит все необходимые данные.
    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("Fake Bun");
        Mockito.when(bun.getPrice()).thenReturn(44f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("hot sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(55f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String expectedReceipt = String.format(
                "(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                "Fake Bun",
                "filling", "hot sauce",
                "Fake Bun",
                44f * 2 + 55f
        );

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }
}

