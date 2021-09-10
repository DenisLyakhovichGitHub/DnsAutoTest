package tests.televisors;

import org.junit.jupiter.api.Assertions;
import pages.TelevisorsProductPage;

// Матчер с проверками страницы "Продукт. Телевизор"
public class TelevisorsProductPageAssert {
  // Страница "Продукт. Телевизор"
  TelevisorsProductPage page;
  // Конструктор
  public TelevisorsProductPageAssert(TelevisorsProductPage page) {
    this.page = page;
  }
  // Проверка / Утверждение (Матчер)
  public void pageTitleEquals(String expected) {
    String actual = page.getPageTitle();
    Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
  }
}
