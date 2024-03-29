package pl.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.stqa.pft.mantis.applicationmanager.ApplicationManager;

import java.io.File;
import java.io.IOException;


public class TestBase {


  protected static final ApplicationManager app;

  static {
    try {
      app = new ApplicationManager(System.getProperty("browser", String.valueOf(Browser.FIREFOX)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config.inc.php", "config.inc.php.bak");
    public void skipIfNotFixed(int issueId) {
      if (isIssueOpen(issueId)) {
        throw new SkipException("Ignored because of issue " + issueId);
      }
    }

  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {

    app.ftp().restore("config.inc.php.bak", "config.inc.php");
    app.stop();

  }

  }

