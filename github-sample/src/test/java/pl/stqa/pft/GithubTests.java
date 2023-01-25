package pl.stqa.pft;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

public class GithubTests {

@Test
  public void testCommits() {

  Github github = new RtGithub("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");
  RepoCommits commits = github.repos().get(new Coordinates.Simple("Aparthos", "java_pft")).commits();
  for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
    System.out.println(new RepoCommit.Smart(commit).message());
    }


  }

}





