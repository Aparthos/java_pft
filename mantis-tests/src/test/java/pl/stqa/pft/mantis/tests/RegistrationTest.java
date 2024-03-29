package pl.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegistrationTest extends TestBase {


  @BeforeMethod
  public void startMailServer() {

    app.mail().start();

  }




  @Test
  public void testRegistration() throws IOException, MessagingException {
    long now = System.currentTimeMillis();
    String email = String.format("user%s@localhost.localdomain", now);
    String user = String.format("user%s" + now);
    String password = "password";
    app.registration().start(user, email);
    List <MailMessage> mailMessages = app.mail().WaitForMail(2,10000);
    findConfirmationLink (mailMessages,email);
    app.registration().finish(confirmationLink, password);
    app.newSesion().login(user, password);
    assertTrue(app.newSesion().login(user, password));
}

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
  mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    regex.getText(mailMessage.text);
  }

  @AfterMethod (alwaysRun = true)
  public void stopMailServer() {

    app.mail().stop();

  }

}
