package pl.stqa.pft.mantis.tests;


import org.testng.annotations.Test;
import pl.stqa.pft.mantis.applicationmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTest  extends TestBase{


@Test
public void testLogin() throws IOException {

  HttpSession session = app.newSesion();
  assertTrue(session.login("administrator", "root"));
  assertTrue(session.isLoggedInAs("administrator"));



}


}
