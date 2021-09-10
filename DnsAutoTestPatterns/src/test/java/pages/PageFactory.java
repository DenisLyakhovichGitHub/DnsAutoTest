package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

// Фабрика по созданию экземпляров страниц (пейдж обджектов)
public class PageFactory {
  // Инициализация логгера
  private static Logger logger = LogManager.getLogger(PageFactory.class);
  // Получение экземпляра страницы (пейдж обджекта)
  public static BasePage getPage(WebDriver driver, PageName name) {
    switch (name) {
      // Стартовая страница
      case START_PAGE:
        logger.info("Стартовая страница");
        StartPageWithElements startPageWithElements = new StartPageWithElements(driver);
        // Инициализация некоторых элементов страницы
        return startPageWithElements;
      // Страница "Телевизоры"
      case TELEVISORS_PAGE:
        logger.info("Страница \"Телевизоры\"");
        TelevisorsPageWithElements televisorsPageWithElements = new TelevisorsPageWithElements(driver);
        // Инициализация некоторых элементов страницы
        return televisorsPageWithElements;
      // Страница "Продукт. Телевизор"
      case TELEVISOR_PRODUCT_PAGE:
        logger.info("Страница \"Продукт. Телевизор\"");
        TelevisorsProductPage televisorsProductPage = new TelevisorsProductPage(driver);
        // Инициализация некоторых элементов страницы
        return televisorsProductPage;
      // По умолчанию
      default:
        throw new RuntimeException("Некорректное наименование страницы (пейдж обджекта)");
    }
  }
}
