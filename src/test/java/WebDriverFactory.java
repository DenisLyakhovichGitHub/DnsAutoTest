import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import java.lang.*;


public class WebDriverFactory {

  private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);

  public static WebDriver getDriver(String browserName,String pageLoadStrategy) {

    if (pageLoadStrategy.equals("NORMAL")|| pageLoadStrategy.equals("EAGER") || pageLoadStrategy.equals("NONE")){

      switch (browserName) {
        case "chrome":
          WebDriverManager.chromedriver().setup();
          ChromeOptions optionsChrome = new ChromeOptions();
          //специфические настройки браузера
          optionsChrome.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
          optionsChrome.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, false);
          optionsChrome.setPageLoadStrategy(PageLoadStrategy.fromString(pageLoadStrategy));
          optionsChrome.addArguments("--incognito");
          optionsChrome.addArguments("--window-size=1920,1080");
          logger.info("Драйвер для браузера Chrome");
          return new ChromeDriver(optionsChrome);

        case "firefox":
          WebDriverManager.firefoxdriver().setup();
          FirefoxOptions optionsFireFox = new FirefoxOptions();
          //специфические настройки браузера
          optionsFireFox.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
          optionsFireFox.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, false);
          optionsFireFox.setPageLoadStrategy(PageLoadStrategy.fromString(pageLoadStrategy));
          optionsFireFox.addArguments("-private");
          optionsFireFox.addArguments("--window-size=1920,1080");
          logger.info("Драйвер для браузера Firefox");
          return new FirefoxDriver(optionsFireFox);

        default:
          throw new RuntimeException("Incorrect browser name");
      }

   } else {
      throw new RuntimeException("Incorrect page load strategy");
    }
  }
}

