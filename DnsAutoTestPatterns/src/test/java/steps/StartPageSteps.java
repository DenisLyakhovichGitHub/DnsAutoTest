package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.StartPageWithElements;

// Шаги на странице "Стартовая"
public class StartPageSteps {
  // Логгер
  private Logger logger = LogManager.getLogger(StartPageSteps.class);

  // Ссылка на объект класса StartPageWithElements
  private StartPageWithElements startPage;

  // Конструктор
  public StartPageSteps(StartPageWithElements startPage) {
    // ***** Стартовая страница сайта DNS *****
    this.startPage = startPage;
    logger.info("Открыта страница [Стартовая страница DNS]");
  }

  // Нажатие на ссылку "Телевизоры"
  public void clickLinkSmarts() {
    // Наведение курсора мыши на ссылку "TB и мультимедиа"
    startPage.linkTvAndMultimediaMove();
    // Нажатие на ссылку "Телефоны"
    startPage.linkTvClick();
  }
}
