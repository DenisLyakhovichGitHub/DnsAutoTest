import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;


public class DriverListener implements WebDriverListener {

  private Logger logger = LogManager.getLogger(DriverListener.class);

  @Override
  public void beforeFindElement(WebDriver driver, By locator) {
    logger.info("До поиска элемента " + locator);
  }

  @Override
  public void afterFindElement(WebDriver driver, By locator, WebElement result) {
    logger.info("После поиска элемента " + locator + " An Element <" + result.getTagName() + ">");
  }

  @Override
  public void beforeClick(WebElement element) {
    logger.info("До осуществления клика по элементу <" + element.getTagName() + ">");
  }

  @Override
  public void afterClick(WebElement element) {
    logger.info("После осуществления клика по элементу <" + element.getTagName() + ">");
  }
}
