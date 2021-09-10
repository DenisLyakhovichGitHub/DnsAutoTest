package pages;

import helpers.WaitFor;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;


public class TelevisorsProductPage extends BasePage {

  // Инициализация логгер
  private Logger logger = LogManager.getLogger(TelevisorsProductPage.class);

  // Конструктор класса
  public TelevisorsProductPage(WebDriver driver) {
    // Вызов родительского конструктора
    super(driver);
  }

  /***** Инициализация локаторов *****/
  // Ссылка "Характеристики" выбранного товара
  String linkTextSpecificationsXpath = "//a[contains(text(), \"Характеристики\")]";
  //String linkTextSpecificationsXpath = "/html/body/div[1]/div[4]/div[1]/div/div[1]/a[2]";
  // Характеристики выбранного продукта  Samsung QE75Q950TSUXRU "//td[contains(text(), \"Samsung QE75Q950TSUXRU\")]";
  // - Модель произаодителя
  String modelSpecificationsXpath = "/html/body/div[1]/div[4]/div[2]/div[2]/div[2]/table/tbody/tr[5]/td[2]";
  // - Диаганаль экрана телевизора
  String screenDiagonalSpecificationsXpath = "/html/body/div[1]/div[4]/div[2]/div[2]/div[2]/table/tbody/tr[14]/td[2]";
  // - Частота обновления экрана телевизора
  String screenRefreshRateSpecificationsXpath = "/html/body/div[1]/div[4]/div[2]/div[2]/div[2]/table/tbody/tr[21]/td[2]";
  // - Тип подсветки экрана телевизора
  String typeLEDSpecificationsXpath = "/html/body/div[1]/div[4]/div[2]/div[2]/div[2]/table/tbody/tr[11]/td[2]";

  // Нажатие на ссылку "Характеристики" выбранного товара
  public void linkSpecificationsClick() {
    WaitFor.presenceOfElementLocated(By.xpath(linkTextSpecificationsXpath));
    WebElement linkSpecifications = driver.findElement(By.xpath(linkTextSpecificationsXpath));
    WaitFor.clickabilityOfElement(linkSpecifications);
    linkSpecifications.click();
    logger.info("Нажата ссылка \"Характеристики\"");
  }

  // Скриншот страницы "Продукта Телевизоры"
  public void makeScreenShots() {
    try {
      Screenshot screenshot = new AShot().takeScreenshot(driver);
      ImageIO.write(screenshot.getImage(), "png", new File("temp/03_TelevisorsSortedNewPage.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    logger.info("Сделан скриншот страницы \"Телевизоры отсортированные в новом окне\"");
  }

  // Скриншот страницы "Характеристики" товара
  public void makeScreenShotsSpecifications() {
    try {
      WaitFor.presenceOfElementLocated(By.xpath(linkTextSpecificationsXpath));
      Screenshot screenshot = new AShot().takeScreenshot(driver);
      ImageIO.write(screenshot.getImage(), "png", new File("temp/04_TelevisorsSortedSpecifications.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    logger.info("Сделан скриншот страницы \"Характеристики телевизора\"");
  }

  // Получение заголовка текущей страницы
  public String getPageTitle() {
    String title = driver.getTitle();
    logger.info("Заголовок страницы: " + title);
    return title;
  }

  // Проверка Характеристики - модель производителя
  public void modelSpecificationsAssertions() {
    WaitFor.presenceOfElementLocated(By.xpath(modelSpecificationsXpath));
    WebElement modelSpecifications = driver.findElement(By.xpath(modelSpecificationsXpath));
    String textMоdelActual = modelSpecifications.getText();
    logger.info("Модель телевизора -  " + textMоdelActual);
    String textModelExpected = "Samsung QE75Q950TSUXRU";
    Assertions.assertEquals(textModelExpected, textMоdelActual);
  }

  // Проверка Характеристики - диаганаль экрана
  public void screenDiagonalSpecificationsAssertions() {
    WaitFor.presenceOfElementLocated(By.xpath(screenDiagonalSpecificationsXpath));
    WebElement diagonalSpecifications = driver.findElement(By.xpath(screenDiagonalSpecificationsXpath));
    String textScreenDiagonalActual = diagonalSpecifications.getText();
    logger.info("Размер диаганали экрана телевизора -  " + textScreenDiagonalActual);
    String textScreenDiagonalExpected = "75\"";
    Assertions.assertEquals(textScreenDiagonalExpected, textScreenDiagonalActual);
  }

  // Проверка Характеристики - частоты обновления экрана
  public void screenRefreshRateSpecificationsAssertions() {
    WaitFor.presenceOfElementLocated(By.xpath(screenRefreshRateSpecificationsXpath));
    WebElement refreshRateSpecifications = driver.findElement(By.xpath(screenRefreshRateSpecificationsXpath));
    String textScreenRefreshRateActual = refreshRateSpecifications.getText();
    logger.info("Частота обновления экрана телевизора -  " + textScreenRefreshRateActual);
    String textScreenRefreshRateExpected = "120 Гц";
    Assertions.assertEquals(textScreenRefreshRateExpected, textScreenRefreshRateActual);
  }

  // Проверка Характеристики - тип подсветки экрана телевизора
  public void typeLEDSpecificationsAssertions() {
    WaitFor.presenceOfElementLocated(By.xpath(typeLEDSpecificationsXpath));
    WebElement typeLEDSpecifications = driver.findElement(By.xpath(typeLEDSpecificationsXpath));
    String textТypeLEDActual = typeLEDSpecifications.getText();
    logger.info("Тип подсветки экрана телевизора -  " + textТypeLEDActual);
    String textTextТypeLEDExpected = "Direct LED";
    Assertions.assertEquals(textTextТypeLEDExpected, textТypeLEDActual);
  }
}
