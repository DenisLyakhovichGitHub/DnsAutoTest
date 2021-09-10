package helpers;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


  // ожидание событий на странице
public class WaitFor {
  // инициализация логгера
  private Logger logger = LogManager.getLogger(WaitFor.class);
  // ожидание драйвера браузера
  protected static WebDriverWait wait;
  // инициализация ожидания драйвера браузера
  // установка таймаута ожидания и интервала опроса
  public static void initWait(WebDriver driver, Duration timeOut, Duration sleep) {
    wait = new WebDriverWait(driver, timeOut, sleep);
  }
  // ожидание наличия элемента по локатору
  public static void presenceOfElementLocated(By webElement) {
    wait.until(ExpectedConditions.presenceOfElementLocated(webElement));
  }
  // ожидание появления текста в элементе
  public static void presenceOfTextInElement(WebElement webElement, String text) {
    wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
  }
  // ожидание кликабельности элемента
  public static void clickabilityOfElement(WebElement webElement) {
    wait.until(ExpectedConditions.elementToBeClickable(webElement));
  }
  // ожидание кликабельности элемента по локатору
  public static void clickabilityOfElementLocated(By webElement) {
    wait.until(ExpectedConditions.elementToBeClickable(webElement));
  }
  // ожидание видимости элемента
  public static void visibilityOfElement(WebElement webElement) {
    wait.until(ExpectedConditions.visibilityOf(webElement));
  }
  // ожидание видимости элемента по локатору
  public static void visibilityOfElementLocated(By webElement) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
  }
  // ожидание появления в списке продуктов в первой позиции заданного продукта
  public static void firstProductMustBe(By webElement, String product) {
    wait.until((ExpectedCondition<Boolean>) webDriver ->
        webDriver.findElement(webElement).getText().contains(product));
  }
}
