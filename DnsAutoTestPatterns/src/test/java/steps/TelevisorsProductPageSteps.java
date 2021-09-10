package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.TelevisorsProductPage;

// Шаги на странице "Продукт. Теревизор"
public class TelevisorsProductPageSteps {
  // Логгер
  private Logger logger = LogManager.getLogger(TelevisorsProductPageSteps.class);

  // Ссылка на объект класса TelevisorProductPage
  private TelevisorsProductPage televisorsProductPage;

  // Конструктор
  public TelevisorsProductPageSteps(TelevisorsProductPage televisorsProductPage) {
    // ***** Страница "Продукт. Телевизор" *****
    this.televisorsProductPage = televisorsProductPage;
    logger.info("Открыта страница [Продукт. Телевизор]");
  }

  // Получение заголовка текущей страницы
  public String pageTitle() {
    return televisorsProductPage.getPageTitle();
  }
}
