package pl.stqa.pft.rest;

import java.util.Objects;

public class Issue {
  public int getId() {
    return id;
  }

  public void withId(int id) {
    this.id = id;
    return this;
  }

  public String getSubject() {
    return subject;
  }

  public void withSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Issue issue = (Issue) o;

    if (id != issue.id) return false;
    if (!Objects.equals(subject, issue.subject)) return false;
    return Objects.equals(description, issue.description);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (subject != null ? subject.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    return result;
  }

  public void withDescription(String description) {
    this.description = description;
    return this;
  }

  private int id;
private String subject;
private String description;


}
