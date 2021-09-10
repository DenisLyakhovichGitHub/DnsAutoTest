package pages;
import helpers.WaitFor;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

// Стартовая страница сайта DNS
public class StartPage extends BasePage {
  // Инициализация логгера
  private Logger logger = LogManager.getLogger(StartPage.class);
  // Инициализация стартовой страницы URL
  private final String URL = "https://www.dns-shop.ru/";

  /***** Инициализация локаторов *****/
  // Кнопка "Да" на всплывающем сообщении геолокации
  String linkTextYes = "Да";
  // Ссылка на раздел "TB и мультимедиа"
  String linkTextTvAndMultimedia = "ТВ и мультимедиа";
  // Ссылка на раздел "Телевизоры"
  String linkTvXpath = "(//a[contains(text(), \"Телевизоры\")])[2]";

  // Конструктор класса
  public StartPage(WebDriver driver) {
    // Вызов родительского конструктора
    super(driver);
  }
  // Получение URL страницы
  public String getURL() {
    return this.URL;
  }
  // Открытие стартовой страницы
  public void openPage() {
    driver.get(this.URL);
    logger.info("Открыта страница https://www.dns-shop.ru/");
  }
  // Нажатие на кнопку "Да" всплывающего сообщения геолокации
  public void linkYesClick() {
    WaitFor.presenceOfElementLocated(By.linkText(linkTextYes));
    WebElement linkYes = driver.findElement(By.linkText(linkTextYes));
    WaitFor.clickabilityOfElement(linkYes);
    linkYes.click();
    logger.info("Нажата кнопка всплывающего сообщения геолокации \"Да\"");
  }
  // Наведение курсора мыши на ссылку "TB и мультимедиа"
  public void linkTvAndMultimediaMove() {
    WaitFor.presenceOfElementLocated(By.linkText(linkTextTvAndMultimedia));
    WebElement linkTvAndMultimedia = driver.findElement(By.linkText(linkTextTvAndMultimedia));
    Actions actions = new Actions(driver);
    actions.moveToElement(linkTvAndMultimedia).perform();
    logger.info("Курсор мыши наведен на ссылку \"ТВ и мультимедиа\"");
  }
  // Нажатие на ссылку "Телевизоры"
  public void linkTvClick() {
    WaitFor.visibilityOfElementLocated(By.xpath(linkTvXpath));
    WebElement linkTvs = driver.findElement(By.xpath(linkTvXpath));
    WaitFor.clickabilityOfElement(linkTvs);
    linkTvs.click();
    logger.info("Нажата ссылка \"Телевизоры\"");
  }
  // Снятие скриншота страницы "Телевизоры"
  public void makeScreenShots() {
    try {
      Screenshot screenshot = new AShot().takeScreenshot(driver);
      ImageIO.write(screenshot.getImage(), "png", new File("temp/01_TelevisorsPage.png"));

    } catch (IOException e) {
      e.printStackTrace();
    }
    logger.info("Сделан скриншот страницы \"Телевизоры\"");
  }
}
