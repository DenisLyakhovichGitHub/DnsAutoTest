package pages;

import helpers.JSExec;
import helpers.WaitFor;
import java.time.Duration;
import org.openqa.selenium.WebDriver;


// Базовый класс для всех объектов веб страниц
public class BasePage {
  // Драйвер браузера
  protected static WebDriver driver;
  // Конструктор базового класса
  public BasePage(WebDriver driver) {
    BasePage.driver = driver;
    // Инициализация ожидания - 20 секунд
    WaitFor.initWait(driver, Duration.ofSeconds(20), Duration.ofMillis(150));
    // Инициализация исполнителя JS скриптов
    JSExec.initJS(driver);
    // инициализация ожидания загрузки страницы
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
  }
}
