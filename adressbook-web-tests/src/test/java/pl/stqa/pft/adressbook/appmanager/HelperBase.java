package pl.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {

  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }



  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);

    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);


      }
    }
  }

  public void acceptAlert() {

    wd.switchTo().alert().accept();

  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public void waitForDynamicElement(By locator) {

    WebElement myDynamicElement = (new WebDriverWait(wd, Duration.ofSeconds(3)))
            .until(ExpectedConditions.presenceOfElementLocated(locator));
  }
}