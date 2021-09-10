package pages;

import elements.Accordeon;
import elements.Button;
import elements.CheckBox;
import elements.Link;
import elements.MainBlock;
import elements.RadioButton;
import helpers.WaitFor;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

// Страница "Телевизоры"
public class TelevisorsPageWithElements extends BasePage {
  // Логгер
  private Logger logger = LogManager.getLogger(TelevisorsPageWithElements.class);

  // Конструктор класса
  public TelevisorsPageWithElements(WebDriver driver) {
    // Вызов родительского конструктора
    super(driver);
  }

  // ***** Локаторы *****
  // Шапка
  String mainBlockXpath = "//header";
  // Фильтры
  // - Фильтр "Производитель"
  String chbxCompanyXpath = "//span[contains(text(), \"company\")]";

  // - Фильтр "Диаганаль экрана"
  String accordeonScreenDiagonalXpath = "//span[contains(text(), \"Диагональ экрана (дюйм)\")]";
  String textFieldMinScreenDiagonalXpath = "//input[contains(@placeholder, \"от 22\")]";
  String textFieldMaxScreenDiagonalXpath = "//input[contains(@placeholder, \"до 100\")]";

  // - Фильтр "Частота обновления экрана"
  String accordeonScreenRefreshRateXpath = "//span[contains(text(), \"Частота обновления экрана (Гц)\")]";
  String chbxScreenRefreshRateXpath = "//span[contains(text(), \"120 Гц\")]";

  // - Фильтр "Тип подсветки экрана"
  String accordeonTypeLEDXpath = "//span[contains(text(), \"Тип подсветки экрана\")]";
  String chbxTypeLEDXpath = "//span[contains(text(), \"Direct LED\")]";

  // Кнопка Применить
  String btnApplyXpath = "//button[contains(text(), \"Применить\")]";

  // Сортировка
  // - Выпадашка "Сортировка"
  String accordeonSortXpath = "//span[contains(text(), \"Сортировка:\")]/following::a";
  // - Переключатель "Сначала дорогие"
  String rbtnExpensiveXpath = "//span[contains(text(), \"Сначала дорогие\")]";

  // Телевизоры
  // - Ссылка на первый продукт в списке
  String linkFirstProductXpath = "(//a[contains(@class, \"catalog-product__name\")])[1]";

  // Скрытие шапки
  public void mainBlockHide() {
    MainBlock mainBlock = new MainBlock(driver, By.xpath(mainBlockXpath));
    mainBlock.hide();
  }

  // Нажатие на выпадашку "Сортировка"
  public void accordeonSortClick() {
    Accordeon accordeonSort = new Accordeon(driver, By.xpath(accordeonSortXpath));
    accordeonSort.show();
    logger.info("Нажата выпадашка \"Сортировка\"");
  }

  // Установка сортировки "Сначала дорогие"
  public void rbtnExpensiveClick() {
    RadioButton rbtnExpensive = new RadioButton(driver, By.xpath(rbtnExpensiveXpath));
    rbtnExpensive.setSelected(true);
    logger.info("Установлена сортировка - \"Сначала дорогие\"");
  }

  // Установка фильтра "Производитель"
  public void chbxCompanyClick(String company) {
    chbxCompanyXpath = chbxCompanyXpath.replace("company", company);
    CheckBox chbxCompany = new CheckBox(driver, By.xpath(chbxCompanyXpath));
    chbxCompany.setChecked(true);
    logger.info("Установлен фильтр \"Производитель\" - " + company);
  }

  // Нажатие на гармошку "Диагональ экрана"
  public void accordeonScreenDiagonalClick() {
    Accordeon accordeonScreenDiagonal = new Accordeon(driver, By.xpath(accordeonScreenDiagonalXpath));
    accordeonScreenDiagonal.show();
    logger.info("Отображены значения фильтра \"Диагональ экрана\"");
  }

  // Установка фильтра "Диагональ экрана"
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
  public void accordeonScreenRefreshRateClick() {
    Accordeon accordeonScreenRefreshRate = new Accordeon(driver, By.xpath(accordeonScreenRefreshRateXpath));
    accordeonScreenRefreshRate.show();
    logger.info("Отображены значения фильтра \"Частота обновления экрана\"");
  }

  // Установка фильтра "Частота обновления экрана"
  public void chbxScreenRefreshRateClick(String screenRefreshRate) {
    chbxScreenRefreshRateXpath = chbxScreenRefreshRateXpath.replace("screenRefreshRate", screenRefreshRate);
    CheckBox chbxRAM = new CheckBox(driver, By.xpath(chbxScreenRefreshRateXpath));
    chbxRAM.setChecked(true);
    logger.info("Установлен фильтр \"Частота обновления экрана\" - " + screenRefreshRate);
  }

  // Нажатие на гармошку "Тип подсветки экрана"
  public void accordeonTypeLEDClick() {
    Accordeon accordeonTypeLED = new Accordeon(driver, By.xpath(accordeonTypeLEDXpath));
    accordeonTypeLED.show();
    logger.info("Отображены значения фильтра \"Тип подсветки экрана\"");
  }

  // Установка фильтра "Тип подсветки экрана"
  public void chbxSTypeLEDClick(String led) {
    chbxTypeLEDXpath = chbxTypeLEDXpath.replace("led", led);
    CheckBox chbxRAM = new CheckBox(driver, By.xpath(chbxTypeLEDXpath));
    chbxRAM.setChecked(true);
    logger.info("Установлен фильтр \"Тип подсветки экрана\" - " + led);
  }

  // Нажатие на кнопку "Применить"
  public void btnApplyClick() {
    Button btnApply = new Button(driver, By.xpath(btnApplyXpath));
    btnApply.click();
    logger.info("Нажата кнопка \"Применить\"");
  }

  // Нажатие на ссылку первого продукта в списке
  public void linkFirstProductClick(String product) {
    WaitFor.firstProductMustBe(By.xpath(linkFirstProductXpath), product);
    Link linkProduct = new Link(driver, By.xpath(linkFirstProductXpath));
    linkProduct.openInNewWindow();
    logger.info("Нажата ссылка первого продукта в списке");
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
}


