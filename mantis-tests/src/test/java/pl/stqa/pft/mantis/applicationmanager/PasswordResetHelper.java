package pl.stqa.pft.mantis.applicationmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pl.stqa.pft.mantis.tests.TestBase;
import ru.lanwen.verbalregex.VerbalExpression;

import java.util.List;

public class PasswordResetHelper {

package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations .*;
import static org.testng.Assert .*;
import org.openqa.selenium .*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

  public class ResetPassword extends TestBase {
    private WebDriver wd;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
    public void startMailServer() {

      app.mail().start();

    }

    @Test
    public void ResetPassword() throws Exception {


      String email = String.format("user%s@localhost.localdomain");
      String user = String.format("user%s");

      wd.get("http://localhost/mantisbt-1.2.20/signup_page.php");
      wd.findElement(By.linkText("Lost your password?")).click();
      wd.findElement(By.name("username")).clear();
      wd.findElement(By.name("username")).sendKeys(user);
      wd.findElement(By.name("email")).sendKeys(email);
      wd.findElement(By.xpath("//input[@value='Submit']")).click();
    }


    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
      mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
      VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
      regex.getText(mailMessage.text);
    }


    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {

      app.mail().stop();
    }


  }
}