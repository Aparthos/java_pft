package pl.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class RestAssuredTest {

@BeforeClass

public void init() {

  RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==", "");

}


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


    String json = RestAssured.get("http://demo.bugify.com/api/issues.json").asString();

    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");

    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>()().getType());
}



private int createIssue(Issue newIssue) {


  String json = RestAssured.given().parameter("subject", newIssue.getSubject())
          .parameter("description", newIssue.getDescription())
          .post("http://demo.bugify.com/api/issues.json").asString();

          JsonElement parsed = new JsonParser().parse(json);
  return parsed.getAsJsonObject().get("issue_id").getAsInt();


  }

}
