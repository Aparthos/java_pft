package pl.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.adressbook.model.ContactData;
import pl.stqa.pft.adressbook.model.Contacts;
import pl.stqa.pft.adressbook.model.GroupData;
import pl.stqa.pft.adressbook.model.Groups;

import java.sql.*;

public class DbConnectionTest {

@Test
public void testDbConnection() {


  Connection conn = null;

  try {
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");

    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("select group_id, group_name, group_header, group_footer from group_list");
    Groups groups = new Groups();
    while (rs.next()) {
     groups.add(new GroupData().withtId(rs.getInt("group_id")).withName(rs.getString("group_name"))
             .withHeader(rs.getString("group_header")).withFooter(rs.getString("group_footer")));




    }
    rs.close();
    st.close();
    conn.close();
    System.out.println(groups);
    // Do something with the Connection


  } catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
  }


  }

  @Test
  public void testDbConnectionC() {


    Connection conn = null;

    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");

      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select contact_id, contact_name, contact_surname from addressbook");
      Contacts contacts = new Contacts();
      while (rs.next()) {
        contacts.add(new ContactData().withId(rs.getInt("contact_id")).withName(rs.getString("contact_name")).
                withSurname(rs.getString("contact_surname")));



      }

      rs.close();
      st.close();
      conn.close();
      System.out.println(contacts);

      // Do something with the Connection




    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }


  }

}
