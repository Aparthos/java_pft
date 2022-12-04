package pl.stqa.pft.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {


@Test
  public void testDistance () {

    Point px = new Point(3, 3);

    Point py = new Point(8, 8);

    Assert.assertEquals(px.getDistance(py),(7.0710678118654755) ) ;



  }

}


