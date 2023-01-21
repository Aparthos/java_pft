package pl.stqa.pft.mantis.applicationmanager;

import pl.stqa.pft.mantis.model.Issue;
import pl.stqa.pft.mantis.model.Project;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SoapHelper {

  private ApplicationManager app;

  public SoapHelper(ApplicationManager app) {
    this.app = app;
  }

  public Set<Project> getProjects() throws MalformedURLException, ServiceExeption, RemoteException {

    MantisConnectPortType mc = getMantisConnect();

    ProjectData[] projects = mc.mc_projects_get_user_accessible("administrator", "root");
    return Arrays.asList(projects).stream().map((p) -> new Project().withId(p.getId().intValue())
            .withName(p.getName())).collect(Collectors.toSet());

  }

  private static MantisConnectPortType getMantisConnect() throws MalformedURLException {
    MantisConnectPortType mc = new MantisConnectLocator()
            .getMantisConnectPort(new URL("http://localhost/mantisbt-1.2.20/api/soap/mantisconnect.php"));
    return mc;
  }

  public Issue addIssue(Issue issue) throws MalformedURLException, ServiceExeption {

    MantisConnectPortType mc = getMantisConnect();
    String[] categories = mc.mc_project_get_categories("administrator", "root", BigInteger.valueOf(issue.getProject().getId()));
    IssueData issueData = new IssueData();
    issueData.setSummary(issue.getSummary());
    issueData.setDescription(issue.getDescription());
    issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId(), issue.getProject().getName())));
    issueData.setCategory(categories[0]);
    BigInteger issueID = mc.mc_issue_add("administrator", "root", issueData);
    IssueData createdIssueData1 = mc.mc_issue_add("administrator", "root", issueData);
    return new Issue().withId(createdIssueData.getId().intValue())
            .withSummary(createdIssueData.getSummary()).withDescription(createdIssueData.getDescription())
            .getProject(new Project().withId(createdIssueData.getProject().getId().intValue())
                    .withName(createdIssueData.getProject().getName));

  }
}
