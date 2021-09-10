package pages;

import elements.Link;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

// Стартовая страница сайта DNS
public class StartPageWithElements extends BasePage {
  // Логгер
  private Logger logger = LogManager.getLogger(StartPageWithElements.class);
  // URL страницы
  private final String URL = "https://www.dns-shop.ru/";

  // ***** Локаторы *****
  // Кнопка "Да" на всплывающем сообщении геолокации
  String linkTextYes = "Да";
  // Ссылка на раздел "TB и мультимедиа"
  String linkTextTvAndMultimedia = "ТВ и мультимедиа";
  // Ссылка на раздел "Телевизоры"
  String linkTvXpath = "(//a[contains(text(), \"Телевизоры\")])[2]";

  // Конструктор класса
  public StartPageWithElements(WebDriver driver) {
    // Вызов родительского конструктора
    super(driver);
  }

  // Получение URL страницы
  public String getURL() {
    return this.URL;
  }

  // Открытие страницы
  public void openPage() {
    driver.get(this.URL);
    logger.info("Открыта страница https://www.dns-shop.ru/");
  }

  // Нажатие на кнопку "Да" всплывающего сообщения геолокации
  public void linkYesClick() {
    Link linkYes = new Link(driver, By.linkText(linkTextYes));
    linkYes.click();
    logger.info("Нажата кнопка \"Да\"");
  }

  // Наведение курсора мыши на ссылку "TB и мультимедиа"
  public void linkTvAndMultimediaMove() {
    Link linkTvAndMultimedia = new Link(driver, By.linkText(linkTextTvAndMultimedia));
    linkTvAndMultimedia.focusOnLink();
    logger.info("Курсор мыши наведен на ссылку \"TB и мультимедиа\"");
  }

  // Нажатие на ссылку "Телевизоры"
  public void linkTvClick() {
    Link linkTv = new Link(driver, By.xpath(linkTvXpath));
    linkTv.click();
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
