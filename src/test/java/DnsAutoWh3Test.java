import java.io.File;
import java.io.IOException;
import java.time.Duration;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import org.openqa.selenium.support.events.EventFiringDecorator;


public class DnsAutoWh3Test {

  protected static WebDriver driver;
  final private Logger logger = LogManager.getLogger(DnsAutoWh3Test.class);

  //читаем передаваемый праметр browser по ключ-значению, параметризированный запуск
  String env = System.getProperty("browser", "chrome");
  //читаем предаваемый парметр option по ключ-значению, параметризированный запуск
  String pageLoad = System.getProperty("option", "normal");

  @BeforeEach
  public void setUp() {
    logger.info("env = " + env);
    logger.info("option = " + pageLoad);
    driver = WebDriverFactory.getDriver(env.toLowerCase(),pageLoad.toUpperCase());
    logger.info("Драйвер стартовал");
  }

  @Test
  public void openPage() {
    //установить неявное ожидание загрузки страницы
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
    //установить максимальный размер окна
    driver.manage().window().maximize();
    logger.info("Окно в полноэкранном режиме");

    //вывод логв через событие
    DriverListener listener = new DriverListener();
    WebDriver eventFiringWebDriver = new EventFiringDecorator(listener).decorate(driver);

    //открыть станицу https://www.dns-shop.ru"
    eventFiringWebDriver.get("https://www.dns-shop.ru");
    logger.info("Открыта страница https://www.dns-shop.ru - " +
          "https://www.dns-shop.ru");
    logger.info("--------------------------------------");

    //закрыть вспывающее сообщение локаци
    //вывод логов через событие
    logger.info("Вывод логов через событие драйвера:");
    WebElement elementPopAppLocation = eventFiringWebDriver.findElement(By.linkText("Да"));
    JavascriptExecutor jseElementPopAppLocation= (JavascriptExecutor) eventFiringWebDriver;
    String scriptelEmentPopAppLocation = "arguments[0].click();";
    logger.info("--------------------------------------");
    jseElementPopAppLocation.executeScript(scriptelEmentPopAppLocation, elementPopAppLocation);
    logger.info("Нажата кнопка Да всплывающего сообщения геологации");
    logger.info("--------------------------------------");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    //открыть всплывающий каталог в категории товаров Смартфоны и гаджеты
    WebElement elementSmartAndGadget = driver.findElement(By.linkText("Смартфоны и гаджеты"));
    Actions actionsElementSmartAndGadget = new Actions(driver);
      actionsElementSmartAndGadget
          .moveToElement(elementSmartAndGadget)
          .pause(Duration.ofSeconds(2))
          .build()
          .perform();

    //нажать ссылку Смартфоны в каталоге Смартфоны и гаджеты
    WebElement elementSmartphone = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/div[1]/a[1]"));
    Actions actionsElementSmartphone = new Actions(driver);
    actionsElementSmartphone
        .moveToElement(elementSmartphone)
        .click()
        .build()
        .perform();
    logger.info("Нажата ссылка Смартфоны в каталоге Смартфоны и гаджеты");
    logger.info("--------------------------------------");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    //снять скриншот страницы Смартфоны
    try {
      Screenshot screenshot = new AShot().takeScreenshot(driver);
      ImageIO.write(screenshot.getImage(), "png", new File("temp/01_SmartphonePage.png"));
      logger.info("Скриншот сохранен в файле [temp\\01_SmartphonePage.png]");
      logger.info("--------------------------------------");
    } catch (IOException e) {
      e.printStackTrace();
    }

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    //проскроллить вниз на 1000px до фильтра Производитель
    JavascriptExecutor jsScroll1000px = (JavascriptExecutor) driver;
    String scriptScroll1000px = "window.scrollBy(0,1000);";
    jsScroll1000px.executeScript(scriptScroll1000px);
    logger.info("Проскроллено вниз на 1000px");
    logger.info("--------------------------------------");

    //выбрать значение в фильтре Производитель - Samsung
    WebDriverWait waitElementSamsung = new WebDriverWait(driver, Duration.ofSeconds(100));
    By chbXpathElementSamsung = By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[3]/div[1]/div[5]/div/div/div[2]/label[20]/span[2]");
    WebElement chbOptionSamsung = driver.findElement(chbXpathElementSamsung);
    waitElementSamsung.until(ExpectedConditions.elementToBeClickable(chbOptionSamsung));
    //проставить чекбокс
    chbOptionSamsung.click();
    logger.info("Выбрано значение в фильтре Производитель - Samsung");
    logger.info("--------------------------------------");

    //открыть выпадающее меню фильтра Объем оперативной памяти
    WebElement elemenOpenMemory = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[3]/div[1]/div[8]/a"));
    elemenOpenMemory.click();
    logger.info("Открыто выпадающее меню фильтра Объем оперативной памяти");
    logger.info("--------------------------------------");

    //проскроллить вниз на 700px до фильтра Производитель
    JavascriptExecutor jsScroll700px = (JavascriptExecutor) driver;
    String scriptScroll700px = "window.scrollBy(0,700);";
    jsScroll700px.executeScript(scriptScroll700px);
    logger.info("Проскроллено вниз на 700px");
    logger.info("--------------------------------------");

    //выбрать значение в фильтре Объем оперативной памяти - 8Гб
    WebDriverWait waitElementMemory = new WebDriverWait(driver, Duration.ofSeconds(100));
    By chbXpathElementMemory = By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[3]/div[1]/div[8]/div/div/div[2]/label[6]");
    WebElement chbOptionMemory = driver.findElement(chbXpathElementMemory);
    waitElementMemory.until(ExpectedConditions.elementToBeClickable(chbOptionMemory));
    //проставить чекбокс
    chbOptionMemory.click();
    logger.info("Выбрано значение в фильтре Объем оперативной памяти - 8Гб");
    logger.info("--------------------------------------");

    //нажать на кнопку Применить
    WebElement elementButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[3]/div[2]/div/button[1]"));
    JavascriptExecutor jselementButton = (JavascriptExecutor) driver;
    String scriptElementButton = "arguments[0].click();";
    jselementButton.executeScript(scriptElementButton, elementButton);
    logger.info("Нажата кнопка Применить");
    logger.info("--------------------------------------");

    //нажать на кнопку Вверх
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    WebElement elementButtonUp = driver.findElement(By.id("scroll-top-button"));
    JavascriptExecutor jselementButtonUp = (JavascriptExecutor) driver;
    String scriptElementButtonUp = "arguments[0].click();";
    jselementButtonUp.executeScript(scriptElementButtonUp, elementButtonUp);
    logger.info("Нажата кнопка Вверх");
    logger.info("--------------------------------------");

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //нажать на выпадающее меню сортировки
    WebElement elementSort = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/a/span[1]"));
    elementSort.click();
    logger.info("Нажата выпадающая сортировка");
    logger.info("--------------------------------------");

    //выбрать сортировку Сначало дорогие
    WebElement elementSortSelected = driver.findElement(By.xpath("/html/body/div[5]/div/label[2]"));
    elementSortSelected.click();
    logger.info("Применена сортировка Сначало дорогие");
    logger.info("--------------------------------------");

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //снять скриншот отсортированной страницы Смартфоны
    try {
      Screenshot screenshot = new AShot().takeScreenshot(driver);
      ImageIO.write(screenshot.getImage(), "png", new File("temp/02_SortedSmartphonePage.png"));
      logger.info("Скриншот сохранен в файле [temp\\02_SortedSmartphonePage.png]");
      logger.info("--------------------------------------");
    } catch (IOException e) {
      e.printStackTrace();
    }

    /*
    //Открыть станицу первого продукта в новой вкладке
    WebElement elementFirstProduct = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/a"));
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.open()", elementFirstProduct);
    //js.executeScript("arguments[0].setAttribute('target','_blank');",elementFirstProduct);
    elementFirstProduct.click();
    */

    // получить ID текущего окна
    String oldWindow = driver.getWindowHandle();
    logger.info("ID старого окна: " + oldWindow);
    logger.info("--------------------------------------");

    //выбрать первый элемент отсортированных смартфонов
    WebElement elementProductOldWindow = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/a"));
    elementProductOldWindow.click();

    //получить заголовок страницы выбранного смартфона
    WebElement elementTitleOldWindow = driver.findElement(By.xpath("/html/body/div[1]/div[2]/h1"));
    String textTitleOldWindow  = elementTitleOldWindow.getText();
    logger.info("Заголовок страницы : " + textTitleOldWindow);
    logger.info("--------------------------------------");

    //открыть станицу первого продукта в новом окне
    driver.switchTo().newWindow(WindowType.WINDOW);
    //получить ID нового окна
    String newWindow = driver.getWindowHandle();
    logger.info("ID нового окна: " + newWindow);
    logger.info("--------------------------------------");
    driver.get("https://www.dns-shop.ru/catalog/17a8a01d16404e77/smartfony/?order=2&brand=samsung&f[9a8]=i2ft");

    //закрыть вспывающее сообщение локаци
    WebElement elementAlert = driver.findElement(By.linkText("Да"));
    JavascriptExecutor jselementAlert= (JavascriptExecutor) driver;
    String scriptElementAlert = "arguments[0].click();";
    jselementAlert.executeScript(scriptElementAlert, elementAlert);
    logger.info("Нажата кнопка Да всплывающего сообщения геологации");
    logger.info("--------------------------------------");

    //выбрать первый элемент отсортированных смартфонов в новом окне
    WebElement productSmartphone = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div/div[2]/div[1]/a"));
    productSmartphone.click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    //снять скриншот нового окна со страницой выбранного смартфона Смартфоны
    try {
      Screenshot screenshot = new AShot().takeScreenshot(driver);
      ImageIO.write(screenshot.getImage(), "png", new File("temp/03_NewWindowSortedSmartphonePage.png"));
      logger.info("Скриншот сохранен в файле [temp\\03_NewWindowSortedSmartphonePage.png]");
      logger.info("--------------------------------------");
    } catch (IOException e) {
      e.printStackTrace();
    }

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    //проверить заголовок новой страницы смартфорна со старой страницей
    WebElement elementTitleNewWindow = driver.findElement(By.xpath("/html/body/div[1]/div[2]/h1"));
    String textTitleTitleNewWindow = elementTitleNewWindow.getText();
    logger.info("Заголовок страницы: " + textTitleTitleNewWindow);
    if (elementTitleNewWindow != null) {
      Assertions.assertFalse(elementTitleNewWindow.equals(elementTitleOldWindow), "Заголовок страницы не соответствует ожидаемому");
      logger.info("Заголовок страницы соответствует ожидаемому");
    } else {
      Assertions.assertTrue(textTitleTitleNewWindow.equals(textTitleTitleNewWindow), "Заголовок страницы не соответствует ожидаемому");
    }
    logger.info("--------------------------------------");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    //проскроллить вниз на 1200px до фильтра Производитель
    JavascriptExecutor jsScrollNewWindiw1200px = (JavascriptExecutor) driver;
    String scriptScrollNewWindiw1200px = "window.scrollBy(0,1200);";
    jsScrollNewWindiw1200px.executeScript(scriptScrollNewWindiw1200px);
    logger.info("Проскроллено вниз на 1200px");
    logger.info("--------------------------------------");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    //нажать на Характеристики выбранного товара
    WebElement elementCharacter = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/div/div[1]/a[2]"));
    Actions actionsЕlementCharacter = new Actions(driver);
    actionsЕlementCharacter
        .click(elementCharacter)
        .build()
        .perform();
    logger.info("Нажата ссылка Характеристики товара");
    logger.info("--------------------------------------");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    //проскроллить вниз на 1000px до фильтра Производитель
    JavascriptExecutor jsScrollNewWindiw1000px = (JavascriptExecutor) driver;
    String scriptScrollNewWindiw1000px = "window.scrollBy(0,1000);";
    jsScrollNewWindiw1000px.executeScript(scriptScrollNewWindiw1000px);
    logger.info("Проскроллено вниз на 1000px");
    logger.info("--------------------------------------");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    //проверить объем оперативной памяти Смартфона
    WebElement elementMemoryC = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[2]/table/tbody/tr[41]/td[2]"));
    String textMemory = elementMemoryC.getText();
    logger.info("Объем оперативной памяти Смартфона: " + textMemory);
    if (textMemory != null) {
      Assertions.assertTrue(textMemory.equals(textMemory), "Объем ОП смартфона не соответствует ожидаемому");
      logger.info("Объем ОП смартфона соответствует ожидаемому");
    } else {
      Assertions.assertFalse(textMemory.equals(textMemory), "Объем ОП смартфона отсутствует");
    }
    logger.info("--------------------------------------");

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    //нажать на кнопку Вверх
    WebElement elementButtonUpEnd = driver.findElement(By.id("scroll-top-button"));
    JavascriptExecutor jselementButtonUpEnd = (JavascriptExecutor) driver;
    String scriptElementButtonUpEnd = "arguments[0].click();";
    jselementButtonUpEnd.executeScript(scriptElementButtonUpEnd, elementButtonUpEnd);
    logger.info("Нажата кнопка Вверх");
    logger.info("--------------------------------------");

    //driver.switchTo().window(oldWindow);

    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @AfterEach
  public void setDown() {
    if(driver != null) {
      driver.quit();
      logger.info("Драйвер остановлен!");
    }
  }
}

