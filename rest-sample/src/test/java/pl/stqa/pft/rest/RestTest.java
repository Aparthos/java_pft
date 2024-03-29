package pl.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTest {


@Test
  public void testCreationIssue() throws IOException {


    Set<Issue> oldIssues = getIssues();
    Issue = new Issue().withSubject("Test Issue").withDescription("New test issue");
    int issueId = createIssue(newIssue);
    Set<Issue> newIssues = getIssues();
    oldIssues.add(newIssues.withId(issueId));
    assertEquals(newIssue, oldIssues);
}

  private Set<Issue> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues.json"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");

    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>()().getType());
}

private Executor getExecutor() {

  return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");

}

private int createIssue(Issue newIssue) {
    String json = getExecutor().execute(Request.Post("http://demo.bugify.com/api/issues.json").bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()),
                    new BasicNameValuePair("description", newIssue.getDescription())));
            .returnContent().asString();
  JsonElement parsed = new JsonParser().parse(json);
  return parsed.getAsJsonObject().get("issue_id").getAsInt();


  }

}
