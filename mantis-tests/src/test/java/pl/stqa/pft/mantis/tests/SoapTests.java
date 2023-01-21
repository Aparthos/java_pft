package pl.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.mantis.model.Issue;
import pl.stqa.pft.mantis.model.Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownServiceException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class SoapTests extends TestBase {

@Test
  public void testGetProject() throws MalformedURLException, ServiceExeption, RemoteException {

  Set<Project> projects = app.soap().getProjects();
  System.out.println(projects.size());
  for (Project project : projects) {
    System.out.println(project.getName());

  }
}
    @Test

       public void testCreateIssue() {

        Issue issue = new Issue().withSummary("Test issue").withDescription("Test issue description")
                .withProject(project.iterator().next());

        Issue created = app.soap().addIssue(issue);
      assertEquals(issue.getSummary(), created);
  }

}
