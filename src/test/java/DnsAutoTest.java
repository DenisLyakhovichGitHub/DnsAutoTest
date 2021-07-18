import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class DnsAutoTest {
  protected static WebDriver driver;
  final private Logger logger = LogManager.getLogger(DnsAutoTest.class);

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
    //1.открытие страницы
    driver.get("https://www.dns-shop.ru");
    //общие настройки браузера
    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    logger.info("Открыта страница Yandex - " + "https://www.dns-shop.ru");
    logger.info("--------------------------------------");

    //2.вывод заголовка страцицы
    String title = driver.getTitle();
    logger.info("Title - " + title);
    logger.info("--------------------------------------");

    //3.вывод URL страницы
    String currentURL = driver.getCurrentUrl();
    logger.info("CurrentURL - " + currentURL);
    logger.info("--------------------------------------");

    //4.Переход по ссылке бытовая техника
    WebElement elementPopAppLocation = driver.findElement(By.linkText("Да"));
    logger.info("WebElement: " + elementPopAppLocation.getText());
    elementPopAppLocation.click();
    logger.info("--------------------------------------");
    WebElement elementAppliances = driver.findElement(By.linkText("Бытовая техника"));
    logger.info("WebElement: " + elementAppliances.getText());
    elementAppliances.click();
    logger.info("--------------------------------------");

    //5.Вывод всех категорий товаров бытовой техники в логи
    List<WebElement> elements = driver.findElements(By.className("subcategory__title"));
    for(WebElement element : elements)
      logger.info("WebElement: " + element.getText());
    logger.info("--------------------------------------");

    //6.Добавление и вывод Cookie
    logger.info("Куки, которое добавили мы");
    driver.manage().addCookie(new Cookie("Cookie 1", "This Is Cookie 1"));
    Cookie cookie1  = driver.manage().getCookieNamed("Cookie 1");
    logger.info(String.format("Domain: %s", cookie1.getDomain()));
    logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
    logger.info(String.format("Name: %s",cookie1.getName()));
    logger.info(String.format("Path: %s",cookie1.getPath()));
    logger.info(String.format("Value: %s",cookie1.getValue()));
    logger.info("--------------------------------------");
    logger.info("Куки от DNS");
    Set<Cookie> cookies = driver.manage().getCookies();
    for(Cookie cookie : cookies) {
      logger.info(String.format("Domain: %s", cookie.getDomain()));
      logger.info(String.format("Expiry: %s", cookie.getExpiry()));
      logger.info(String.format("Name: %s", cookie.getName()));
      logger.info(String.format("Path: %s", cookie.getPath()));
      logger.info(String.format("Value: %s", cookie.getValue()));
      logger.info("--------------------------------------");
    }

    //7.задержка sleep
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
