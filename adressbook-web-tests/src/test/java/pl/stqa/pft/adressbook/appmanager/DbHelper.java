package pl.stqa.pft.adressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.stqa.pft.adressbook.model.ContactData;
import pl.stqa.pft.adressbook.model.Contacts;
import pl.stqa.pft.adressbook.model.GroupData;
import pl.stqa.pft.adressbook.model.Groups;

import java.util.List;

public class DbHelper {


  private SessionFactory sessionFactory;

  protected void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();

    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    }


  public Groups groups() {


    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery( "from GroupData where deprecated = '0000-00-00' ").list();
    for ( GroupData group : (List<GroupData>) result ) {
      System.out.println(group);
    }
    session.getTransaction().commit();
    session.close();
    return new Groups(result);

  }

  public Contacts contacts() {

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery( "from ContactData where deprecated = '0000-00-00' ").list();
    for ( ContactData contact : (List<ContactData>) result ) {
      System.out.println(contact);
    }
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);

  }




  }




