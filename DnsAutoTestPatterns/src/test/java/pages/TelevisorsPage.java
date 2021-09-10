package pages;

import helpers.JSExec;
import helpers.WaitFor;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

// Страница "Телевизоры"
public class TelevisorsPage extends BasePage {
  // Инициализация логгера
  private Logger logger = LogManager.getLogger(TelevisorsPage.class);

  // Конструктор класса
  public TelevisorsPage(WebDriver driver) {
    // Вызов родительского конструктора
    super(driver);
  }

  /***** Инициализация локаторов *****/
  // Шапка
  String headerXpath = "//header";

  // Фильтры
  // - Фильтр "Производитель"
  String chbxCompanyXpath = "//span[contains(text(), \"company\")]";
  // - Фильтр "Диаганаль экрана"
  String showScreenDiagonalXpath = "//span[contains(text(), \"Диагональ экрана (дюйм)\")]";
  String textFieldMinScreenDiagonalXpath = "//input[contains(@placeholder, \"от 22\")]";
  String textFieldMaxScreenDiagonalXpath = "//input[contains(@placeholder, \"до 100\")]";
  // - Фильтр "Частота обновления экрана"
  String showScreenRefreshRateXpath = "//span[contains(text(), \"Частота обновления экрана (Гц)\")]";
  String chbxScreenRefreshRateXpath = "//span[contains(text(), \"120 Гц\")]";
  // - Фильтр "Тип подсветки экрана"
  String showTypeLEDXpath = "//span[contains(text(), \"Тип подсветки экрана\")]";
  String chbxTypeLEDXpath = "//span[contains(text(), \"Direct LED\")]";

  // Кнопка Применить
  String btnApplyXpath = "//button[contains(text(), \"Применить\")]";

  // Сортировка
  // - Выпадающее меню "Сортировка"
  String showSortXpath = "//span[contains(text(), \"Сортировка:\")]/following::a";
  // - Переключатель "Сначала дорогие"
  String rbtnExpensiveXpath = "//span[contains(text(), \"Сначала дорогие\")]";

  // Телевизоры
  // - Ссылка на первый продукт в списке
  String linkFirstProductXpath = "(//a[contains(@class, \"catalog-product__name\")])[1]";

  // Скрытие шапки
  public void hideHeader() {
    WebElement header = driver.findElement(By.xpath(headerXpath));
    JSExec.displayNone(header);
  }

  // Нажатие на выпадающее меню "Сортировка"
  public void showSortClick() {
    WaitFor.visibilityOfElementLocated(By.xpath(showSortXpath));
    WebElement showSort = driver.findElement(By.xpath(showSortXpath));
    WaitFor.clickabilityOfElement(showSort);
    showSort.click();
    logger.info("Нажато выпадающее меню \"Сортировка\"");
  }

  // Установка значения сортировки - "Сначала дорогие"
  public void rbtnExpensiveClick() {
    WaitFor.visibilityOfElementLocated(By.xpath(rbtnExpensiveXpath));
    WebElement rbtnExpensive = driver.findElement(By.xpath(rbtnExpensiveXpath));
    WaitFor.clickabilityOfElement(rbtnExpensive);
    rbtnExpensive.click();
    logger.info("Установлено значение сортировки - \"Сначала дорогие\"");
  }

  // Установка фильтра "Производитель"
  public void chbxProductClick(String company) {
    chbxCompanyXpath = chbxCompanyXpath.replace("company", company);
    WaitFor.visibilityOfElementLocated(By.xpath(chbxCompanyXpath));
    WebElement chbxCompany = driver.findElement(By.xpath(chbxCompanyXpath));
    WaitFor.clickabilityOfElement(chbxCompany);
    chbxCompany.click();
    logger.info("Установлен фильтр \"Производитель\" - " + company);
  }

  // Нажатие на гармошку "Диаганаль экрана"
  public void showScreenDiagonalClick() {
    WaitFor.visibilityOfElementLocated(By.xpath(showScreenDiagonalXpath));
    WebElement showScreenDiagonal = driver.findElement(By.xpath(showScreenDiagonalXpath));
    WaitFor.clickabilityOfElement(showScreenDiagonal);
    showScreenDiagonal.click();
    logger.info("Отображены значения фильтра \"Диаганаль экрана\"");
  }

