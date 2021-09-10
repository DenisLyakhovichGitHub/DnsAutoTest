package tests.televisors;

import helpers.JSExec;
import org.junit.jupiter.api.Test;
import pages.StartPageWithElements;
import pages.TelevisorsPageWithElements;
import pages.TelevisorsProductPage;
import tests.BaseTest;

/********** Тест с PageElements + Matcher + AAA + POM **********/
public class TelevisorsProductPage4_ELEMENTS_Test extends BaseTest {

  @Test
  // Проверка
  public void selectedProduct_Is_LedSamsungQE75Q950TSUXRUGrey() {
    // 1. Arrange
    String company = "Samsung"; // производитель
    String minDiagonal = "60"; // диагональ экрана - значение текстового поля от
    String maxDiagonal = "80"; // диагональ экрана - значение текстового поля до
    String screenRefreshRate = "120 Гц"; // частота обновления экрана
    String led = "Direct LED"; //тип подсветки

    // 2. Act
    TelevisorsProductPage televisorsProductPage = getProductPage(company, minDiagonal, maxDiagonal, screenRefreshRate, led);

    // 3. Assert
    String expected = "Технические характеристики 75\" (189 см) Телевизор LED Samsung QE75Q950TSUXRU серый | 8165296 . Интернет-магазин DNS";
    TelevisorsProductPageAssert televisorsProductAssert = new TelevisorsProductPageAssert(televisorsProductPage);
    televisorsProductAssert.pageTitleEquals(expected);
  }

  public TelevisorsProductPage getProductPage(String company, String minDiagonal, String maxDiagonal, String screenRefreshRate, String led) {
    // Открыть страницу https://www.dns-shop.ru/
    driver.get("https://www.dns-shop.ru/");

    /***** Стартовая страница сайта DNS *****/
    StartPageWithElements startPage = new StartPageWithElements(driver);
    // Нажатие на кнопку "Да" всплывающего сообщения геолокации
    startPage.linkYesClick();
    // Наведение курсора мыши на ссылку "ТВ и мультимедиа"
    startPage.linkTvAndMultimediaMove();
    // Нажатие на ссылку "Телевизоры"
    startPage.linkTvClick();
    // Снятие скриншота страницы "Телевизоры"
    startPage.makeScreenShots();

    /***** Страница "Телевизоры" *****/
    TelevisorsPageWithElements televisorsPage = new TelevisorsPageWithElements(driver);
    // Скрытие заголовка страницы
    televisorsPage.mainBlockHide();
    // Нажатие на выпадающее меню -  "Сортировка"
    televisorsPage.accordeonSortClick();
    // Установка сортировки "Сначала дорогие"
    televisorsPage.rbtnExpensiveClick();
    // Прокрутка страницы вниз до фильтра "Производитель"
    JSExec.scrollBy(0,1000);
    // Установка фильтра "Производитель"
    televisorsPage.chbxCompanyClick(company);
    // Прокрутка страницы вниз до фильтра "Частота обновления экрана"
    JSExec.scrollBy(0,1000);
    // Нажатие на фильтр "Диагональ экрана"
    televisorsPage.accordeonScreenDiagonalClick();
    // Установка фильтра "Диагональ экрана"
    televisorsPage.enterTextFieldScreenDiagonal(minDiagonal, maxDiagonal);
    // Нажатие на фильтр "Частота обновления экрана"
    televisorsPage.accordeonScreenRefreshRateClick();
    // Установка фильтра "Частота обновления экрана"
    televisorsPage.chbxScreenRefreshRateClick(screenRefreshRate);
    // Прокрутка страницы вниз до фильтра "Тип подсветки экрана"
    JSExec.scrollBy(0,1000);
    // Нажатие на фильтр "Тип подсветки экрана"
    televisorsPage.accordeonTypeLEDClick();
    // Установка фильтра "Тип подсветки экрана"
    televisorsPage.chbxSTypeLEDClick(led);
    // Нажатие на кнопку "Применить"
    televisorsPage.btnApplyClick();
    // Ожидание возврата на верх страницы для последующего снятия скриншота
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // Снятие скриншота страницы "Телевизоры отстртированные"
    televisorsPage.makeScreenShots();
    // Нажатие на ссылку первого продукта в списке
    televisorsPage.linkFirstProductClick("Телевизор LED Samsung QE75Q950TSUXRU серый");
    // Запуск в нового окна в полноэкранном режиме
    driver.manage().window().fullscreen();
    // Нажатие на кнопку "Да" всплывающего сообщения геолокации в открывшемся окне
    startPage.linkYesClick();

    /***** Страница "Продукта Телевизоры" *****/
    TelevisorsProductPage televisorsProductPage = new TelevisorsProductPage(driver);
    // Снятие скриншота страницы "Продукта Телевизоры"
    televisorsProductPage.makeScreenShots();
    // Прокрутка страницы вниз до фильтра "Характеристики"
    JSExec.scrollBy(0,1000);
    // Нажатие на ссылку "Характеристики"
    televisorsProductPage.linkSpecificationsClick();
    // Задержка для снятия скриншота страницы с "Характеристики"
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // Снятие скриншота страницы с "Характеристики"
    televisorsProductPage.makeScreenShotsSpecifications();
    // Проверки Характеристик:
    // Проверка Характеристики - модель производителя
    televisorsProductPage.modelSpecificationsAssertions();
    // Проверка Характеристики - диаганаль экрана
    televisorsProductPage.screenDiagonalSpecificationsAssertions();
    // Проверка Характеристики - частоты обновления экрана
    televisorsProductPage.screenRefreshRateSpecificationsAssertions();
    // Проверка Характеристики - тип подсветки экрана телевизора
    televisorsProductPage.typeLEDSpecificationsAssertions();
    return new TelevisorsProductPage(driver);
  }
}
