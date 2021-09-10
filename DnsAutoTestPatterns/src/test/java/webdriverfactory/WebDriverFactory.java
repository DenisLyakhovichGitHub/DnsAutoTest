package webdriverfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

// Фабрика по созданию экземпляров драйвера браузера
public class WebDriverFactory {
  // Драйвер
  protected static WebDriver driver;
  // Логгер
  private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

  // Получение экземпляра драйвера по имени
  public static WebDriver getDriver(BrowserName name, OptionName option) {
    // Установка стратегии загрузки страницы
    PageLoadStrategy pageLoadStrategy;
    switch (option) {
      // Стратегия загрузки страницы - NORMAL
      case NORMAL:
        pageLoadStrategy = PageLoadStrategy.NORMAL;
        logger.info("Стратегия загрузки страницы - " + pageLoadStrategy);
        break;
      // Стратегия загрузки страницы - EAGER
      case EAGER:
        pageLoadStrategy = PageLoadStrategy.EAGER;
        logger.info("Стратегия загрузки страницы - " + pageLoadStrategy);
        break;
      // Стратегия загрузки страницы - NONE
      case NONE:
        pageLoadStrategy = PageLoadStrategy.NONE;
        logger.info("Стратегия загрузки страницы - " + pageLoadStrategy);
        break;
      default:
        pageLoadStrategy = PageLoadStrategy.NORMAL;
        logger.info("Стратегии загрузки страницы с таким названием нет. Будет включена стратегия по умолчанию - normal");
        break;
    }
    // Установка браузера
    switch (name) {
      // Драйвер браузера Google Chrome
      case CHROME:
        logger.info("Драйвер браузера Google Chrome");
        return ChromeBrowser.getDriver(pageLoadStrategy);
      // Драйвер браузера Mozilla Firefox
      case FIREFOX:
        logger.info("Драйвер браузера Mozilla Firefox");
        return FirefoxBrowser.getDriver(pageLoadStrategy);
      // По умолчанию
      default:
        throw new RuntimeException("Некорректное наименование браузера");
    }
  }
}
