package steps;

import helpers.JSExec;
import models.valueobjects.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.TelevisorsPageWithElements;

// Шаги на странице "Телевизоры"
public class TelevisorsPageSteps {
  // Логгер
  private Logger logger = LogManager.getLogger(TelevisorsPageSteps.class);

  // Ссылка на объект класса SmartphonesPageWithElements
  private TelevisorsPageWithElements televisorsPage;

  // Конструктор
  public TelevisorsPageSteps(TelevisorsPageWithElements televisorsPage) {
    // ***** Страница "Телевизоры" *****
    this.televisorsPage = televisorsPage;
    logger.info("Открыта страница [Телевизоры]");
  }

  // Установка сортировки "Сначала дорогие"
  public void orderByExpensiveFirst() {
    // Нажатие на выпадашку "Сортировка"
    televisorsPage.accordeonSortClick();
    // Установка сортировки "Сначала дорогие"
    televisorsPage.rbtnExpensiveClick();
  }

  // Установка фильтра "Производитель"
  public void filterByCompany(Company company) {
    // Прокрутка страницы вниз
    JSExec.scrollBy(0, 300);
    // Установка фильтра "Производитель"
    televisorsPage.chbxCompanyClick(company.getCompany());
  }

  // Нажатие на кнопку "Применить"
  public void clickButtonApply() {
    // Прокрутка страницы вниз
    JSExec.scrollBy(0, 300);
    // Нажатие на кнопку "Применить"
    televisorsPage.btnApplyClick();
  }

  // Нажатие на ссылку первого продукта в списке
  public void clickLinkFirstProduct(String product) {
    // Прокрутка страницы вверх
    JSExec.scrollBy(0, -500);
    // Нажатие на ссылку первого продукта в списке
    televisorsPage.linkFirstProductClick("Телевизор LED Samsung QE75Q950TSUXRU серый");
  }
}
