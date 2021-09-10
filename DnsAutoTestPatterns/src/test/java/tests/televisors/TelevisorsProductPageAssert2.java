package tests.televisors;

import org.junit.jupiter.api.Assertions;
import steps.TelevisorsProductPageSteps;

public class TelevisorsProductPageAssert2 {
  TelevisorsProductPageSteps televisorsProductPageSteps;
  // Конструктор
  public TelevisorsProductPageAssert2(TelevisorsProductPageSteps smartphoneProductPageSteps) {
    this.televisorsProductPageSteps = smartphoneProductPageSteps;
  }
  // Проверка / Утверждение (Матчер)
  public void pageTitleEquals(String expected) {
    String actual = televisorsProductPageSteps.pageTitle();
    Assertions.assertEquals(expected, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
  }
}