  // Установка значений в фильтр "Диаганаль экрана"
  public void enterTextFieldScreenDiagonal(String minDiagonal, String maxDiagonal) {
    textFieldMinScreenDiagonalXpath = textFieldMinScreenDiagonalXpath.replace("minDiagonal", minDiagonal);
    textFieldMaxScreenDiagonalXpath = textFieldMaxScreenDiagonalXpath.replace("maxDiagonal", maxDiagonal);
    WaitFor.visibilityOfElementLocated(By.xpath(textFieldMinScreenDiagonalXpath));
    WaitFor.visibilityOfElementLocated(By.xpath(textFieldMaxScreenDiagonalXpath));
    WebElement textFieldMinScreenDiagonal = driver.findElement(By.xpath(textFieldMinScreenDiagonalXpath));
    WebElement textFieldMaxScreenDiagonal = driver.findElement(By.xpath(textFieldMaxScreenDiagonalXpath));
    WaitFor.clickabilityOfElement(textFieldMinScreenDiagonal);
    WaitFor.clickabilityOfElement(textFieldMaxScreenDiagonal);
    textFieldMinScreenDiagonal.sendKeys(minDiagonal);
    textFieldMaxScreenDiagonal.sendKeys(maxDiagonal);
    logger.info("Установлен фильтр \"Диаганаль экрана\" -" + " от "+ minDiagonal + " до " + maxDiagonal + " дюймов" );
  }

  // Нажатие на гармошку "Частота обновления экрана"
  public void showScreenRefreshRateClick() {
    WaitFor.visibilityOfElementLocated(By.xpath(showScreenRefreshRateXpath));
    WebElement showScreenRefreshRate = driver.findElement(By.xpath(showScreenRefreshRateXpath));
    WaitFor.clickabilityOfElement(showScreenRefreshRate);
    showScreenRefreshRate.click();
    logger.info("Отображены значения фильтра \"Частота обновления экрана\"");
  }

  // Установка фильтра "Частота обновления экрана"
  public void chbxScreenRefreshRateСlick(String screen) {
    chbxScreenRefreshRateXpath = chbxScreenRefreshRateXpath.replace("screen", screen);
    WaitFor.visibilityOfElementLocated(By.xpath(chbxScreenRefreshRateXpath));
    WebElement chbxScreen = driver.findElement(By.xpath(chbxScreenRefreshRateXpath));
    WaitFor.clickabilityOfElement(chbxScreen);
    chbxScreen.click();
    logger.info("Установлен фильтр \"Частота обновления экрана\" - " + screen);
  }

  // Нажатие на гармошку "Тип подсветки экрана"
  public void showTypeLEDClick() {
    WaitFor.visibilityOfElementLocated(By.xpath(showTypeLEDXpath));
    WebElement showTypeLED = driver.findElement(By.xpath(showTypeLEDXpath));
    WaitFor.clickabilityOfElement(showTypeLED);
    showTypeLED.click();
    logger.info("Отображены значения фильтра \"Тип подсветки экрана\"");
  }

  // Установка фильтра "Тип подсветки экрана"
  public void chbxTypeLEDСlick(String led) {
    chbxScreenRefreshRateXpath = chbxScreenRefreshRateXpath.replace("led", led);
    WaitFor.visibilityOfElementLocated(By.xpath(chbxTypeLEDXpath));
    WebElement chbxScreen = driver.findElement(By.xpath(chbxTypeLEDXpath));
    WaitFor.clickabilityOfElement(chbxScreen);
    chbxScreen.click();
    logger.info("Установлен фильтр \"Тип подсветки экрана\" - " + led);
  }

  // Нажатие на кнопку "Применить"
  public void btnApplyClick() {
    WaitFor.visibilityOfElementLocated(By.xpath(btnApplyXpath));
    WebElement btnApply = driver.findElement(By.xpath(btnApplyXpath));
    WaitFor.clickabilityOfElement(btnApply);
    btnApply.click();
    logger.info("Нажата кнопка \"Применить\"");
  }

  // Скриншот страницы "Телевизоры отсортированные"
  public void makeScreenShots() {
    try {
      WaitFor.visibilityOfElementLocated(By.xpath(linkFirstProductXpath));
      Screenshot screenshot = new AShot().takeScreenshot(driver);
      ImageIO.write(screenshot.getImage(), "png", new File("temp/02_TelevisorsSortedPage.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    logger.info("Сделан скриншот страницы \"Телевизоры отсортированные\"");
  }

  // Нажатие на ссылку первого продукта в списке
  public void linkFirstProductClick(String product) {
    WaitFor.firstProductMustBe(By.xpath(linkFirstProductXpath), product);
    WebElement linkProduct = driver.findElement(By.xpath(linkFirstProductXpath));
    String URL = linkProduct.getAttribute("href");
    driver.switchTo().newWindow(WindowType.WINDOW);
    driver.manage().window().maximize();
    driver.navigate().to(URL);
    logger.info("Нажата ссылка первого продукта в списке");
  }
}
