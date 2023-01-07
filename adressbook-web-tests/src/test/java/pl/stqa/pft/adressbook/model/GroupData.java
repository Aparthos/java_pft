package pl.stqa.pft.adressbook.model;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Type;

import java.util.Objects;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")

public class GroupData {

  @XStreamOmitField
  @Id
  @Column(name = "group_id")
  private int id = Integer.MAX_VALUE;
  @Column(name = "group_name")
  private String name;
  @Column(name = "group_header")

  private String header;
  @Column(name = "group_footer")

  private String footer;




  public int getId() {
    return id;
  }

  public GroupData withtId(int id) {
    this.id = id;
    return this;

  }

    public GroupData withName(String name) {
      this.name = name;
      return this;
  }

    public GroupData withHeader(String header) {
      this.header = header;
      return this;
  }

    public GroupData withFooter(String footer) {
      this.footer = footer;
      return this;
  }

      public String getName () {
        return name;

  }

      public String getFooter () {
        return footer;

  }


      public String getHeader () {
        return header;
      }

      @Override
      public String toString () {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
      }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    return Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }


}


