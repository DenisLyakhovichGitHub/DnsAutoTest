package tests.televisors;

import helpers.JSExec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.StartPage;
import pages.TelevisorsProductPage;
import tests.BaseTest;
import pages.TelevisorsPage;

/********** Тест с POM **********/
public class TelevisorsProductPage1_POM_Test extends BaseTest {

  @Test
  // Проверка
  public void selectedProduct_Is_LedSamsungQE75Q950TSUXRUGrey() {

    // Открыть страницу https://www.dns-shop.ru/
    driver.get("https://www.dns-shop.ru/");

    /***** Стартовая страница сайта DNS *****/
    StartPage startPage = new StartPage(driver);
    // Нажатие на кнопку "Да" всплывающего сообщения геолокации
    startPage.linkYesClick();
    // Наведение курсора мыши на ссылку "ТВ и мультимедиа"
    startPage.linkTvAndMultimediaMove();
    // Нажатие на ссылку "Телевизоры"
    startPage.linkTvClick();
    // Снятие скриншота страницы "Телевизоры"
    startPage.makeScreenShots();

    /***** Страница "Телевизоры" *****/
    TelevisorsPage televisorsPage = new TelevisorsPage(driver);
    // Скрытие заголовка страницы
    televisorsPage.hideHeader();
    // Нажатие на выпадающее меню -  "Сортировка"
    televisorsPage.showSortClick();
    // Установка сортировки "Сначала дорогие"
    televisorsPage.rbtnExpensiveClick();
    // Прокрутка страницы вниз до фильтра "Производитель"
    JSExec.scrollBy(0,1000);
    // Установка фильтра "Производитель"
    String company = "Samsung"; // производитель
    televisorsPage.chbxProductClick(company);
    // Прокрутка страницы вниз до фильтра "Частота обновления экрана"
    JSExec.scrollBy(0,1000);
    // Нажатие на фильтр "Диагональ экрана"
    televisorsPage.showScreenDiagonalClick();
    // Установка фильтра "Диагональ экрана"
    String minDiagonal = "60"; //значение текстового поля от
    String maxDiagonal = "80"; //значение текстового поля до
    televisorsPage.enterTextFieldScreenDiagonal(minDiagonal, maxDiagonal);
    // Нажатие на фильтр "Частота обновления экрана"
    televisorsPage.showScreenRefreshRateClick();
    // Установка фильтра "Частота обновления экрана"
    String screen = "120 Гц"; // диаганаль экрана
    televisorsPage.chbxScreenRefreshRateСlick(screen);
    // Прокрутка страницы вниз до фильтра "Тип подсветки экрана"
    JSExec.scrollBy(0,1000);
    // Нажатие на фильтр "Тип подсветки экрана"
    televisorsPage.showTypeLEDClick();
    // Установка фильтра "Тип подсветки экрана"
    String led = "Direct LED"; //тип подсветки
    televisorsPage.chbxTypeLEDСlick(led);
    // Нажатие на кнопку "Применить"
    televisorsPage.btnApplyClick();
    // Задержка для снятия скриншота
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
    // Проверка заголовка открытой страницы
    String expected = "Купить 75\" (189 см) Телевизор LED Samsung QE75Q950TSUXRU серый в интернет магазине DNS. Характеристики, цена Samsung QE75Q950TSUXRU | 8165296";
    String actual = televisorsProductPage.getPageTitle();
    Assertions.assertEquals(expected, actual);
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
  }
}
